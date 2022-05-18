package com.educame.spring.service;

import java.util.List;

import com.educame.spring.entity.Grade;

public interface GradeService {

	// Save operation
	Grade saveGrade(Grade grade);

	// Read operation
	List<Grade> fetchGradeList();

	// Update operation
	Grade updateGrade(Grade grade, Long gradeId);

	// Delete operation
	void deleteGradeById(Long gradeId);
}
