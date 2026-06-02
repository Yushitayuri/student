package com.student.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//封装“查询”和“更改”的方法
public class DBMySQL {
    static {
        // 创建 DButil 对象，传入数据库账号、密码、数据库名
        DButil dbUtil = new DButil("root", "123456", "db_student");

    }//+

    private static Connection getConnection() {
        return DButil.con;
    }//+

    private static Connection con=DButil.con;
    //实现查询
    public static <T>ResultSet Query(String sql,String ...data){

        try {
            Connection con = getConnection();
            if (con == null) {
                System.out.println("错误：数据库连接为 null，请检查数据库配置");
                return null;
            }
        }//+
        finally {

        }

        try {
            PreparedStatement pst= con.prepareStatement(sql);//初步加载SQL
            for(int i=0;i<data.length;i++){
                pst.setString(i+1,data[i]);
            }
            ResultSet resultSet=pst.executeQuery();//返回结果集合
            return resultSet;



        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static int update(String sql,String ...date){
        try {
            Connection con = getConnection();
            if (con == null) {
                System.out.println("错误：数据库连接为 null");
                return -1;
            }//+
            PreparedStatement pst= con.prepareStatement(sql);//初步加载SQL
            for(int i=0;i<date.length;i++){
                pst.setString(i+1,date[i]);
            }
            return pst.executeUpdate();//返回结果集合

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
            //-1代表报错，0代表更改失败，大于1均正常
        }
    }
}
