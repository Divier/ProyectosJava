package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Clientes2;

public interface IClienteService {

	public List<Clientes2> findAll();
	
	public Clientes2 findById(Long id);
	
	public Clientes2 save(Clientes2 cliente);
	
	public void delete(Long id);

}
