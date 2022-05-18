package com.educame.spring.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true)
    private Integer document;

    private BigDecimal salary;

    @JsonManagedReference(value = "r_teacher_subject")
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)//El elemento mappedBy define una relacion bidireccional
    private List<Subject> lsSubject;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn//Anotacion usada para definir esta entidad como dueña de la relacion
    private Address address;
}
