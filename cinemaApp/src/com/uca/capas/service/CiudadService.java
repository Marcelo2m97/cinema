package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Ciudad;

public interface CiudadService {

	public List<Ciudad> findAll();
	
	public Ciudad findOne(int id);
}
