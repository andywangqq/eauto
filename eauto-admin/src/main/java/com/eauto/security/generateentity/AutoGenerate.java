package com.eauto.security.generateentity;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User:Administrator
 * Date:2021/9/29
 * Time:18:06
 * Description: No Description
 */
public class AutoGenerate {
    private static String dbname = "eauto";
    private static String modelname = "employee";

//    数据库配置
    private static String url = "jdbc:mysql://127.0.0.1:3306/eauto?characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
    private static String username = "root";
    private static String password = "root@3306";
    private static String driverClass = "com.mysql.jdbc.Driver";
    public DatabaseMetaData dbMetaData = null;
    private static String path = "D:\\home\\generate\\";

    public AutoGenerate(){
        try {
            Class.forName(driverClass);
            Connection conn = DriverManager.getConnection(url, username, password);
            dbMetaData = conn.getMetaData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] agrs) {

        AutoGenerate ag = new AutoGenerate();
        List<String> tableList = ag.getAllTableList();
        for (String tableName : tableList) {
            //生成实体
            GenerateEntity ge  = new GenerateEntity(ag.dbMetaData,dbname,modelname,path+"entity\\");
            ge.getTableColumns(tableName);

            //生成mapperxml
            GenerateMapperXml gm  = new GenerateMapperXml(ag.dbMetaData,dbname,modelname,path+"mapperxml\\");
            gm.getTableColumns(tableName);

        }

        //生成mapper
        GenerateMapper gm = new GenerateMapper(tableList,dbname, modelname,path+"mapper\\");
        gm.getService();

        //生成service
        GenerateService gs = new GenerateService(tableList,dbname, modelname,path+"service\\");
        gs.getService();

        //生成serviceimpl
        GenerateServiceImpl gsi = new GenerateServiceImpl(tableList,dbname, modelname,ag.path+"serviceimpl\\");
        gsi.getService();
//      aa.getTableColumns("REPORT_REQ");
    }

    /**
     * @Description: 获取所以的表
     * @author: ppt
     * @date: 2015-3-16 上午10:12:57
     * @return: void
     */
    public List<String> getAllTableList() {
        List<String> tableList = new ArrayList<String>();
        try {
            String[] types = {"TABLE"};
            ResultSet rs = dbMetaData.getTables(dbname, "", "%", types);
            while (rs.next()) {
                String tableName = rs.getString("TABLE_NAME");  //表名
                tableList.add(tableName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tableList;
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

}
