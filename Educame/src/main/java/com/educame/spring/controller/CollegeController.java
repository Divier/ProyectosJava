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

import com.educame.spring.entity.College;
import com.educame.spring.service.CollegeService;

@RestController
public class CollegeController {

	@Autowired
	private CollegeService collegeService;

	// Save operation
	@PostMapping("/college")
	public College saveCollege(@Valid @RequestBody College college) {
		return collegeService.saveCollege(college);
	}

	// Read operation
	@GetMapping("/colleges")
	public List<College> fetchCollegeList() {
		return collegeService.fetchCollegeList();
	}

	// Update operation
	@PutMapping("/college/{id}")
	public College updateCollege(@RequestBody College college, @PathVariable("id") Long collegeId) {
		return collegeService.updateCollege(college, collegeId);
	}

	// Delete operation
	@DeleteMapping("/college/{id}")
	public String deleteCollegeById(@PathVariable("id") Long collegeId) {
		collegeService.deleteCollegeById(collegeId);
		return "Deleted Successfully";
	}
}
