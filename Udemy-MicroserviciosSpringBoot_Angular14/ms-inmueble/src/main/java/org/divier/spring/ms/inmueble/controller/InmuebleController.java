package org.divier.spring.ms.inmueble.controller;

import org.divier.spring.ms.inmueble.model.Inmueble;
import org.divier.spring.ms.inmueble.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/inmueble")
public class InmuebleController {

    @Autowired
    private InmuebleService inmuebleService;

    @PostMapping
    public ResponseEntity<?> saveInmueble(@RequestBody Inmueble inmueble) {
        return new ResponseEntity<>(inmuebleService.saveInmueble(inmueble), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteInmueble(@PathVariable Long id) {
        inmuebleService.deleteInmueble(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<?> getAllInmueble() {
        return new ResponseEntity<>(inmuebleService.findAllInmuebles(), HttpStatus.OK);
    }
}
