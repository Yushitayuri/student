package com.student.dao;

import com.student.bean.Student;
import com.student.utils.DBMySQL;

import java.lang.reflect.Field;
import java.util.*;

public class StudentDao {

    // ===== 增加学生（适配10个字段） =====
    public int addStudent(Student student) {
        String sql = "INSERT INTO s_student (num, name, gender, age, grade, birthdate, pa, address, telephone, dorm) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        int res = DBMySQL.update(sql,
                student.getNum(),
                student.getName(),
                student.getGender(),
                student.getAge(),
                student.getGrade(),
                student.getBirthdate(),
                student.getPa(),
                student.getAddress(),
                student.getTelephone(),
                student.getDorm());
        return res;
    }

    // ===== 删除学生（按学号） =====
    public int deleteStudent(String num) {
        String sql = "DELETE FROM s_student WHERE num = ?";
        return DBMySQL.update(sql, num);
    }

    // ===== 修改学生（按原学号定位） =====
    public int updateStudent(Student student, String oldNum) {
        String sql = "UPDATE s_student SET num=?, name=?, gender=?, age=?, grade=?, " +
                "birthdate=?, pa=?, address=?, telephone=?, dorm=? WHERE num=?";
        int res = DBMySQL.update(sql,
                student.getNum(),
                student.getName(),
                student.getGender(),
                student.getAge(),
                student.getGrade(),
                student.getBirthdate(),
                student.getPa(),
                student.getAddress(),
                student.getTelephone(),
                student.getDorm(),
                oldNum);
        return res;
    }

    // ===== 按学号查询单个学生 =====
    public Student getStudentByNum(String num) {
        String sql = "SELECT * FROM s_student WHERE num = ?";
        return DBMySQL.QueryOne(sql, Student.class, num);
    }

    // ===== 查询所有学生 =====
    public List<Student> getStudentAll() {
        String sql = "SELECT * FROM s_student";
        return DBMySQL.QueryAll(sql, Student.class);
    }

    // ===== 条件查询（修正允许的字段名） =====
    public List<Student> getStudentCondition(Student student) throws IllegalAccessException {
        // 允许作为查询条件的字段（必须与数据库列名一致）
        Set<String> allowedFields = new HashSet<>(Arrays.asList(
                "name", "num", "gender", "age", "grade",
                "birthdate", "pa", "address", "telephone", "dorm"
        ));

        StringBuilder whereClause = new StringBuilder();
        List<String> params = new ArrayList<>();

        Field[] fields = student.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();

            // 跳过 id 字段（如果有），只允许指定字段
            if (!allowedFields.contains(fieldName)) {
                continue;
            }

            Object valueObj = field.get(student);
            if (valueObj == null) continue;
            String fieldValue = valueObj.toString().trim();
            if (fieldValue.isEmpty()) continue;

            if (whereClause.length() == 0) {
                whereClause.append(" WHERE ").append(fieldName).append(" LIKE ?");
            } else {
                whereClause.append(" AND ").append(fieldName).append(" LIKE ?");
            }
            params.add("%" + fieldValue + "%");
        }

        // 如果没有条件，查询全部
        String finalSql = "SELECT * FROM s_student" + whereClause.toString();
        return DBMySQL.QueryAll(finalSql, Student.class, params.toArray(new String[0]));
    }
}