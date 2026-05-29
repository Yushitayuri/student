package com.student.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//封装“查询”和“更改”的方法
public class DBMySQL {

    private static Connection con=DButil.con;
    //实现查询
    public static ResultSet Query(String sql,String ...date){
        try {
            PreparedStatement pst= con.prepareStatement(sql);//初步加载SQL
            for(int i=0;i<date.length;i++){
                pst.setString(i+1,date[i]);
            }
            ResultSet resultSet=pst.executeQuery();//返回结果集合
            return resultSet;



        } catch (SQLException e) {
            return null;
        }
    }
    public static int update(String sql,String ...date){
        try {
            PreparedStatement pst= con.prepareStatement(sql);//初步加载SQL
            for(int i=0;i<date.length;i++){
                pst.setString(i+1,date[i]);
            }
            return pst.executeUpdate();//返回结果集合

        } catch (SQLException e) {
            return -1;
            //-1代表报错，0代表更改失败，大于1均正常
        }
    }
}
