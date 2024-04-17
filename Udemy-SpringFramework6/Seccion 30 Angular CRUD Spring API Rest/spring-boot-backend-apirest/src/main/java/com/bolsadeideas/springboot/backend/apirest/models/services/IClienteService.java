package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.List;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Clientes2;

public interface IClienteService {
	
	public List<Clientes2> findAll();
	
	public void save(Clientes2 cliente);
	
	public Clientes2 findById(Long id);
	
	public void delete(Clientes2 cliente);

}
