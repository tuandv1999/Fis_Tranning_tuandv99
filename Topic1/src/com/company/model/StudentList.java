package com.company.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class StudentList implements ISortStrategy{
    public final int MAX=100;
    private Student[] student;
    private int count;
    private ISortStrategy  sortStrategy;

    static List<Student> list = new ArrayList<>();

    public StudentList() {
        this.count = 0;
        this.student = new Student[MAX];
    }

    public void addStudent(Student student) throws ParseException {

        list.add(student);
    }
    public void removeStudent(int code){
         list.removeIf(t->t.getCode()==code);
    }
    public void dislay(){
        list.forEach(System.out::print);
    }
    public void sort(){
    }


    @Override
    public void sort(Comparable[] data, int count) {

    }
}
