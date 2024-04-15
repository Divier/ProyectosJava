package org.divier.spring.ms.inmueble.service;

import org.divier.spring.ms.inmueble.model.Inmueble;

import java.util.List;

public interface InmuebleService {

    Inmueble saveInmueble(Inmueble inmueble);

    void deleteInmueble(Long id);

    List<Inmueble> findAllInmuebles();
}
