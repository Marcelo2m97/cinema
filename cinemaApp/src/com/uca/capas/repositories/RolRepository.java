package com.uca.capas.repositories;

/*<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;

import com.uca.capas.domain.Rol;

public interface RolRepository extends JpaRepository<Rol, Integer>{

=======*/
import com.uca.capas.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Long> {
}
