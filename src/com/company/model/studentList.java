package com.company.model;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class studentList  {
    public final int MAX=100;
    private student[] student;
    private int count;
    private ISortStrategy  sortStrategy;
    static Scanner scanner = new Scanner(System.in);
    static student st=new student();
    static List<student> list = new ArrayList<>();

    public studentList() {
        this.count=0;
        this.student=new student[MAX];
    }

    public void addStudent() throws ParseException {
        System.out.println("moi ban nhap vao code :");
        st.setCode(scanner.nextInt());
        System.out.println("moi ban nhap vao name :");
        scanner.nextLine();
        st.setName(scanner.nextLine());
        System.out.println("moi ban nhap vao dinh dang: dd/mm/yyyy :");
        st.setBirthDate(new SimpleDateFormat("dd/MM/yyyy").parse(scanner.nextLine()));

        list.add(st);
    }
    public void removeStudent(){
        System.out.println("nhap vao ma code muon xoa:");
         int so = scanner.nextInt();
         for(int i=0;i<=list.size();i++){
             if(so==(list.get(i).getCode())){
                 System.out.println("da tim thay sinh vien co code:"+so);
                 list.remove(i);
                 System.out.println("xoa xong :"+so);
             }
             else {
                 System.out.println("khoong tim thay ma code:" + so);
             }
         }
    }
    public void dislay(){
        System.out.println("vua nhap xong:"+st.toString());
    }

}
