package org.divier.spring.ms.compras.mscompras.repository;

import org.divier.spring.ms.compras.mscompras.model.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findAllByUserId(Long userId);
}
