package com.uca.capas.service;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.UsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        try {
            Usuario usuario = usuarioRepository.findByUsernameUsuario(username);
            return usuario;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(Long id) throws ObjectNotFoundException {
        Usuario usuario = usuarioRepository.findOne(id);
        if(usuario == null){
            throw new ObjectNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }
}
