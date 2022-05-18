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
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author guill
 */
@Getter
@Setter
@Entity
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String empresa;

    @Column
    private String rolTrabajo;

    @Column
    private String tiempo;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_experiencia")
    private List<ExperienciaTec> experienciaTecs;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_persona")
    private List<Localidad> localidad;
    
}
