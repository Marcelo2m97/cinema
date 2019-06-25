package com.uca.capas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Sala;

public interface SalaRepository extends JpaRepository<Sala, Integer>{

	public List<Sala> findByOrderByIdAsc();
}
