/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.rest;

import com.argentinaprograma.APIBackend.controller.ExperienciaTecController;
import com.argentinaprograma.APIBackend.model.ExperienciaTec;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author acm1ux3r0
 */
@RestController
@RequestMapping("/experienciaTec")
@CrossOrigin
public class ExperienciaTecREST {
    
    @Autowired
    private ExperienciaTecController experienciaTecController;
    
    @GetMapping("/lista")
    public List<ExperienciaTec> everyOne() {
        return experienciaTecController.findAll();
    }
    
    @GetMapping("/tec/{nombreTec}")
    public Optional<ExperienciaTec> filteredByTec(@PathVariable("nombreTec") String nombreTec) {
        return experienciaTecController.findByNombreTec(nombreTec);
    }
    
}
