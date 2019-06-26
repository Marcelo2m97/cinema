package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Usuario;
import com.uca.capas.dto.UsuarioDTO;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findOne(int id);
	
	public UsuarioDTO findOneDTO(int id);
	
	public void addUsuario(UsuarioDTO dto);
	
	public void editUsuario(UsuarioDTO dto);
	
	public void activarUsuario(int id);
}
