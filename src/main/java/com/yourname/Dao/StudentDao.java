package com.yourname.Dao;

import com.yourname.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static javax.swing.UIManager.put;

//Giving data from any database
@Repository
public class StudentDao {

    private static Map<Integer,Student> students;

    static {
        students = new HashMap<Integer, Student>() {

            {
                put(1, new Student(1, "Said", "Computer Science"));
                put(2, new Student(2, "Alex", "Science"));
                put(3, new Student(3, "Stud", "Biology"));
            }
        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudentById(int id){
        return this.students.get(id);
    }

    public void deleteStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudent(Student s){
        Student temp = this.students.get(s.getId());
        temp.setCourse(s.getCourse());
        temp.setName(s.getName());
        students.put(s.getId(),temp);
    }
}
