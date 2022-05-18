package com.educame.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educame.spring.entity.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long> {

}
