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
 * Time:11:45
 * Description: No Description
 */


import org.springframework.beans.factory.annotation.Autowired;

public class GenerateServiceImpl {

    private String authorName = "Andy";
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String dbname="";
    private List<String> tableList = null;
    private String packageName = "";
    private String packageNameService = "";
    private String packageNameDto = "";
    private String packageNameMybatis = "";
    private String path = "";

    public GenerateServiceImpl(List<String> tableList, String dbname, String modelname, String path) {
        this.tableList = tableList;
        this.dbname = dbname;
          packageName = "com.wp.eauto."+modelname+".service.impl;";
          packageNameService = "com.wp.eauto."+modelname+".service";
          packageNameDto = "com.wp.eauto."+modelname+".domain";
          packageNameMybatis = "com.wp.eauto."+modelname+".mapper";
        this.path = path;
    }

    /**
     * 处理字符串，去掉下划线“_”，并且把下划线的下一个字符变大写，flag为true，表示首字母要大写
     * @param name
     * @param flag
     * @return
     */
    private String getFormatString(String name, boolean flag) {
        name = name.toLowerCase();
        String[] nameTemp = name.split("_");
        StringBuffer buffer = new StringBuffer();
        for(String str : nameTemp) {
            String head = str.substring(0, 1).toUpperCase();
            String tail = str.substring(1);
            buffer.append(head+tail);
        }
        StringBuffer result = null;
        if(!flag) {
            result = new StringBuffer();
            String head = buffer.substring(0, 1).toLowerCase();
            String tail = buffer.substring(1);
            result.append(head+tail);
            return result.toString();
        }
        return buffer.toString();
    }
    /**
     * 把String内容写到文件
     * @param fileName
     * @param content
     */
    private void outputToFile(String fileName, String content) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(path+fileName);
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
        for(String tableName : tableList) {
            String table = getFormatString(tableName, true);
            String mybatis = table + "Mapper";
            String dto = table;
            String service = table + "Service";
            String className = service + "Impl";
            StringBuffer sb = new StringBuffer();
            sb.append("package " + packageName + "\n\n");
            sb.append("import " + packageNameDto + "." + dto + ";\n");
            sb.append("import " + packageNameMybatis + "." + mybatis + ";\n");
            sb.append("import " + packageNameService + "." + service + ";\n");
            sb.append("import lombok.extern.slf4j.Slf4j;\n");
            sb.append("import org.springframework.beans.factory.annotation.Autowired;\n");
            sb.append("import org.springframework.stereotype.Service;\n");
            sb.append("import java.util.List;\n");

            // 注释部分
            sb.append("\r\n");
            sb.append("/**\r\n");
            sb.append(" * table name:  " + tableName + "\r\n");
            sb.append(" * author name: " + authorName + "\r\n");
            sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
            sb.append(" */ \r\n");
            sb.append("\r\n");

            sb.append("@Slf4j\n");
            sb.append("@Service(\""+service.substring(0,1).toLowerCase()+service.substring(1)+"\")\n");
            sb.append("public class " + className + " implements "+ service +" {\n\n");

            String instance = mybatis.substring(0,1).toLowerCase() + mybatis.substring(1);
            sb.append("\t@Autowired\n");
            sb.append("\tprivate "+mybatis+" " + instance +";\n");
            sb.append("\r\n");

            sb.append("\t@Override\n");
            sb.append("\tpublic long addEntity(" + table + " param) throws Exception {\n");
            sb.append("\t\ttry {\n");
            sb.append("\t\t\tlog.info(\"addEntity\");\n");
            sb.append("\t\t\t"+instance+".addEntity(param);\n");
            sb.append("\t\t\treturn 0;\n");
            sb.append("\t\t} catch(Exception e) {\n");
            sb.append("\t\t\tlog.info(\"addEntity异常\");\n");
            sb.append("\t\t\te.printStackTrace();\n");
            sb.append("\t\t\tthrow e;\n");
            sb.append("\t\t}\n");
            sb.append("\t}\n");
            sb.append("\r\n");

            sb.append("\t@Override\n");
            sb.append("\tpublic boolean deleteEntity(long id) throws Exception {\n");
            sb.append("\t\ttry {\n");
            sb.append("\t\t\tlog.info(\"deleteEntity\");\n");
            sb.append("\t\t\t"+instance+".deleteEntity(id);\n");
            sb.append("\t\t\treturn false;\n");
            sb.append("\t\t} catch(Exception e) {\n");
            sb.append("\t\t\tlog.info(\"deleteEntity异常\");\n");
            sb.append("\t\t\te.printStackTrace();\n");
            sb.append("\t\t\tthrow e;\n");
            sb.append("\t\t}\n");
            sb.append("\t}\n");
            sb.append("\r\n");

            sb.append("\t@Override\n");
            sb.append("\tpublic long updateEntity(" + table + " param) throws Exception {\n");
            sb.append("\t\ttry {\n");
            sb.append("\t\t\tlog.info(\"updateEntity\");\n");
            sb.append("\t\t\treturn "+instance+".updateEntity(param);\n");
//            sb.append("\t\t\treturn 0;\n");
            sb.append("\t\t} catch(Exception e) {\n");
            sb.append("\t\t\tlog.info(\"updateEntity异常\");\n");
            sb.append("\t\t\te.printStackTrace();\n");
            sb.append("\t\t\tthrow e;\n");
            sb.append("\t\t}\n");
            sb.append("\t}\n");
            sb.append("\r\n");

            sb.append("\t@Override\n");
            sb.append("\tpublic "+table+" findEntity(" + table + " param) throws Exception {\n");
            sb.append("\t\ttry {\n");
            sb.append("\t\t\tlog.info(\"findEntity\");\n");
            sb.append("\t\t\treturn "+instance+".findEntity(param);\n");
            sb.append("\t\t} catch(Exception e) {\n");
            sb.append("\t\t\tlog.info(\"findEntity异常\");\n");
            sb.append("\t\t\te.printStackTrace();\n");
            sb.append("\t\t\tthrow e;\n");
            sb.append("\t\t}\n");
            sb.append("\t}\n");
            sb.append("\r\n");

            sb.append("\t@Override\n");
            sb.append("\tpublic List<"+table+"> findEntityList(" + table + " param) throws Exception {\n");
            sb.append("\t\ttry {\n");
            sb.append("\t\t\tlog.info(\"findEntityList\");\n");
            sb.append("\t\t\treturn "+instance+".findEntityList(param);\n");
            sb.append("\t\t} catch(Exception e) {\n");
            sb.append("\t\t\tlog.info(\"findEntityList异常\");\n");
            sb.append("\t\t\te.printStackTrace();\n");
            sb.append("\t\t\tthrow e;\n");
            sb.append("\t\t}\n");
            sb.append("\t}\n");

            sb.append("}\n");
//          System.out.println(sb.toString());
            outputToFile(className+".java", sb.toString());
        }
    }


}
