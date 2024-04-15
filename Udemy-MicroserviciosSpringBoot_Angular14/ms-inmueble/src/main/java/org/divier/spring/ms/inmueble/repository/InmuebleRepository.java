package org.divier.spring.ms.inmueble.repository;

import org.divier.spring.ms.inmueble.model.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InmuebleRepository extends JpaRepository<Inmueble, Long> {
}
