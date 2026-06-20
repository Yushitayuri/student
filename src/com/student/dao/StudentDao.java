package com.student.dao;

import com.student.bean.Student;
import com.student.utils.DBMySQL;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.*;

public class StudentDao {
    public int addStudent(Student student) {
        String sql = "insert into s_student values(?,?,?,?,?)";
        int res = DBMySQL.update(sql,student.getNum(),student.getName(),student.getGender(),student.getAge(),student.getGrade());
        return res;
    }
        //通过学号查询
    public Student getStudentByNum(String num) {
        String sql = "select * from s_student where num = ?";
        Student student = DBMySQL.QueryOne(sql,Student.class,num);//返回存放学生的java bean

        return student;
    }

    public List<Student> getStudentAll() {
        String sql = "select * from s_student";
        List<Student> student = DBMySQL.QueryAll(sql,Student.class);//返回存放学生的java bean

        return student;
    }
    public List<Student> getStudentCondition(Student student) throws IllegalAccessException {
        Set<String> allowedFields = new HashSet<>(Arrays.asList(
                "name", "studentNo", "phone", "email", "gender"  // 加上性别
        ));

        String sql = "select * from s_student";
        StringBuilder whereClause = new StringBuilder();
        List<String> params = new ArrayList<>();  // 存储参数值

        Field[] fields = student.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();

            if (!allowedFields.contains(fieldName)) {
                continue;
            }

            Object valueObj = field.get(student);
            if (valueObj == null) {
                continue;
            }
            String fieldValue = valueObj.toString().trim();
            if (fieldValue.isEmpty()) {
                continue;
            }

            if (whereClause.length() == 0) {
                whereClause.append(" WHERE ").append(fieldName).append(" LIKE ?");
            } else {
                whereClause.append(" AND ").append(fieldName).append(" LIKE ?");
            }
            params.add("%" + fieldValue + "%");
        }

        String finalSql = sql + whereClause.toString();
        System.out.println("SQL: " + finalSql);
        System.out.println("参数: " + params);


        List<Student> stu = DBMySQL.QueryAll(finalSql, Student.class, params.toArray(new String[0]));
        return stu;
    }


}
