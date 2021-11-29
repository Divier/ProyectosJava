/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ECM1378G
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
    @NamedQuery(name = "Horario.findById", query = "SELECT h FROM Horario h WHERE h.idHor = :id")})
public class Horario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_HOR")
    private Long idHor;
    @NotNull
    @Basic(optional = false)
    @Size(max = 10)
    @Column(name = "DIA")
    private String dia;
    @NotNull
    @Basic(optional = false)
    @Column(name = "HORA")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ASIGNATURA_X_HORARIO", joinColumns = {
        @JoinColumn(name = "ID_HOR", referencedColumnName = "ID_HOR")}, inverseJoinColumns = {
        @JoinColumn(name = "ID_ASG", referencedColumnName = "ID_ASG")})
    private List<Asignatura> asignaturas;

    public Long getIdHor() {
        return idHor;
    }

    public void setIdHor(Long idHor) {
        this.idHor = idHor;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(List<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + Objects.hashCode(this.idHor);
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
        final Horario other = (Horario) obj;
        if (!Objects.equals(this.idHor, other.idHor)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Horario{" + "idHor=" + idHor + '}';
    }
}
