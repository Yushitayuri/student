package com.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;


//负责创建数据库链接
public class DButil {
    //账号,密码,数据库名称
    private String account;
    private String password;
    private String db;

    public DButil(String account, String password, String db){
        this.account = account;
        this.password = password;
        this.db = db;
        //实现数据库的加载、驱动，及创建数据库的链接
        init();
    }

    public static Connection con =null;

    private void init(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("加载驱动成功");
        }catch(Exception e){
            System.out.println("加载驱动失败");
            e.printStackTrace();
        }
        //链接数据库
        try{
            String uri = "jdbc:mysql://localhost:3306/student";
            con= DriverManager.getConnection(uri,account,password);
            System.out.println("链接成功");
        }catch(Exception e){
            System.out.println("链接失败");
            e.printStackTrace();

            String temp=e.getMessage();
            System.out.println(temp);
            String[] arr1=temp.split(" ");
            if(arr1[0].equals("Unknown")) {
                System.out.println("请建立名字为:" + arr1[2] + "数据库");

            }   if(arr1[0].equals("Access")) {
                    System.out.println("请检查数据库密码是否正确:数据库密码错误");
            }
        }
    }




}
