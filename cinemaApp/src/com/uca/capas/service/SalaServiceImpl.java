package com.uca.capas.service;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Sala;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.SalaRepository;
import com.uca.capas.utils.Constants;

@Service
public class SalaServiceImpl implements SalaService{
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired 
	private HttpSession session;

	@Override
	public List<Sala> findAll() {
		return salaRepository.findByOrderByIdAsc();
	}

	@Override
	public Sala findOne(int id) {
		return salaRepository.findOne(id);
	}
	
	@Override
	public List<Sala> findActive() {
		return salaRepository.findByActivoOrderByIdAsc(true);
	}

	@Override
	@Transactional
	public void addSala(Sala s) {
		s.setFechaCreacion(Calendar.getInstance());
		s.setUsuarioCreacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		salaRepository.save(s);
	}

	@Override
	@Transactional
	public void editSala(Sala s) {
		Sala s2 = salaRepository.findOne(s.getId());
		s.setFechaCreacion(s2.getFechaCreacion());
		s.setUsuarioCreacion(s2.getUsuarioCreacion());
		s.setActivo(s2.getActivo());
		
		s.setFechaModificacion(Calendar.getInstance());
		s.setUsuarioModificacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		salaRepository.save(s);
	}

	@Override
	@Transactional
	public void activarSala(int id) {
		Sala s = salaRepository.findOne(id);
		s.setActivo(!s.getActivo());
		
		s.setFechaModificacion(Calendar.getInstance());
		s.setUsuarioModificacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		salaRepository.save(s);
	}
}
