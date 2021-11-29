/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ECM1378G
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Relacion.findAll", query = "SELECT r FROM Relacion r"),
    @NamedQuery(name = "Relacion.findById", query = "SELECT r FROM Relacion r WHERE r.idRel = :id")})
public class Relacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_REL")
    private Long idRel;
    @NotNull
    @JoinColumn(name = "ID_ASG", referencedColumnName = "ID_ASG")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Asignatura asignatura;
    @NotNull
    @JoinColumn(name = "ID_PRF", referencedColumnName = "ID_PRF")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Profesor profesor;
    @NotNull
    @JoinColumn(name = "ID_CUR", referencedColumnName = "ID_CUR")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Curso curso;
    @ManyToMany(mappedBy = "relaciones", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Estudiante> estudiantes;

    public Long getIdRel() {
        return idRel;
    }

    public void setIdRel(Long idRel) {
        this.idRel = idRel;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.idRel);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Relacion other = (Relacion) obj;
        if (!Objects.equals(this.idRel, other.idRel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Relacion{" + "idRel=" + idRel + '}';
    }
}