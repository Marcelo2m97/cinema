package com.uca.capas.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Exhibicion;
import com.uca.capas.dto.ExhibicionDTO;
import com.uca.capas.repositories.ExhibicionRepository;
import com.uca.capas.repositories.PeliculaRepository;
import com.uca.capas.repositories.SalaRepository;

@Service
public class ExhibicionServiceImpl implements ExhibicionService{

	@Autowired
	private ExhibicionRepository exhibicionRepository;
	
	@Autowired
	private SalaRepository salaRepository;
	
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	public List<ExhibicionDTO> findAll() {
		List<Exhibicion> exhibiciones = exhibicionRepository.findAll();
		List<ExhibicionDTO> dtoList = new ArrayList<>();
		for (Exhibicion e:exhibiciones) {
			ExhibicionDTO dto = new ExhibicionDTO();
			dto.setId(e.getId());
			dto.setHorario(e.getHorario());
			dto.setFormato(e.getFormato());
			dto.setIdSala(e.getPelicula().getId());
			dto.setIdPelicula(e.getPelicula().getId());
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public ExhibicionDTO findOne(int id) {
		Exhibicion e = exhibicionRepository.findOne(id);
		ExhibicionDTO dto = new ExhibicionDTO();
		dto.setId(e.getId());
		dto.setHorario(e.getHorario());
		dto.setFormato(e.getFormato());
		dto.setIdSala(e.getPelicula().getId());
		dto.setIdPelicula(e.getPelicula().getId());
		return dto;
	}

	@Override
	public void addExhibicion(ExhibicionDTO dto) {
		Exhibicion e = new Exhibicion();
		e.setId(dto.getId());
		e.setFormato(dto.getFormato());
		e.setHorario(dto.getHorario());
		e.setPelicula(peliculaRepository.findOne(dto.getIdPelicula()));
		e.setSala(salaRepository.findOne(dto.getIdSala()));
		//e.setFechaCreacion(Calendar.getInstance());
		exhibicionRepository.save(e);
	}

	@Override
	public void editExhibicion(ExhibicionDTO dto) {
		Exhibicion e = exhibicionRepository.findOne(dto.getId());
		e.setId(dto.getId());
		e.setFormato(dto.getFormato());
		e.setHorario(dto.getHorario());
		e.setPelicula(peliculaRepository.findOne(dto.getIdPelicula()));
		e.setSala(salaRepository.findOne(dto.getIdSala()));
		//e.setFechaModificacion(Calendar.getInstance());
		exhibicionRepository.save(e);
	}

	@Override
	public void activarExhibicion(ExhibicionDTO dto) {
		Exhibicion e = exhibicionRepository.findOne(dto.getId());
		//e.setActivo(!e.getActivo());
		exhibicionRepository.save(e);
	}
}