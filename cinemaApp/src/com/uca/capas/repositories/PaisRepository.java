package com.uca.capas.repositories;

/*<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Pais;

public interface PaisRepository extends JpaRepository<Pais, Integer>{

=======*/
import com.uca.capas.domain.Pais;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaisRepository extends JpaRepository<Pais, Long> {
}
