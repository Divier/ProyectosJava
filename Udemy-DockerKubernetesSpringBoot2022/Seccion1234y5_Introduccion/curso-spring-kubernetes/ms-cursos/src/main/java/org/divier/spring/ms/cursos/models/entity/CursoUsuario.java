package org.divier.spring.ms.cursos.models.entity;

import javax.persistence.*;

@Entity
public class CursoUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private Long usuarioId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public boolean equals(Object obj) {
        // If the object is compared with itself then return true
        if (obj == this) {
            return true;
        }

        /* Check if o is an instance of Complex or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof CursoUsuario)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        CursoUsuario cu = (CursoUsuario) obj;
        // Compare the data members and return accordingly
        return this.usuarioId != null && this.usuarioId.equals(cu.usuarioId);
    }
}
