package com.educame.spring.service;

import java.util.List;

import com.educame.spring.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educame.spring.entity.Teacher;
import com.educame.spring.repository.TeacherRepository;


@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Override
	public Teacher saveTeacher(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	public List<Teacher> fetchTeacherList() {
		return (List<Teacher>) teacherRepository.findAll();
	}

	@Override
	public Teacher updateTeacher(Teacher teacher, Long teacherId) {
		Teacher teacherDB = teacherRepository.findById(teacherId).get();
		teacherDB.setName(teacher.getName());
		teacherDB.setSalary(teacher.getSalary());
		Address adrs = teacherDB.getAddress();
		adrs.setValue(teacher.getAddress().getValue());
		teacherDB.setAddress(adrs);
		return teacherRepository.save(teacherDB);
	}

	@Override
	public void deleteTeacherById(Long teacherId) {
		teacherRepository.deleteById(teacherId);
	}
}
