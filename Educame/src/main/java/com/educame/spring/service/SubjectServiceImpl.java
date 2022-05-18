package com.educame.spring.service;

import com.educame.spring.entity.Student;
import com.educame.spring.entity.Subject;
import com.educame.spring.repository.StudentRepository;
import com.educame.spring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> fetchSubjectList() {
        return (List<Subject>) subjectRepository.findAll();
    }

    @Override
    public Subject updateSubject(Subject subject, Long subjectId) {
        Subject subjectDB = subjectRepository.findById(subjectId).get();
        if(Objects.nonNull(subject.getName())) {
            subjectDB.setName(subject.getName());
        }
        if(Objects.nonNull(subject.getGrade())) {
            subjectDB.setGrade(subject.getGrade());
        }
        if(Objects.nonNull(subject.getTeacher())) {
            subjectDB.setTeacher(subject.getTeacher());
        }
        if(Objects.nonNull(subject.getLsStudent()) && subject.getLsStudent().size() > 0) {
            List<Student> lsStudent = new ArrayList<>();
            subject.getLsStudent().forEach(student -> {
                Student studentDB = studentRepository.findById(student.getId()).get();
                lsStudent.add(studentDB);
            });
            subjectDB.setLsStudent(lsStudent);
        }
        return subjectRepository.save(subjectDB);
    }

    @Override
    public void deleteSubjectById(Long subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
