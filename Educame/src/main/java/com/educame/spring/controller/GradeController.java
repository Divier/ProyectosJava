package com.educame.spring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.educame.spring.entity.Grade;
import com.educame.spring.service.GradeService;

@RestController
public class GradeController {

	@Autowired
	private GradeService gradeService;

	// Save operation
	@PostMapping("/grade")
	public Grade saveGrade(@Valid @RequestBody Grade grade) {
		return gradeService.saveGrade(grade);
	}

	// Read operation
	@GetMapping("/grades")
	public List<Grade> fetchGradeList() {
		return gradeService.fetchGradeList();
	}

	// Update operation
	@PutMapping("/grade/{id}")
	public Grade updateGrade(@RequestBody Grade grade, @PathVariable("id") Long gradeId) {
		return gradeService.updateGrade(grade, gradeId);
	}

	// Delete operation
	@DeleteMapping("/grade/{id}")
	public String deleteGradeById(@PathVariable("id") Long gradeId) {
		gradeService.deleteGradeById(gradeId);
		return "Deleted Successfully";
	}
}
