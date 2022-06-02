package com.company.model;

import java.util.Date;

public class Student implements Comparable<Student>{
    private int code;
    private String name;
    private Date birthDate;

    public Student() {
    }

    public Student(int code, String name, Date birthDate) {
        this.code = code;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
}
