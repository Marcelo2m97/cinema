package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Estado;

public interface EstadoService {

	public List<Estado> findAll();
	
	public Estado findOne(int id);
}
