package com.uca.capas.service;

import java.util.List;

import com.uca.capas.dto.ExhibicionDTO;

public interface ExhibicionService {

	public List<ExhibicionDTO> findAll();
	
	public ExhibicionDTO findOne(int id);
	
	public void addExhibicion(ExhibicionDTO dto);
	
	public void editExhibicion(ExhibicionDTO dto);
	
	public void activarExhibicion(ExhibicionDTO dto);
}
