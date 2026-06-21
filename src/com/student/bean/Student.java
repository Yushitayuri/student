package com.student.bean;

public class Student {
    private String num;
    private String name;
    private String gender;
    private String age;
    private String grade;
    // ===== 新增字段（对应数据库表） =====
    private String birthdate;   // 出生日期
    private String pa;          // 政治面貌 (Political Affiliation)
    private String address;     // 地址
    private String telephone;   // 电话
    private String dorm;        // 宿舍

    // ===== 全参构造方法 =====
    public Student(String num, String name, String gender, String age, String grade,
                   String birthdate, String pa, String address, String telephone, String dorm) {
        this.num = num;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.grade = grade;
        this.birthdate = birthdate;
        this.pa = pa;
        this.address = address;
        this.telephone = telephone;
        this.dorm = dorm;
    }

    // ===== 保留原有的5参构造（兼容旧代码） =====
    public Student(String num, String name, String gender, String age, String grade) {
        this(num, name, gender, age, grade, null, null, null, null, null);
    }

    public Student() {
    }

    // ===== 所有字段的 Getter/Setter =====
    public String getNum() { return num; }
    public void setNum(String num) { this.num = num; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getAge() { return age; }
    public void setAge(String age) { this.age = age; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public String getBirthdate() { return birthdate; }
    public void setBirthdate(String birthdate) { this.birthdate = birthdate; }

    public String getPa() { return pa; }
    public void setPa(String pa) { this.pa = pa; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public String getDorm() { return dorm; }
    public void setDorm(String dorm) { this.dorm = dorm; }

    @Override
    public String toString() {
        return "Student{" +
                "num='" + num + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", grade='" + grade + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", pa='" + pa + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", dorm='" + dorm + '\'' +
                '}';
    }
}