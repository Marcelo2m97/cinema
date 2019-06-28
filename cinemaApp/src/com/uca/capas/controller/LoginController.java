package com.uca.capas.controller;

import com.uca.capas.domain.Usuario;
import com.uca.capas.domain.request.AuthenticationRequest;
import com.uca.capas.domain.response.UsuarioTransfer;
import com.uca.capas.service.UsuarioService;
import com.uca.capas.utils.Constants;
import com.uca.capas.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("customUserDetailsService")
    private UserDetailsService customUserDetailsService;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<UsuarioTransfer> authenticate(@RequestBody AuthenticationRequest authenticationRequest, HttpSession session) {
    	try {
            String username = authenticationRequest.getUsername();
            String password = authenticationRequest.getPassword();

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
            Authentication authentication = this.authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(username);
            try {
                Usuario usuario = usuarioService.findByUsername(userDetails.getUsername());
                if (usuario.getSesion()) {
                    return new ResponseEntity<UsuarioTransfer>(new UsuarioTransfer("Error. El usuario ya cuenta con una sesion activa", 498), HttpStatus.UNAUTHORIZED);
                }
                if (!usuario.getActivo()) {
                    return new ResponseEntity<UsuarioTransfer>(new UsuarioTransfer("Error. La cuenta del usuario no se encuentra activa, por: "+usuario.getMensaje(), 499), HttpStatus.NOT_ACCEPTABLE);
                }
            } catch (Exception exi){
                exi.printStackTrace();
                return new ResponseEntity<UsuarioTransfer>(new UsuarioTransfer("Hubo un error a la hora de obtener la sesion del usuario", 422), HttpStatus.UNPROCESSABLE_ENTITY);
            }

            List<String> roles = new ArrayList<>();

            for (GrantedAuthority authority : userDetails.getAuthorities()) {
                roles.add(authority.toString());
            }
            try {
                Usuario usuario = usuarioService.findByUsername(userDetails.getUsername());
                usuario.setSesion(true);
                usuarioService.saveUsuario(usuario);
                session.setAttribute(Constants.USER_SESSION, usuario);
                return new ResponseEntity<UsuarioTransfer>(new UsuarioTransfer(userDetails.getUsername(), roles, TokenUtil.createToken(userDetails), 200, "Usuario loggeado correctamente"), HttpStatus.OK);
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<UsuarioTransfer>(new UsuarioTransfer("Hubo un error a la hora de setear la sesion del usuario", 422), HttpStatus.UNPROCESSABLE_ENTITY);
            }
        } catch (BadCredentialsException bce) {
            bce.printStackTrace();
            return new ResponseEntity<UsuarioTransfer>(new UsuarioTransfer("No se encontro el usuario", 404), HttpStatus.NOT_FOUND);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}

