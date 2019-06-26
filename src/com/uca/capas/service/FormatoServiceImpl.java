package com.uca.capas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Formato;
import com.uca.capas.repositories.FormatoRepository;

@Service
public class FormatoServiceImpl implements FormatoService{
	
	@Autowired
	private FormatoRepository formatoRepository;

	@Override
	public List<Formato> findAll() {
		return formatoRepository.findAll();
	}

	@Override
	public Formato findOne(int id) {
		return formatoRepository.findOne(id);
	}
}
