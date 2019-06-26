package com.uca.capas.controller;

import com.uca.capas.domain.Rol;
import com.uca.capas.service.RolService;
import javassist.tools.rmi.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @RequestMapping(value = "/getAllRole", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Rol>> getAllRoles() {

        try {
            List<Rol> roles = rolService.findAll();
            return new ResponseEntity<List<Rol>>(roles, HttpStatus.OK);

        } catch (ObjectNotFoundException ex) {
            ex.printStackTrace();
            return new ResponseEntity<List<Rol>>(Collections.emptyList(), HttpStatus.UNPROCESSABLE_ENTITY);
        }

        catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Rol>>(Collections.emptyList(), HttpStatus.EXPECTATION_FAILED);
        }

    }

}
