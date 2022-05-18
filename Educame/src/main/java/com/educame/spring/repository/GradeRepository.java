package com.educame.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educame.spring.entity.Grade;

@Repository
public interface GradeRepository extends CrudRepository<Grade, Long> {

}
