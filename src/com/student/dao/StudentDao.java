package com.student.dao;

import com.student.bean.Student;
import com.student.utils.DBMySQL;

public class StudentDao {
    public int addStudent(Student student) {
        String sql = "insert into s_student values(?,?,?,?,?)";
        int res = DBMySQL.update(sql,student.getNum(),student.getName(),student.getGender(),student.getAge(),student.getGrade());
        return res;
    }


}
