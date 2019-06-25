package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Pelicula;

public interface PeliculaService {

	public List<Pelicula> findAll();
	
	public Pelicula findOne(int id);
	
	public void addPelicula(Pelicula pelicula);
	
	public void editPelicula(Pelicula pelicula);
	
	public void activarPelicula(Pelicula pelicula);
}
