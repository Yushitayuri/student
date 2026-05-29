package com.student.dao;

import com.student.bean.Admin;
import com.student.utils.DBMySQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao {
        public static Admin isLogin(String username,String password){
            String sql = "select * from s_admin where account=? and password=?";
            ResultSet resultSet= DBMySQL.Query(sql,username,password);

            try {
                if(resultSet.next()){
                    Admin admin = new Admin(resultSet.getString("account"),
                            resultSet.getString("password"),
                            resultSet.getString("name"),
                            resultSet.getString("situation"),
                            resultSet.getString("admin"));
                    return admin;
                }
            } catch (SQLException e) {
            }
            return null;
        }

}
