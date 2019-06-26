package com.uca.capas.repositories;

/*<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{

=======*/
import com.uca.capas.domain.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
}
