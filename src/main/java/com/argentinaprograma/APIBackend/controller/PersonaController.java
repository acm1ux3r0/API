/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.controller;

import com.argentinaprograma.APIBackend.model.Persona;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author guille
 */
public interface PersonaController extends JpaRepository<Persona, Long> {
    
    public Optional<Persona> findByNombre(String nombre);
    public Optional<Persona> findByApellido(String apellido);
    public Optional<Persona> findByDni(String dni);
    public Optional<Persona> findByPaisResidencia(String paisResidencia);
    
}
