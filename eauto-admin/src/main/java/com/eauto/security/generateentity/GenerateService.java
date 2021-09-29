package com.eauto.security.generateentity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
 * Time:11:43
 * Description: No Description
 */


public class GenerateService {

    private String authorName = "Andy";
    private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private String dbname = "";
    private List<String> tableList=null;
    private String packageName = "";
    private String packageNameDto = "";
    private String path = "";

    public GenerateService(List<String> tableList, String dbname, String modelname, String path) {
        this.tableList = tableList;
        this.dbname = dbname;
          packageName = "com.wp.eauto." + modelname + ".service;";
          packageNameDto = "com.wp.eauto." + modelname + ".service";
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

    public void getService() {
        for (String tableName : tableList) {
            String table = getFormatString(tableName, true);
            String className = table + "Service";
            StringBuffer sb = new StringBuffer();

            sb.append("package " + packageName + "\n\n");
            sb.append("import " + packageNameDto + "." + table + ";\n");
            sb.append("import java.util.List;\n");
//            sb.append("import javax.ws.rs.POST;\n");
//            sb.append("import javax.ws.rs.GET;\n");
//            sb.append("import javax.ws.rs.PathParam;\n");
//            sb.append("import javax.ws.rs.Path;\n");
//            sb.append("import javax.ws.rs.Produces;\n");
//            sb.append("import javax.ws.rs.core.MediaType;\n");
//            sb.append("\n@Path(\"/" + className.substring(0, 1).toLowerCase() + className.substring(1) + "\")\n");


            // 注释部分
            sb.append("\r\n");
            sb.append("/**\r\n");
            sb.append(" * table name:  " + tableName + "\r\n");
            sb.append(" * author name: " + authorName + "\r\n");
            sb.append(" * create time: " + SDF.format(new Date()) + "\r\n");
            sb.append(" */ \r\n");
            sb.append("\r\n");

            sb.append("public interface " + className + " {\n\n");

            sb.append("\t//增加实体\n");
//            sb.append("\t@POST\n");
//            sb.append("\t@Path(\"addEntity\")\n");
//            sb.append("\t@Produces(MediaType.APPLICATION_XML)\n");
//            sb.append("\tpublic long addEntity(" + table + " dto) throws Exception;\n\n");
            sb.append("\tlong addEntity(" + table + " param) throws Exception;\n\n");

            sb.append("\t//删除实体\n");
//            sb.append("\t@GET\n");
//            sb.append("\t@Path(\"deleteEntity/{id}\")\n");
//            sb.append("\t@Produces(MediaType.APPLICATION_XML)\n");
//            sb.append("\tpublic boolean deleteEntity(@PathParam(\"id\") long id) throws Exception;\n\n");
            sb.append("\tboolean deleteEntity(@PathParam(\"id\") long id) throws Exception;\n\n");

            sb.append("\t//修改实体\n");
//            sb.append("\t@POST\n");
//            sb.append("\t@Path(\"updateEntity\")\n");
//            sb.append("\t@Produces(MediaType.APPLICATION_XML)\n");
//            sb.append("\tpublic long updateEntity(" + table + " dto) throws Exception;\n\n");
            sb.append("\tlong updateEntity(" + table + " param) throws Exception;\n\n");

            sb.append("\t//查询实体\n");
//            sb.append("\t@POST\n");
//            sb.append("\t@Path(\"findEntity\")\n");
//            sb.append("\t@Produces(MediaType.APPLICATION_XML)\n");
//            sb.append("\tpublic "+table+" findEntity(" + table + " dto) throws Exception;\n\n");
            sb.append("\t" + table + " findEntity(" + table + " param) throws Exception;\n\n");

            sb.append("\t//查询实体List\n");
//            sb.append("\t@POST\n");
//            sb.append("\t@Path(\"findEntityList\")\n");
//            sb.append("\t@Produces(MediaType.APPLICATION_XML)\n");
//            sb.append("\tpublic List<"+table+"> findEntityList(" + table + " dto) throws Exception;\n\n");
            sb.append("\tList<" + table + "> findEntityList(" + table + " param) throws Exception;\n\n");

            sb.append("}\n");
            outputToFile(className + ".java", sb.toString());
        }
    }


}
