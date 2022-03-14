package com.hendisantika.controller;

import com.hendisantika.entity.Student;
import com.hendisantika.exception.StudentNotFoundException;
import com.hendisantika.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : student-crud-app
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 15/03/22
 * Time: 06.31
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentservice;

    @Autowired
    public StudentController(StudentService studentservice) {
        this.studentservice = studentservice;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentservice.getAllStudents();
    }

    @GetMapping(value = "/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) Long id) {
        Student std = studentservice.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student with " + id + " is Not Found!"));
        return std;
    }
}