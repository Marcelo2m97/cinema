package com.uca.capas.repositories;

import com.uca.capas.domain.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {
}
