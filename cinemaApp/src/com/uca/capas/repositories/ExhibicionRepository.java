package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Exhibicion;

public interface ExhibicionRepository extends JpaRepository<Exhibicion, Integer>{

	public List<Exhibicion> findByOrderByIdAsc();
	
	public List<Exhibicion> findByActivoOrderByIdAsc(boolean activo);
}
