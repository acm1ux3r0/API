/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.rest;

import com.argentinaprograma.APIBackend.controller.LocalidadController;
import com.argentinaprograma.APIBackend.model.Localidad;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guille
 */
@RestController
@RequestMapping("/localidad")
@CrossOrigin
public class LocalidadREST {
    
    @Autowired
    private LocalidadController localidadController;
    
    @GetMapping("/lista")
    public List<Localidad> everybody(){
        return localidadController.findAll();
    }
    
    @PostMapping("/nueva")
    public Long crearLocalidad(@RequestBody Localidad localidad) {
        localidadController.save(localidad);
        return localidad.getId();
    }
    
}
