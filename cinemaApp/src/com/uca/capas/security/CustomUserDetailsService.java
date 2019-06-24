package com.uca.capas.security;

import com.uca.capas.domain.Rol;
import com.uca.capas.domain.Usuario;
import com.uca.capas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(username.trim().isEmpty()){
            throw new UsernameNotFoundException("Username está vacío");
        }

        Usuario usuario = usuarioService.findByUsername(username);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario " + username + "no encontrado");
        }

        return new User(usuario.getUsernameUsuario(), usuario.getPasswordUsuario(), getGrantedAuthorities(usuario));
    }

    private List<GrantedAuthority> getGrantedAuthorities(Usuario usuario){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        Rol role = usuario.getRolUsuario();
        authorities.add(new SimpleGrantedAuthority(role.getNombreRol()));
        return authorities;
    }
}
