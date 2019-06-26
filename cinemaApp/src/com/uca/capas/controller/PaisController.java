package com.uca.capas.controller;

import com.uca.capas.domain.Pais;
import com.uca.capas.service.PaisService;
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
@RequestMapping("/countries")
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Pais>> countriesList(){
        List<Pais> paises = new ArrayList<>();
        try {
            paises = paisService.findAll();
            return new ResponseEntity<List<Pais>>(paises, HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Pais>>(paises, HttpStatus.NOT_FOUND);
        }
    }
}
