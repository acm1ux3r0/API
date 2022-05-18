/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.rest;

import com.argentinaprograma.APIBackend.model.Experiencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaprograma.APIBackend.controller.ExperienciaController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author guille
 */
@RestController
@RequestMapping("/experiencia")
@CrossOrigin
public class ExperienciaREST {
    
    @Autowired
    private ExperienciaController experienciaController;
    
    @GetMapping("/lista")
    public List<Experiencia> everybody(){
        return experienciaController.findAll();
    }
    
}