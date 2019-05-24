package com.yourname.Controller;

import com.yourname.Entity.Student;
import com.yourname.Repository.StudentRepository;
import com.yourname.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    //Instantiate Automatically
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getAllStudents(){
        return this.studentRepository.findAll();
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id){
        return this.studentService.getStudentById(id);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id){
        this.studentService.deleteStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student s){
        this.studentService.updateStudent(s);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> addStudent(@RequestBody Student s){
        this.studentRepository.save(s);
        return this.studentRepository.findAll();
    }
}

