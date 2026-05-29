package com.student.view;

import com.student.utils.DButil;

/*
程序入口
*/
public class StudentMain {
    public static void main(String[] args) {
        //主程序，链接数据库

        DButil dButil= new DButil("root","123456","db_student");
        LoginView loginView = new LoginView();//打开登录窗口
    }
}
