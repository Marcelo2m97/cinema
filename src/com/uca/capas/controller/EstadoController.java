package com.uca.capas.controller;

import com.uca.capas.domain.Estado;
import com.uca.capas.service.EstadoService;
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
@RequestMapping("/states")
public class EstadoController {
    @Autowired
    private EstadoService estadoService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<Estado>> statesList(){
        List<Estado> estados = new ArrayList<>();
        try {
            estados = estadoService.findAll();
            return new ResponseEntity<>(estados, HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(estados, HttpStatus.NOT_FOUND);
        }
    }
}
