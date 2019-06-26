package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Rol;

public interface RolService {

	public List<Rol> findAll();
	
	public Rol findOne(int id);
}
