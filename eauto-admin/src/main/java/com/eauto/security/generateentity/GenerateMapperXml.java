package com.eauto.security.generateentity;

/**
 * User:Administrator
 * Date:2021/9/29
 * Time:11:46
 * Description: No Description
 */

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class GenerateMapperXml {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String dbname = "";
    private DatabaseMetaData dbMetaData = null;
    private String packageNameMybatisDao = "";
    private String packageNamedomain = "";
    private String path = "";

    public GenerateMapperXml(DatabaseMetaData dbMetaData, String dbname, String modelname, String path) {
        this.dbMetaData = dbMetaData;
        this.dbname = dbname;
        packageNameMybatisDao = "com.wp.eauto." + modelname + ".mapper";
        packageNamedomain = "com.wp.eauto." + modelname + ".domain";
        this.path = path;
    }

    /**
     * @param tableName
     * @Description: 获取表对应的所有列
     * @author: ppt
     * @date: 2015-3-16 上午10:13:17
     * @return: void
     */
    public void getTableColumns(String tableName) {
        try {
            ResultSet resultSetColumn = dbMetaData.getColumns(null, null,
                    tableName, null);
            String className = getFormatString(tableName, true);//表名
            String fileName = className + "Mapper";//文件名
            String thisFileName = className + "Mapper";//接口地址
            StringBuffer header = new StringBuffer(
                    "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
            header.append("<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">\n");
            header.append("<mapper namespace=\"");
            header.append(packageNameMybatisDao + "." + thisFileName);
            header.append("\">\n\n");
            StringBuffer footer = new StringBuffer("\n</mapper>");
            StringBuffer add = new StringBuffer();
            //增加数据
            add.append("\t<insert id=\"addEntity\" parameterType=\"" + packageNamedomain + "." + className + "\">\n");
            String insert = "\t\tinsert into " + tableName + "(";
            String column = "";
            String values = "";
            //删除数据
            StringBuffer delete = new StringBuffer();
            delete.append("\t<update id=\"deleteEntity\" parameterType=\"long\">\n");
            delete.append("\t\tupdate " + tableName + " set status = -1 where id = #{id}\n");
            delete.append("\t</update>\n\n");
            //更新数据
            StringBuffer update = new StringBuffer();
            String updateConent = "";
            update.append("\t<update id=\"updateEntity\" parameterType=\"" + packageNamedomain + "." + className + "\">\n");
            update.append("\t\tupdate " + tableName + " set ");
            //查找数据
            StringBuffer select = new StringBuffer();
            select.append("\t<select id=\"findEntity\" parameterType=\"" + packageNamedomain + "." + className + "\" resultType=\"" + packageNamedomain + "." + className + "\">\n");
            String selectContent = "\t\tselect\n";
            //查找数据list
            StringBuffer selectList = new StringBuffer();
            selectList.append("\t<select id=\"findEntityList\" parameterType=\"" + packageNamedomain + "." + className + "\" resultType=\"" + packageNamedomain + "." + className + "\">\n");
            while (resultSetColumn.next()) {
                String columnName = resultSetColumn.getString("COLUMN_NAME");
                String oldColumnName = columnName;
                columnName = this.getFormatString(columnName, false);
                //增加数据
                if ("ID".equals(columnName.toUpperCase())) {
                    continue;
                }
                column += columnName + ",";
                values += "#{" + columnName + "},";
                //删除数据

                //更新数据
                updateConent += oldColumnName + "=#{" + columnName + "},";
                //查找数据
                selectContent += "\t\t" + oldColumnName + " AS " + columnName + ",\n";
            }
            selectContent = selectContent.substring(0, selectContent.length() - 2);
            selectContent += "\n\t\tfrom " + tableName + "\n";
            select.append(selectContent);
            select.append("\t</select>\n\n");
            selectList.append(selectContent);
            selectList.append("\t</select>\n\n");
            updateConent = updateConent.substring(0, updateConent.length() - 1);
            update.append(updateConent);
            update.append(" where id = #{id}\n");
            update.append("\t</update>\n\n");
            column = column.substring(0, column.length() - 1);
            values = values.substring(0, values.length() - 1);
            String statement = insert + column + ") values(" + values + ")\n";
            add.append(statement);
            add.append("\t</insert>\n\n");
            header.append(add);
            header.append(delete);
            header.append(update);
            header.append(select);
            header.append(selectList);
            header.append(footer);
//          System.out.println(header.toString());
            this.outputToFile(fileName + ".xml", header.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 处理字符串，去掉下划线“_”，并且把下划线的下一个字符变大写，flag为true，表示首字母要大写
     *
     * @param name
     * @param flag
     * @return
     */
    private String getFormatString(String name, boolean flag) {
        name = name.toLowerCase();
        String[] nameTemp = name.split("_");
        StringBuffer buffer = new StringBuffer();
        for (String str : nameTemp) {
            String head = str.substring(0, 1).toUpperCase();
            String tail = str.substring(1);
            buffer.append(head + tail);
        }
        StringBuffer result = null;
        if (!flag) {
            result = new StringBuffer();
            String head = buffer.substring(0, 1).toLowerCase();
            String tail = buffer.substring(1);
            result.append(head + tail);
            return result.toString();
        }
        return buffer.toString();
    }

    /**
     * 把String内容写到文件
     *
     * @param fileName
     * @param content
     */
    private void outputToFile(String fileName, String content) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(path + fileName);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
        byte[] b = content.getBytes();
        try {
            os.write(b);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 删除指定文件夹下所有文件
     */
    public boolean delAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            return flag;
        }
        if (!file.isDirectory()) {
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {
                temp = new File(path + File.separator + tempList[i]);
            }
            if (temp.isFile()) {
                temp.delete();
            }
            if (temp.isDirectory()) {
                delAllFile(path + "/" + tempList[i]);//先删除文件夹里面的文件
                flag = true;
            }
        }
        return flag;
    }


}
