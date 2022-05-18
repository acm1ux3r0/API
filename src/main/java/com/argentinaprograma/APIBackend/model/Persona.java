/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author guille
 */
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String email;

    @Column
    private Integer edad;

    @Column
    private String dni;

    @Column
    private String paisResidencia;
    
    @Column
    private String urlImg;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propietario")
    private List<Tecnologia> tecnologias;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propietario")
    private List<Experiencia> experiencias;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propietario")
    private List<SoftSkill> softSkills;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_propietario")
    private List<Capacitacion> capacitacion;
        
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private List<Localidad> localidad;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getPaisResidencia() {
        return paisResidencia;
    }
    
    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public void setPaisResidencia(String paisResidencia) {
        this.paisResidencia = paisResidencia;
    }
    
    public List<Tecnologia> getTecnologias() {
        return tecnologias;
    }

    public void setTecnologias(List<Tecnologia> tecnologias) {
        this.tecnologias = tecnologias;
    }

    public List<Experiencia> getExperiencias() {
        return experiencias;
    }

    public void setExperiencias(List<Experiencia> experiencias) {
        this.experiencias = experiencias;
    }

    public List<SoftSkill> getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(List<SoftSkill> softSkills) {
        this.softSkills = softSkills;
    }

    public List<Capacitacion> getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(List<Capacitacion> capacitacion) {
        this.capacitacion = capacitacion;
    }
    
    public List<Localidad> getLocalidad() {
        return localidad;
    }

    public void setLocalidad(List<Localidad> localidad) {
        this.localidad = localidad;
    }

}
