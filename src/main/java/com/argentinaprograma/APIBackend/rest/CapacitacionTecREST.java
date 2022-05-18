/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.rest;

import com.argentinaprograma.APIBackend.model.CapacitacionTec;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaprograma.APIBackend.controller.CapacitacionTecController;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author guille
 */
@RestController
@RequestMapping("/capacitacionTec")
@CrossOrigin
public class CapacitacionTecREST {
    
    @Autowired
    private CapacitacionTecController capacitacionTecController;
    
    @GetMapping("/lista")
    public List<CapacitacionTec> everyOne() {
        return capacitacionTecController.findAll();
    }
    
    @GetMapping("/tec/{nombreTec}")
    public Optional<CapacitacionTec> filteredByTec(@PathVariable("nombreTec") String nombreTec) {
        return capacitacionTecController.findByNombreTec(nombreTec);
    }
    
}