package com.uca.capas.service;

import com.uca.capas.domain.Usuario;
import com.uca.capas.repositories.CiudadRepository;
import com.uca.capas.repositories.EstadoRepository;
import com.uca.capas.repositories.PaisRepository;
import com.uca.capas.repositories.RolRepository;
import com.uca.capas.repositories.UsuarioRepository;
import com.uca.capas.utils.Constants;

import javassist.tools.rmi.ObjectNotFoundException;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("usuarioService")
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

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
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired 
	private HttpSession session;
	
	@Override
	public List<Usuario> findAll() {
		return usuarioRepository.findByOrderByIdAsc();
	}

	@Override
	public Usuario findOne(int id) {
		Usuario u = usuarioRepository.findOne(id);
		u.setIdCiudad(u.getCiudad().getId());
		u.setIdEstado(u.getEstado().getId());
		u.setIdPais(u.getPais().getId());
		u.setIdRol(u.getRol().getId());
		return u;
	}

	@Override
	@Transactional
	public void addUsuario(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		u.setCiudad(ciudadRepository.findOne(u.getIdCiudad()));
		u.setEstado(estadoRepository.findOne(u.getIdEstado()));
		u.setPais(paisRepository.findOne(u.getIdPais()));
		u.setRol(rolRepository.findOne(u.getIdRol()));
		
		u.setFechaCreacion(Calendar.getInstance());
		u.setUsuarioCreacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		usuarioRepository.save(u);
	}

	@Override
	@Transactional
	public void editUsuario(Usuario u) {
		Usuario u2 = usuarioRepository.findOne(u.getId());
		u.setUsername(u2.getUsername());
		u.setPassword(u2.getPassword());
		u.setActivo(u2.getActivo());
		
		u.setCiudad(ciudadRepository.findOne(u.getIdCiudad()));
		u.setEstado(estadoRepository.findOne(u.getIdEstado()));
		u.setPais(paisRepository.findOne(u.getIdPais()));
		u.setRol(rolRepository.findOne(u.getIdRol()));
		
		u.setFechaModificacion(Calendar.getInstance());
		u.setUsuarioModificacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		usuarioRepository.save(u);
	}

	@Override
	@Transactional
	public void activarUsuario(int id, String motivo) {
		Usuario u = usuarioRepository.findOne(id);
		u.setActivo(!u.getActivo());
		u.setMensaje(motivo);
		u.setFechaModificacion(Calendar.getInstance());
		u.setUsuarioModificacion((Usuario)session.getAttribute(Constants.USER_SESSION));
		usuarioRepository.save(u);
	}

    @Override
    @Transactional(readOnly = true)
    public Usuario findByUsername(String username) {
        try {
            Usuario usuario = usuarioRepository.findByUsername(username);
            return usuario;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(int id) throws ObjectNotFoundException {
        Usuario usuario = usuarioRepository.findOne(id);
        if(usuario == null){
            throw new ObjectNotFoundException("Usuario no encontrado");
        }
        return usuario;
    }

    @Override
	@Transactional
    public Usuario saveUsuario(Usuario usuario) {
        try {
            Usuario usuario1 = usuarioRepository.saveAndFlush(usuario);
            return usuario1;
        }catch (Exception e){
            throw e;
        }
    }

	@Override
	@Transactional
	public void registerUsuario(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		u.setCiudad(ciudadRepository.findOne(u.getIdCiudad()));
		u.setEstado(estadoRepository.findOne(u.getIdEstado()));
		u.setPais(paisRepository.findOne(u.getIdPais()));
		u.setRol(rolRepository.findByNombre("Cliente"));
		u.setSaldo(BigDecimal.valueOf(20));
		u.setActivo(true);
		
		u.setFechaCreacion(Calendar.getInstance());
		usuarioRepository.save(u);		
	}
}
