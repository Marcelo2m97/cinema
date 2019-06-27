package com.uca.capas.service;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Pelicula;
import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.PeliculaRepository;
import com.uca.capas.utils.Constants;

@Service
public class PeliculaServiceImpl implements PeliculaService{
	
	@Autowired
	private PeliculaRepository peliculaRepository;
	
	@Autowired 
	private HttpSession session;

	@Override
	public List<Pelicula> findAll() {
		return peliculaRepository.findByOrderByIdAsc();
	}

	@Override
	public Pelicula findOne(int id) {
		return peliculaRepository.findOne(id);
	}
	
	@Override
	public List<Pelicula> findActive() {
		return peliculaRepository.findByActivoOrderByIdAsc(true);
	}

	@Override
	@Transactional
	public void addPelicula(Pelicula p) {
		p.setFechaCreacion(Calendar.getInstance());
		p.setUsuarioCreacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		peliculaRepository.save(p);
	}

	@Override
	@Transactional
	public void editPelicula(Pelicula p) {
		Pelicula p2 = findOne(p.getId());
		p.setFechaCreacion(p2.getFechaCreacion());
		p.setUsuarioCreacion(p2.getUsuarioCreacion());
		p.setActivo(p2.getActivo());
		
		p.setFechaModificacion(Calendar.getInstance());
		p.setUsuarioModificacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		peliculaRepository.save(p);
	}

	@Override
	@Transactional
	public void activarPelicula(int id) {
		Pelicula p = peliculaRepository.findOne(id);
		p.setActivo(!p.getActivo());
		
		p.setFechaModificacion(Calendar.getInstance());
		p.setUsuarioModificacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		peliculaRepository.save(p);
	}
}
