package com.uca.capas.controller;

import com.uca.capas.domain.Usuario;
import com.uca.capas.domain.response.UsuarioTransfer;
import com.uca.capas.service.UsuarioService;
import com.uca.capas.utils.CustomMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/logout")
public class LogoutController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(value = "/{username}")
    public ResponseEntity<?> logout (@PathVariable("username") String username){
        try {
            Usuario usuario = usuarioService.findByUsername(username);
            if(usuario.getSesionUsuario()){
                usuario.setSesionUsuario(false);
                usuarioService.saveUsuario(usuario);
                CustomMessage message = new CustomMessage("Se ha cerrado sesión correctamente");
                return new ResponseEntity<CustomMessage>(message, HttpStatus.OK);
            }
            if(!usuario.getSesionUsuario()){
                CustomMessage message = new CustomMessage("El usuario no tiene sesiones activas");
                return new ResponseEntity<CustomMessage>(message, HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            CustomMessage message = new CustomMessage("Error a la hora de encontrar el usuario");
            return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return null;
    }
}
