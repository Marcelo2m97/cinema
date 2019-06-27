package com.uca.capas.service;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uca.capas.domain.Exhibicion;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.ExhibicionRepository;
import com.uca.capas.repositories.FormatoRepository;
import com.uca.capas.repositories.PeliculaRepository;
import com.uca.capas.repositories.SalaRepository;
import com.uca.capas.utils.Constants;

@Service
public class ExhibicionServiceImpl implements ExhibicionService{

	@Autowired
	private ExhibicionRepository exhibicionRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Autowired
	private FormatoRepository formatoRepository;
	
	@Autowired 
	private HttpSession session;

	@Override
	public List<Exhibicion> findAll() {
		return exhibicionRepository.findByOrderByIdAsc();
	}
	

	@Override
	public Exhibicion findOne(int id) {
		return exhibicionRepository.findOne(id);
	}
	
	@Override
	public List<Exhibicion> findActive() {
		return exhibicionRepository.findByActivoOrderByIdAsc(true);
	}

	@Override
	@Transactional
	public void addExhibicion(Exhibicion e) {
		e.setFormato(formatoRepository.findOne(e.getIdFormato()));
		e.setPelicula(peliculaRepository.findOne(e.getIdPelicula()));
		e.setSala(salaRepository.findOne(e.getIdSala()));
		e.setAsientos(salaRepository.findOne(e.getIdSala()).getCapacidad());
		
		e.setFechaCreacion(Calendar.getInstance());
		e.setUsuarioCreacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		exhibicionRepository.save(e);
	}

	@Override
	@Transactional
	public void editExhibicion(Exhibicion e) {
		e.setFormato(formatoRepository.findOne(e.getIdFormato()));
		e.setPelicula(peliculaRepository.findOne(e.getIdPelicula()));
		e.setSala(salaRepository.findOne(e.getIdSala()));
		
		e.setFechaModificacion(Calendar.getInstance());
		e.setUsuarioModificacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		exhibicionRepository.save(e);
	}

	@Override
	@Transactional
	public void activarExhibicion(int id) {
		Exhibicion e = exhibicionRepository.findOne(id);
		e.setActivo(!e.getActivo());
		e.setFechaModificacion(Calendar.getInstance());
		e.setUsuarioModificacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		exhibicionRepository.save(e);
	}
}