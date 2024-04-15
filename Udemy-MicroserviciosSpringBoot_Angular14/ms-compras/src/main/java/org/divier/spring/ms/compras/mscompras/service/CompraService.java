package org.divier.spring.ms.compras.mscompras.service;

import org.divier.spring.ms.compras.mscompras.model.Compra;

import java.util.List;

public interface CompraService {
    Compra saveCompra(Compra compra);

    List<Compra> findAllComprasOfUser(Long userId);
}
