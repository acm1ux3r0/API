/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.rest;

import com.argentinaprograma.APIBackend.model.Capacitacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaprograma.APIBackend.controller.CapacitacionController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author guille
 */
@RestController
@RequestMapping("/capacitacion")
@CrossOrigin
public class CapacitacionREST {
    
    @Autowired
    private CapacitacionController capacitacionController;
    
    @GetMapping("/lista")
    public List<Capacitacion> everybody(){
        return capacitacionController.findAll();
    }
    
}