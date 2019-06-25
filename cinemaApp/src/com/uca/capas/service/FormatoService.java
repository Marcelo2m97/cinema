package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Formato;

public interface FormatoService {

	public List<Formato> findAll();
	
	public Formato findOne(int id);
}
