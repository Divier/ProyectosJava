package com.educame.spring.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")//@JsonIdentityInfo permite controlar errores por referencias circulares, se ve mas apto para manytomany
public class Subject {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
	@Column(nullable = false, unique = true)
    private String name;

    @JsonBackReference(value = "r_teacher_subject")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)//Anotacion usada para definir esta entidad como dueña de la relacion
    private Teacher teacher;

    @JsonBackReference(value = "r_grade_subject")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)//Anotacion usada para definir esta entidad como dueña de la relacion
    private Grade grade;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinTable(
            name = "subject_student",
            joinColumns = @JoinColumn(name = "subject_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))//Anotacion usada para definir esta entidad como dueña de la relacion
    private List<Student> lsStudent;
}
