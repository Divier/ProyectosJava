package com.educame.spring.controller;

import com.educame.spring.entity.Student;
import com.educame.spring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Save operation
    @PostMapping("/student")
    public Student saveStudent(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // Read operation
    @GetMapping("/students")
    public List<Student> fetchStudentList() {
        return studentService.fetchStudentList();
    }

    // Update operation
    @PutMapping("/student/{id}")
    public Student updateTeacher(@RequestBody Student student, @PathVariable("id") Long studentId) {
        return studentService.updateStudent(student, studentId);
    }

    // Delete operation
    @DeleteMapping("/student/{id}")
    public String deleteStudentById(@PathVariable("id") Long studentId) {
        studentService.deleteStudentById(studentId);
        return "Deleted Successfully";
    }
}
