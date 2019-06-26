package com.uca.capas.service;

/*<<<<<<< HEAD
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
=======*/
import com.uca.capas.domain.Ciudad;
import com.uca.capas.repositories.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ciudadService")
@Transactional
public class CiudadServiceImpl implements CiudadService{

    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }
}
