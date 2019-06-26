package com.uca.capas.controller;

import com.uca.capas.domain.Ciudad;
import com.uca.capas.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cities")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Ciudad>> citiesList(){
        List<Ciudad> ciudades = new ArrayList<>();
        try{
            ciudades = ciudadService.findAll();
            return new ResponseEntity<List<Ciudad>>(ciudades, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<List<Ciudad>>(ciudades, HttpStatus.NOT_FOUND);
        }
    }
}
