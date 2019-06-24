package com.uca.capas.service;

import com.uca.capas.domain.Usuario;
import javassist.tools.rmi.ObjectNotFoundException;

public interface UsuarioService {
    Usuario findByUsername(String username);
    Usuario findById(Long id) throws ObjectNotFoundException;
}
