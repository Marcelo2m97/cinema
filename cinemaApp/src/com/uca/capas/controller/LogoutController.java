package com.uca.capas.controller;

import com.uca.capas.domain.Usuario;
import com.uca.capas.domain.response.UsuarioTransfer;
import com.uca.capas.service.UsuarioService;
import com.uca.capas.utils.Constants;
import com.uca.capas.utils.CustomMessage;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/logout")
public class LogoutController {
    @Autowired
    private UsuarioService usuarioService;
    
    
    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session) {
    	ModelAndView mav = new ModelAndView();
    	Usuario u = (Usuario)session.getAttribute(Constants.USER_SESSION);
    	u.setSesion(false);
    	usuarioService.saveUsuario(u);
        session.setAttribute(Constants.USER_SESSION, null);
        mav.setViewName("redirect:/login");
        return mav;
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<?> logout (@PathVariable("username") String username, HttpSession session){
        try {
            Usuario usuario = usuarioService.findByUsername(username);
            if(usuario.getSesion()){
                usuario.setSesion(false);
                usuarioService.saveUsuario(usuario);
                session.setAttribute(Constants.USER_SESSION, null);
                CustomMessage message = new CustomMessage("Se ha cerrado sesion correctamente");
                return new ResponseEntity<CustomMessage>(message, HttpStatus.OK);
            }
            if(!usuario.getSesion()){
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
