package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer>{
	
	public List<Pelicula> findByOrderByIdAsc();
}
