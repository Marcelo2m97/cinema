package com.uca.capas.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Sala;
import com.uca.capas.repositories.SalaRepository;

@Service
public class SalaServiceImpl implements SalaService{
	
	@Autowired
	private SalaRepository salaRepository;

	@Override
	public List<Sala> findAll() {
		return salaRepository.findByOrderByIdAsc();
	}

	@Override
	public Sala findOne(int id) {
		return salaRepository.findOne(id);
	}

	@Override
	public void addSala(Sala s) {
		s.setFechaCreacion(Calendar.getInstance());
		salaRepository.save(s);
	}

	@Override
	public void editSala(Sala s) {
		Sala s2 = salaRepository.findOne(s.getId());
		s.setFechaCreacion(s2.getFechaCreacion());
		s.setUsuarioCreacion(s2.getUsuarioCreacion());
		s.setActivo(s2.getActivo());
		s.setFechaModificacion(Calendar.getInstance());
		salaRepository.save(s);
	}

	@Override
	public void activarSala(Sala s) {
		s.setActivo(!s.getActivo());
		salaRepository.save(s);
	}

}
