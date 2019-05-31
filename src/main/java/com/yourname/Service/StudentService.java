package com.yourname.Service;

import com.yourname.Dao.StudentDao;
import com.yourname.Entity.Student;
import com.yourname.Service.Interface.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    public Collection<Student> getAllStudents(){
        return this.studentDao.getAllStudents();
    }

    public Student getStudentById(int id){
        return this.studentDao.getStudentById(id);
    }

    public void deleteStudentById(int id) {
        this.studentDao.deleteStudentById(id);
    }

    public void updateStudent(Student s) {
        this.studentDao.updateStudent(s);
    }
}
