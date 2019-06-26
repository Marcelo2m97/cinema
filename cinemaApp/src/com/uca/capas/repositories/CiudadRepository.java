package com.uca.capas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer>{

}
