package com.uca.capas.controller;

import com.uca.capas.domain.Usuario;
import com.uca.capas.service.UsuarioService;
import com.uca.capas.utils.CustomError;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getUserById(@PathVariable("userId") Long userId) {

        try {
            Usuario user = usuarioService.findById(userId);
            return new ResponseEntity<Usuario>(user, HttpStatus.OK);

        } catch (ObjectNotFoundException ex) {
            ex.printStackTrace();
            CustomError error = new CustomError("User with id = " + userId + " is not found");
            return new ResponseEntity<CustomError>(error, HttpStatus.UNPROCESSABLE_ENTITY);

        } catch (Exception e) {
            e.printStackTrace();
            CustomError error = new CustomError("An error has occured");
            return new ResponseEntity<CustomError>(error, HttpStatus.EXPECTATION_FAILED);
        }

    }

}

