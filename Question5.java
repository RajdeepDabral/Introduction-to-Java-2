/*
Q5. WAP to show object cloning in java using cloneable and copy constructor both.
*/



package com.company;

class student implements Cloneable{
    private String name;
    private String id;
    private int marks;

    public student(String name, String id, int marks) {
        this.name = name;
        this.id = id;
        this.marks = marks;
    }
    public student(student s) {
        this.name = s.name;
        this.id = s.id;
        this.marks = s.marks;
        System.out.println("Copy Constructor Called!!!");
    }

    @Override
    protected student clone() throws CloneNotSupportedException {
        return (student)super.clone();
    }

    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
    public int getMarks() {
        return marks;
    }

    public void studentdata() {
        System.out.println("student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", marks=" + marks +
                '}' + " hashcode : "+this.hashCode());
    }
}


public class CloneClass {
    public static void main(String [] args) throws CloneNotSupportedException{
        student s1 = new student("rajdeep","1011",77);

        student s2 = new student(s1);

        student s3 = s2.clone();

        s1.studentdata();
        s2.studentdata();
        s3.studentdata();
    }
}

