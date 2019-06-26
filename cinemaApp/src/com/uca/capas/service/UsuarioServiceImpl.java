package com.uca.capas.service;

/*<<<<<<< HEAD
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uca.capas.domain.Usuario;
import com.uca.capas.dto.UsuarioDTO;
import com.uca.capas.repositories.CiudadRepository;
import com.uca.capas.repositories.EstadoRepository;
import com.uca.capas.repositories.PaisRepository;
import com.uca.capas.repositories.RolRepository;
import com.uca.capas.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PaisRepository paisRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CiudadRepository ciudadRepository;
	
	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findByOrderByIdAsc();
	}

	@Override
	public Usuario findOne(int id) {
		return usuarioRepository.findOne(id);
	}
	
	@Override
	public UsuarioDTO findOneDTO(int id) {
		Usuario u = usuarioRepository.findOne(id);
		UsuarioDTO dto = new UsuarioDTO();
		dto.setId(u.getId());
		dto.setNombre(u.getNombre());
		dto.setApellido(u.getApellido());
		dto.setUsername(u.getUsername());
		dto.setPassword(u.getPassword());
		dto.setDireccion(u.getDireccion());
		dto.setFechaNacimiento(u.getFechaNacimiento());
		dto.setSaldo(u.getSaldo());
		dto.setIdCiudad(u.getCiudad().getId());
		dto.setIdEstado(u.getEstado().getId());
		dto.setIdPais(u.getPais().getId());
		dto.setIdRol(u.getRol().getId());
		return dto;
	}

	@Override
	public void addUsuario(UsuarioDTO dto) {
		Usuario u = new Usuario();
		u.setNombre(dto.getNombre());
		u.setApellido(dto.getApellido());
		u.setUsername(dto.getUsername());
		u.setPassword(dto.getPassword());
		u.setDireccion(dto.getDireccion());
		u.setFechaNacimiento(dto.getFechaNacimiento());
		u.setSaldo(dto.getSaldo());
		u.setCiudad(ciudadRepository.findOne(dto.getIdCiudad()));
		u.setEstado(estadoRepository.findOne(dto.getIdEstado()));
		u.setPais(paisRepository.findOne(dto.getIdPais()));
		u.setRol(rolRepository.findOne(dto.getIdRol()));
		usuarioRepository.save(u);
	}

	@Override
	public void editUsuario(UsuarioDTO dto) {
		Usuario u = usuarioRepository.findOne(dto.getId());
		u.setNombre(dto.getNombre());
		u.setApellido(dto.getApellido());
		u.setUsername(dto.getUsername());
		u.setPassword(dto.getPassword());
		u.setDireccion(dto.getDireccion());
		u.setFechaNacimiento(dto.getFechaNacimiento());
		u.setSaldo(dto.getSaldo());
		u.setCiudad(ciudadRepository.findOne(dto.getIdCiudad()));
		u.setEstado(estadoRepository.findOne(dto.getIdEstado()));
		u.setPais(paisRepository.findOne(dto.getIdPais()));
		u.setRol(rolRepository.findOne(dto.getIdRol()));
		usuarioRepository.save(u);
	}

	@Override
	public void activarUsuario(int id) {
		Usuario u = new Usuario();
		u.setActivo(!u.getActivo());
		usuarioRepository.save(u);
	}
=======*/
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

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        try {
            Usuario usuario1 = usuarioRepository.saveAndFlush(usuario);
            return usuario1;
        }catch (Exception e){
            throw e;
        }
    }
}
