package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Estado;
import com.uca.capas.repositories.EstadoRepository;

@Service
public class EstadoServiceImpl implements EstadoService{

	@Autowired
	private EstadoRepository estadoRepository;
	
	@Override
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

	@Override
	public Estado findOne(int id) {
		return estadoRepository.findOne(id);
	}
}
