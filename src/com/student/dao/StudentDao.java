package com.student.dao;

import com.student.bean.Student;
import com.student.utils.DBMySQL;

import java.sql.ResultSet;

public class StudentDao {
    public int addStudent(Student student) {
        String sql = "insert into s_student values(?,?,?,?,?)";
        int res = DBMySQL.update(sql,student.getNum(),student.getName(),student.getGender(),student.getAge(),student.getGrade());
        return res;
    }
        //通过学号查询
    public Student getStudent(String num) {
        String sql = "select * from s_student where num = ?";
        ResultSet resultSet = DBMySQL.Query(sql,num);//返回JDBC结果集
        return null;
    }


}
