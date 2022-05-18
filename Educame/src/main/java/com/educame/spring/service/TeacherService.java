package com.educame.spring.service;

import java.util.List;

import com.educame.spring.entity.Teacher;

public interface TeacherService {

	// Save operation
	Teacher saveTeacher(Teacher grade);

	// Read operation
	List<Teacher> fetchTeacherList();

	// Update operation
	Teacher updateTeacher(Teacher teacher, Long teacherId);

	// Delete operation
	void deleteTeacherById(Long teacherId);
}
