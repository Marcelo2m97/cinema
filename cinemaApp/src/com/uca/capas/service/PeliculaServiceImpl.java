package com.uca.capas.service;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Pelicula;
import com.uca.capas.repositories.PeliculaRepository;

@Service
public class PeliculaServiceImpl implements PeliculaService{
	
	@Autowired
	private PeliculaRepository peliculaRepository;

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
	public void addPelicula(Pelicula p) {
		p.setFechaCreacion(Calendar.getInstance());
		peliculaRepository.save(p);
	}

	@Override
	public void editPelicula(Pelicula p) {
		Pelicula p2 = findOne(p.getId());
		p.setFechaCreacion(p2.getFechaCreacion());
		p.setUsuarioCreacion(p2.getUsuarioCreacion());
		p.setActivo(p2.getActivo());
		p.setFechaModificacion(Calendar.getInstance());
		peliculaRepository.save(p);
	}

	@Override
	public void activarPelicula(int id) {
		Pelicula p = peliculaRepository.findOne(id);
		p.setActivo(!p.getActivo());
		peliculaRepository.save(p);
	}
}
