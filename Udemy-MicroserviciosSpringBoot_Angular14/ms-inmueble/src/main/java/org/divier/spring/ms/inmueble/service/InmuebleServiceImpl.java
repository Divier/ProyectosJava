package org.divier.spring.ms.inmueble.service;

import org.divier.spring.ms.inmueble.model.Inmueble;
import org.divier.spring.ms.inmueble.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InmuebleServiceImpl implements InmuebleService {

    @Autowired
    private InmuebleRepository inmuebleRepository;

    @Override
    public Inmueble saveInmueble(Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }

    @Override
    public void deleteInmueble(Long id) {
        inmuebleRepository.deleteById(id);
    }

    @Override
    public List<Inmueble> findAllInmuebles() {
        return inmuebleRepository.findAll();
    }
}
