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

import com.educame.spring.entity.Teacher;
import com.educame.spring.service.TeacherService;

@RestController
public class TeacherController {

	@Autowired
	private TeacherService teacherService;

	// Save operation
	@PostMapping("/teacher")
	public Teacher saveTeacher(@Valid @RequestBody Teacher teacher) {
		return teacherService.saveTeacher(teacher);
	}

	// Read operation
	@GetMapping("/teachers")
	public List<Teacher> fetchTeacherList() {
		return teacherService.fetchTeacherList();
	}

	// Update operation
	@PutMapping("/teacher/{id}")
	public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable("id") Long teacherId) {
		return teacherService.updateTeacher(teacher, teacherId);
	}

	// Delete operation
	@DeleteMapping("/teacher/{id}")
	public String deleteTeacherById(@PathVariable("id") Long teacherId) {
		teacherService.deleteTeacherById(teacherId);
		return "Deleted Successfully";
	}
}
