package com.educame.spring.service;

import com.educame.spring.entity.Address;
import com.educame.spring.entity.Student;
import com.educame.spring.entity.Subject;
import com.educame.spring.repository.StudentRepository;
import com.educame.spring.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return (List<Student>) studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student, Long studentId) {
        Student studentDB = studentRepository.findById(studentId).get();
        if(Objects.nonNull(student.getName())) {
            studentDB.setName(student.getName());
        }
        if(Objects.nonNull(student.getBirthday())) {
            studentDB.setBirthday(student.getBirthday());
        }
        if(Objects.nonNull(student.getAddress())) {
            Address adrs = studentDB.getAddress();
            adrs.setValue(student.getAddress().getValue());
            studentDB.setAddress(adrs);
        }
        if(Objects.nonNull(student.getLsSubject()) && student.getLsSubject().size() > 0) {
            studentDB.setLsSubject(student.getLsSubject());
        }
        return studentRepository.save(studentDB);
    }

    @Override
    public void deleteStudentById(Long studentId) {
        Student studentDB = studentRepository.findById(studentId).get();
        List<Subject> lsSubject = studentDB.getLsSubject();
        lsSubject.forEach(subject -> {
            subject.getLsStudent().clear();
            subjectRepository.save(subject);
            studentRepository.deleteById(studentId);
        });
    }
}
