/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ECM1378G
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p"),
    @NamedQuery(name = "Profesor.findById", query = "SELECT p FROM Profesor p WHERE p.idPrf = :id")})
public class Profesor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRF")
    private Long idPrf;
    @NotNull
    @Basic(optional = false)
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Digits(integer = 10, fraction = 2)
    @Column(name = "SALARIO")
    private BigDecimal salario;

    public Long getIdPrf() {
        return idPrf;
    }

    public void setIdPrf(Long idPrf) {
        this.idPrf = idPrf;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.idPrf);
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
        final Profesor other = (Profesor) obj;
        if (!Objects.equals(this.idPrf, other.idPrf)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Profesor{" + "idPrf=" + idPrf + '}';
    }
}