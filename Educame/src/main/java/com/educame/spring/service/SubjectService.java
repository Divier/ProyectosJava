package com.educame.spring.service;

import com.educame.spring.entity.Subject;
import com.educame.spring.entity.Teacher;

import java.util.List;

public interface SubjectService {

    // Save operation
    Subject saveSubject(Subject subject);

    // Read operation
    List<Subject> fetchSubjectList();

    // Update operation
    Subject updateSubject(Subject subject, Long subjectId);

    // Delete operation
    void deleteSubjectById(Long subjectId);
}
