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

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") int id) {
        return this.studentService.getStudentById(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteStudentById(@PathVariable("id") int id) {
        this.studentService.deleteStudentById(id);
    }

    @PutMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student s) {
        this.studentService.updateStudent(s);
    }

    @PostMapping(value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Student> addStudent(@RequestBody Student s) {
        this.studentRepository.save(s);
        return this.studentRepository.findAll();
    }
}

