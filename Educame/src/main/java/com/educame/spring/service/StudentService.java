package com.educame.spring.service;

import com.educame.spring.entity.Student;
import com.educame.spring.entity.Teacher;

import java.util.List;

public interface StudentService {

    // Save operation
    Student saveStudent(Student student);

    // Read operation
    List<Student> fetchStudentList();

    // Update operation
    Student updateStudent(Student student, Long studentId);

    // Delete operation
    void deleteStudentById(Long studentId);
}
