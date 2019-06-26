package com.uca.capas.repositories;

/*<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer>{

=======*/
import com.uca.capas.domain.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoRepository extends JpaRepository<Estado, Long> {
}
