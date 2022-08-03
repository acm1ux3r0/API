/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.rest;

import com.argentinaprograma.APIBackend.model.Tecnologia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaprograma.APIBackend.controller.TecnologiaController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author guille
 */
@RestController
@RequestMapping("/tecnologia")
@CrossOrigin
public class TecnologiaREST {
    
    @Autowired
    private TecnologiaController tecnologiaController;
    
    @GetMapping("/lista")
    public List<Tecnologia> everybody(){
        return tecnologiaController.findAll();
    }
    
    @PostMapping("/nueva")
    public Long crearTecnologia(@RequestBody Tecnologia tecnologia) {
        tecnologiaController.save(tecnologia);
        return tecnologia.getId();
    }
    
// Eliminar una tecnologia por id
    @DeleteMapping("/eliminar/{id}")
    public String eliminarTecnologia(@PathVariable("id") Long id) {
        tecnologiaController.deleteById(id);
        return "El id: " + id +" fue eliminado correctamente";
    }
    
    // Actualizar una tecnologia por id
    @PutMapping("/actualizar")
    public Tecnologia editarTecnologia(@RequestBody Tecnologia tecnologia) {
        tecnologiaController.save(tecnologia);
        return tecnologia;
    }
    
}