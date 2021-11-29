/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ECM1378G
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Colegio.findAll", query = "SELECT c FROM Colegio c"),
    @NamedQuery(name = "Colegio.findById", query = "SELECT c FROM Colegio c WHERE c.idCol = :id")})
public class Colegio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_COL")
    private Long idCol;
    @NotNull
    @Basic(optional = false)
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;

    public Long getIdCol() {
        return idCol;
    }

    public void setIdCol(Long idCol) {
        this.idCol = idCol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.idCol);
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
        final Colegio other = (Colegio) obj;
        if (!Objects.equals(this.idCol, other.idCol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Colegio{" + "idCol=" + idCol + '}';
    }
}