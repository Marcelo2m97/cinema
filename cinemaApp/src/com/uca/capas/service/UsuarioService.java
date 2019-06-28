package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Usuario;

import javassist.tools.rmi.ObjectNotFoundException;

public interface UsuarioService {
	
	public List<Usuario> findAll();
	
	public Usuario findOne(int id);
		
	public void addUsuario(Usuario u);
	
	public void registerUsuario(Usuario u);
	
	public void editUsuario(Usuario u);
	
	public void activarUsuario(int id, String motivo);
	
    public Usuario findByUsername(String username);
    
    public Usuario findById(int id) throws ObjectNotFoundException;
    
    public Usuario saveUsuario(Usuario usuario);
}
