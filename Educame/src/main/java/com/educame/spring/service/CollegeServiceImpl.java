package com.educame.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educame.spring.entity.College;
import com.educame.spring.repository.CollegeRepository;

@Service
public class CollegeServiceImpl implements CollegeService {

	@Autowired
	private CollegeRepository collegeRepository;

	@Override
	public College saveCollege(College college) {
		return collegeRepository.save(college);
	}

	@Override
	public List<College> fetchCollegeList() {
		return (List<College>) collegeRepository.findAll();
	}

	@Override
	public College updateCollege(College college, Long collegeId) {
		College collegeDB = collegeRepository.findById(collegeId).get();
		collegeDB.setName(college.getName());
		return collegeRepository.save(collegeDB);
	}

	@Override
	public void deleteCollegeById(Long collegeId) {
		collegeRepository.deleteById(collegeId);
	}
}
