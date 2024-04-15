package org.divier.spring.ms.compras.mscompras.controller;

import org.divier.spring.ms.compras.mscompras.model.Compra;
import org.divier.spring.ms.compras.mscompras.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/compra")
public class CompraController {

    @Autowired
    private CompraService compraService;

    @PostMapping
    public ResponseEntity<?> saveCompra(@RequestBody Compra compra) {
        return new ResponseEntity<>(compraService.saveCompra(compra), HttpStatus.CREATED );
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> getAllComprasOfUser(@PathVariable Long userId) {
        return new ResponseEntity<>(compraService.findAllComprasOfUser(userId), HttpStatus.OK );
    }
}
