package com.educame.spring.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @Column(nullable = false, unique = true)
    private Short grade;
    
    @Column(nullable = false, unique = true)
    private String classRoom;

    @JsonManagedReference(value = "r_grade_subject")
    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)//El elemento mappedBy define una relacion bidireccional
    private List<Subject> lsSubject;

    @JsonBackReference(value = "r_college_grade")//@JsonBackReference -> Gestiona el reverso de la referencia y los campos/colecciones marcados con esta anotación no se serializan.
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(nullable = false)//Anotacion usada para definir esta entidad como dueña de la relacion
    private College college;
}
