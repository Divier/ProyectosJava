package org.divier.spring.ms.usuarios.repositories;

import org.divier.spring.ms.usuarios.models.entity.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario> findByEmail(String email);

    //Otra posible forma de consultar usando la anotacion @Query
    @Query("select u from Usuario u where u.email=?1")
    Optional<Usuario> queryPorEmail(String email);
}
