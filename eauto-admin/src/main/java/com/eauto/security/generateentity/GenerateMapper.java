package com.eauto.security.generateentity;

import java.io.*;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * User:Administrator
 * Date:2021/9/29
 * Time:11:44
 * Description: No Description
 */
public class GenerateMapper {

    private String authorName = "Andy";
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String dbname = "";
    private List<String> tableList = null;
    private String packageName = "";
    private String packageNameDto = "";
    private String path = "";


    public GenerateMapper(List<String> tableList, String dbname, String modelname, String path) {
        this.tableList = tableList;
        this.dbname = dbname;
          packageName = "com.wp.eauto." + modelname + ".mapper;";
          packageNameDto = "com.wp.eauto." + modelname + ".domain";
        this.path = path;
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

    public void getService() {
        for (String tableName : tableList) {
            String table = getFormatString(tableName, true);
            String className = table + "Mapper";
            String dto = table;
            StringBuffer sb = new StringBuffer();
            sb.append("package " + packageName + "\n\n");
            sb.append("import " + packageNameDto + "." + dto + ";\n");
            sb.append("import java.util.List;\n");

            // 注释部分
            sb.append("\r\n");
            sb.append("/**\r\n");
            sb.append(" * table name:  " + tableName + "\r\n");
            sb.append(" * author name: " + authorName + "\r\n");
            sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
            sb.append(" */ \r\n");
            sb.append("\r\n");

            sb.append("\npublic interface " + className + " extends BaseMapper<" + table + ">  {\n\n");

            sb.append("\tlong addEntity(" + table + " param);\n\n");

            sb.append("\tboolean deleteEntity(long id);\n\n");

            sb.append("\tlong updateEntity(" + table + " param);\n\n");

            sb.append("\t" + table + " findEntity(" + table + " param);\n\n");

            sb.append("\tList<" + table + "> findEntityList(" + table + " param);\n\n");

            sb.append("}\n");
//          System.out.println(sb.toString());
            outputToFile(className + ".java", sb.toString());
        }
    }


}
