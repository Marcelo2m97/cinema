package com.uca.capas.service;

/*<<<<<<< HEAD
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
=======*/
import com.uca.capas.domain.Estado;
import com.uca.capas.repositories.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("estadoService")
@Transactional
public class EstadoServiceImpl implements EstadoService{

    @Autowired
    private EstadoRepository estadoRepository;

    @Override
    public List<Estado> findAll() {
        return estadoRepository.findAll();
    }
}
