package com.uca.capas.repositories;

import com.uca.capas.domain.Usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
    public List<Usuario> findByOrderByIdAsc();

    public Usuario findByUsername(String username);    
}
