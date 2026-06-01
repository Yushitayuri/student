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
            //实现注册账号的功能
            public static int register(String account,String password,String name,String situation,String admin){
                    String aql = "insert into s_admin values(?,?,?,?,?)";
                    int result = DBMySQL.update(aql,account,password,name,situation,admin);
                    return result;
            }
            //更新账号在线状态
            public static int update(String account,String situation){
                    String aql = "update s_admin set situation=? where account=?";

                    return DBMySQL.update(aql,situation,account);
            }
}
