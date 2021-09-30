package com.eauto.security.generateentity;

import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * User:Administrator
 * Date:2021/9/29
 * Time:11:40
 * Description: No Description
 */
public class GenerateEntity {

    private String authorName = "Andy";
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private  String dbname="";
    private DatabaseMetaData dbMetaData = null;
    private String packageName = "";
    private String path = "";

    public GenerateEntity(DatabaseMetaData dbMetaData,String dbname,String modelname,String path){
        this.dbMetaData = dbMetaData;
        this.dbname = dbname;
        packageName = "com.wp.eauto." + modelname + ".domain;";
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
            String ACCESS_DOMAIN = "private";
            ResultSet resultSet = dbMetaData.getColumns(dbname, null, tableName, "%");
            while (resultSet.next()) {

                ResultSet resultSetColumn = dbMetaData.getColumns(dbname, null, tableName, null);

                String className = getFormatString(tableName, true);
                StringBuffer header = new StringBuffer("package " + packageName + "\n\n");
                StringBuffer footer = new StringBuffer();
                StringBuffer sb = new StringBuffer();
                // 注释部分
                sb.append("\r\n");
                sb.append("/**\r\n");
                sb.append(" * table name:  " + tableName + "\r\n");
                sb.append(" * author name: " + authorName + "\r\n");
                sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
                sb.append(" */ \r\n");
                sb.append("\r\n");

                sb.append("public class " + className + "{\n");
                while (resultSetColumn.next()) {
                    sb.append("\t" + ACCESS_DOMAIN + " ");
                    String columnType = resultSetColumn.getString("TYPE_NAME");
                    String COLUMN_TYPE = getColumnType(columnType);
                    if ("Date".equals(COLUMN_TYPE) && !header.toString().contains("import java.util.Date;")) {
                        header.append("import java.util.Date;\n");
                    }
                    sb.append(COLUMN_TYPE + " ");
                    String columnName = resultSetColumn.getString("COLUMN_NAME");
                    String remark = resultSetColumn.getString("REMARKS").replaceAll("\\r\\n|\\n|\\r|    "," ");
                    columnName = this.getFormatString(columnName, false);
                    footer.append(getSetGenerater(columnName, COLUMN_TYPE));
                    sb.append(columnName + ";\t//" + remark + "\n");
                }
                sb.append("\n\n" + footer);
                sb.append("}");
                header.append("\n");
                header.append(sb);
                this.outputToFile(className + ".java", header.toString());
            }
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

    /**
     * 数据库类型转为java类型
     *
     * @param column
     * @return
     */
    private String getColumnType(String column) {
        String COLUMN_TYPE = null;
        if ("VARCHAR".equals(column)) {
            COLUMN_TYPE = "String";
        } else if ("BIGINT".equals(column)) {
            COLUMN_TYPE = "Long";
        } else if ("DATETIME".equals(column)) {
            COLUMN_TYPE = "Date";
        } else if ("INT".equals(column) || "INT UNSIGNED".equals(column)) {
            COLUMN_TYPE = "Integer";
        } else if ("BIGINT UNSIGNED".equals(column)) {
            COLUMN_TYPE = "Long";
        } else if ("TINYINT UNSIGNED".equals(column)) {
            COLUMN_TYPE = "Short";
        } else if ("DECIMAL".equals(column) || "FLOAT".equals(column) || "DOUBLE".equals(column)) {
            COLUMN_TYPE = "Double";
        } else if ("TEXT".equals(column) || "MEDIUMTEXT".equals(column) || "LONGTEXT".equals(column)) {
            COLUMN_TYPE = "String";
        } else if ("TIMESTAMP".equals(column) || "DATE".equals(column) || "DATETIME".equals(column)) {
            COLUMN_TYPE = "Date";
        } else if ("TINYINT".equals(column)) {
            COLUMN_TYPE = "Short";
        } else if ("DECIMAL UNSIGNED".equals(column)) {
            COLUMN_TYPE = "Double";
        } else if ("SMALLINT".equals(column)) {
            COLUMN_TYPE = "Short";
        } else if ("BIT".equals(column)) {
            COLUMN_TYPE = "Short";
        } else if ("CHAR".equals(column)) {
            COLUMN_TYPE = "String";
        } else if ("VARBINARY".equals(column)) {
            COLUMN_TYPE = "byte";
        } else if ("BLOB".equals(column)) {
            COLUMN_TYPE = "byte";
        }
        return COLUMN_TYPE;
    }

    private String getSetGenerater(String columnName, String columnType) {
        StringBuffer sb = new StringBuffer();
        sb.append("\tpublic " + columnType + " get" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1, columnName.length()) + "() {\n");
        sb.append("\t\treturn " + columnName + ";\n");
        sb.append("\t}\n\n");
        sb.append("\tpublic void set" + columnName.substring(0, 1).toUpperCase() + columnName.substring(1, columnName.length()));
        sb.append("(" + columnType + " " + columnName + ") {\n");
        sb.append("\t\tthis." + columnName + " = " + columnName + ";\n");
        sb.append("\t}\n\n");
        return sb.toString();
    }

}
