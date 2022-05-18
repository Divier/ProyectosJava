package com.educame.spring.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
public class Student {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private Integer document;
    
    @Temporal(TemporalType.DATE)
    private Date birthday;

    @ManyToMany(mappedBy = "lsStudent", cascade = {CascadeType.PERSIST, CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    private List<Subject> lsSubject;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn//Anotacion usada para definir esta entidad como dueña de la relacion
    private Address address;
}
