package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Exhibicion;
import com.uca.capas.dto.ExhibicionDTO;

public interface ExhibicionService {

	public List<Exhibicion> findAll();
	
	public Exhibicion findOne(int id);
	
	public ExhibicionDTO findOneDTO(int id);
	
	public List<Exhibicion> findActive();
	
	public void addExhibicion(ExhibicionDTO dto);
	
	public void editExhibicion(ExhibicionDTO dto);
	
	public void activarExhibicion(int id);
}
