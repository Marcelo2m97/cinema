package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Ciudad;
import com.uca.capas.repositories.CiudadRepository;

@Service
public class CiudadServiceImpl implements CiudadService{

	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Override
	public List<Ciudad> findAll() {
		return ciudadRepository.findAll();
	}

	@Override
	public Ciudad findOne(int id) {
		return ciudadRepository.findOne(id);
	}
}
