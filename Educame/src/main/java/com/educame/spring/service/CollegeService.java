package com.educame.spring.service;

import java.util.List;

import com.educame.spring.entity.College;

public interface CollegeService {

	// Save operation
	College saveCollege(College college);

	// Read operation
	List<College> fetchCollegeList();

	// Update operation
	College updateCollege(College college, Long collegeId);

	// Delete operation
	void deleteCollegeById(Long collegeId);
}
