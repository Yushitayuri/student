package com.student.utils;

import com.student.bean.Student;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public static ResultSet Query(String sql,String ...data) {
        try {
            PreparedStatement pst = con.prepareStatement(sql);//初步加载SQL
            for (int i = 0; i < data.length; i++) {
                pst.setString(i + 1, data[i]);
            }
            ResultSet resultSet = pst.executeQuery();//返回结果集合
            return resultSet;
        } catch (SQLException e) {
            return null;
        }
    }

        public static <T> List<T> QueryAll(String sql, Class<T> tClass, String ...data){
        List<T> list=new ArrayList<>();
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
            //单个查询

            while (resultSet.next()) {
                T instance=tClass.getDeclaredConstructor().newInstance();
                Field[] fields = tClass.getDeclaredFields();//获取类声明中的所有字段
                //遍历所有字段，获取每个字段并添加到列表中
                for (Field field : fields) {
                    field.setAccessible(true);
                    String res= resultSet.getString(field.getName());//得到结果
                    field.set(instance,res);
                }
                list.add(instance);
            }
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static <T> T QueryOne(String sql, Class<T> tclass,String ...data) {
        T instance=null;
        try {
            PreparedStatement pstmt=con.prepareStatement(sql);//初步加载SQL
            for(int i=0;i<data.length;i++) {
                pstmt.setString(i+1,data[i]);
            }
            ResultSet resultSet = pstmt.executeQuery();//将结果集合返回去
            //单个查询

            //创建一个类的实例
            instance=tclass.getDeclaredConstructor().newInstance();// 创建类T的新实例
            Student student = new Student();
            Field fields[] = tclass.getDeclaredFields();//获取一个类当中所有声明的字段
            if(resultSet.next()) {
                for (Field field : fields) {
                    field.setAccessible(true);//允许访问私有字段
                    String res=resultSet.getString(field.getName());//得到了一个值
                    field.set(instance,res);
                }
            }

            return  instance;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (InvocationTargetException ex) {
            ex.printStackTrace();

        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (NoSuchMethodException ex) {
            ex.printStackTrace();
        }
        return instance;

    }

    public static int update(String sql,String ...data){
        try {
            Connection con = getConnection();
            if (con == null) {
                System.out.println("错误：数据库连接为 null");
                return -1;
            }//+
            PreparedStatement pst= con.prepareStatement(sql);//初步加载SQL
            for(int i=0;i<data.length;i++){
                pst.setString(i+1,data[i]);
            }
            return pst.executeUpdate();//返回结果集合

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
            //-1代表报错，0代表更改失败，大于1均正常
        }
    }
}
