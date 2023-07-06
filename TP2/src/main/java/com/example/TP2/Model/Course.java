package com.example.TP2.Model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int id;
    private String name;
    private List<Student> students;

    public Course(int id, String name) {
        this.id = id;
        this.name = name;
        this.students = new ArrayList<>();
    }



    public void addStudent(Student student) {
        students.add(student);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}


