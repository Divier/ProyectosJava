package com.educame.spring.entity;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
    @Column(nullable = false, unique = true)
    private String name;

    @JsonManagedReference(value = "r_college_grade")//@JsonManagedReference -> Administra la parte delantera de la referencia y los campos marcados por esta anotación son los que se serializan
    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL)//El elemento mappedBy define una relacion bidireccional
    private List<Grade> lsGrade;
}
