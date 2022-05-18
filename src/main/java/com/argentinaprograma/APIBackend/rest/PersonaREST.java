/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.rest;

import com.argentinaprograma.APIBackend.controller.PersonaController;
import com.argentinaprograma.APIBackend.model.Persona;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guille
 */
@RestController
@RequestMapping("/persona")
@CrossOrigin
public class PersonaREST {
    
    @Autowired
    private PersonaController personaController;
    
    @GetMapping("/lista")
    public List<Persona> everybody(){
        return personaController.findAll();
    }
    
    @GetMapping("/nombre/{nombre}")
    public Optional<Persona> buscarPorNombre(@PathVariable("nombre") String nombre) {
        return personaController.findByNombre(nombre);
    }
    
    @GetMapping("/apellido/{apellido}")
    public Optional<Persona> buscarPorApellido(@PathVariable("apellido") String apellido) {
        return personaController.findByApellido(apellido);
    }
    
    @GetMapping("/dni/{dni}")
    public Optional<Persona> buscarPorDNI(@PathVariable("dni") String dni) {
        return personaController.findByDni(dni);
    }
    
    @GetMapping("/pais/{pais}")
    public Optional<Persona> buscarPorPaisResidencia(@PathVariable("paisResidencia") String paisResidencia) {
        return personaController.findByPaisResidencia(paisResidencia);
    }
    
    // Crear una nueva persona
    @PostMapping("/nueva")
    public Long crearPersona(@RequestBody Persona persona) {
        personaController.save(persona);
        return persona.getId();
    }
    
    // Eliminar una persona por id
    @DeleteMapping("/eliminar/{id}")
    public String eliminarPersona(@PathVariable("id") Long id) {
        personaController.deleteById(id);
        return "El id: " + id +" fue eliminado correctamente";
    }
    
    // Actualizar una persona por id
    @PutMapping("/actualizar")
    public Persona editarPersona(@RequestBody Persona persona) {
        personaController.save(persona);
        return persona;
    }
}
