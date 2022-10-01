package com.yourname.Entity;

import javax.persistence.*;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "course")
    private String course;

    public Student(Integer id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public Student(){

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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
