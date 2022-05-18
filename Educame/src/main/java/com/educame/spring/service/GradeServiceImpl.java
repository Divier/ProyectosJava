package com.educame.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educame.spring.entity.Grade;
import com.educame.spring.repository.GradeRepository;

@Service
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeRepository gradeRepository;

	@Override
	public Grade saveGrade(Grade grade) {
		return gradeRepository.save(grade);
	}

	@Override
	public List<Grade> fetchGradeList() {
		return (List<Grade>) gradeRepository.findAll();
	}

	@Override
	public Grade updateGrade(Grade grade, Long gradeId) {
		Grade gradeDB = gradeRepository.findById(gradeId).get();
		gradeDB.setClassRoom(grade.getClassRoom());
		gradeDB.setGrade(grade.getGrade());
		return gradeRepository.save(gradeDB);
	}

	@Override
	public void deleteGradeById(Long gradeId) {
		gradeRepository.deleteById(gradeId);
	}
}
