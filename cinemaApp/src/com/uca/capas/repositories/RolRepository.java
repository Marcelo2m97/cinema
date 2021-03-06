package com.uca.capas.repositories;

import com.uca.capas.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
	
	public Rol findByNombre(String nombre);
}
