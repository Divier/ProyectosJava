package org.divier.spring.ms.usuarios.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name="ms-cursos", url = "host.docker.internal:8002")
//@FeignClient(name = "ms-cursos", url = "c-cursos:8002")
@FeignClient(name = "ms-cursos", url = "${ms.cursos.url}")
public interface CursoClientRest {

    @DeleteMapping("/eliminar-curso-usuario/{id}")
    void eliminarCursoUsuarioPorId(@PathVariable Long id);
}
