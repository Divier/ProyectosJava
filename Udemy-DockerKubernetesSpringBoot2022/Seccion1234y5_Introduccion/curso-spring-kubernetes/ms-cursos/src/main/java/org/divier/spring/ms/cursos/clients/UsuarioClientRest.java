package org.divier.spring.ms.cursos.clients;

import org.divier.spring.ms.cursos.models.Usuario;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@FeignClient(name="ms-usuarios", url = "host.docker.internal:8001")
//@FeignClient(name="ms-usuarios", url="c-usuarios:8001")
@FeignClient(name = "ms-usuarios", url = "${ms.usuarios.url}")
public interface UsuarioClientRest {

    @GetMapping("/{id}")
    Usuario detalleUsuario(@PathVariable Long id);

    @PostMapping
    Usuario crearUsuario(@RequestBody Usuario usuario);

    @GetMapping("/usuarios-por-curso")
    List<Usuario> obtenerAlumnosPorCurso(@RequestParam List<Long> ids);
}
