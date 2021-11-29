package com.bolsadeideas.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Clientes2;

public interface IClienteDao extends CrudRepository<Clientes2, Long>{

}
