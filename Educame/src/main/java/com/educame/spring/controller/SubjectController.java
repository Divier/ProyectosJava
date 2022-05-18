package com.educame.spring.controller;

import com.educame.spring.entity.Subject;
import com.educame.spring.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    // Save operation
    @PostMapping("/subject")
    public Subject saveSubject(@Valid @RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }

    // Read operation
    @GetMapping("/subjects")
    public List<Subject> fetchSubjectList() {
        return subjectService.fetchSubjectList();
    }

    // Update operation
    @PutMapping("/subject/{id}")
    public Subject updateSubject(@RequestBody Subject subject, @PathVariable("id") Long subjectId) {
        return subjectService.updateSubject(subject, subjectId);
    }

    // Delete operation
    @DeleteMapping("/subject/{id}")
    public String deleteSubjectById(@PathVariable("id") Long subjectId) {
        subjectService.deleteSubjectById(subjectId);
        return "Deleted Successfully";
    }
}
