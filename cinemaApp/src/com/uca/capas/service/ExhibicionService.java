package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Exhibicion;

public interface ExhibicionService {

	public List<Exhibicion> findAll();
	
	public Exhibicion findOne(int id);
		
	public List<Exhibicion> findActive();
	
	public void addExhibicion(Exhibicion dto);
	
	public void editExhibicion(Exhibicion dto);
	
	public void activarExhibicion(int id);
}
