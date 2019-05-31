package com.yourname.Service.Interface;

import com.yourname.Entity.Student;

import java.util.Collection;

public interface IStudentService {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void deleteStudentById(int id);

    void updateStudent(Student s);
}
