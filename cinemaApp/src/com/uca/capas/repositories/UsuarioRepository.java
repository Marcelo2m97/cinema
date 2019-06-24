package com.uca.capas.repositories;

import com.uca.capas.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByUsernameUsuario(String username);
}
