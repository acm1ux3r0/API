/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.rest;

import com.argentinaprograma.APIBackend.controller.SoftSkillController;
import com.argentinaprograma.APIBackend.model.SoftSkill;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guille
 */
@RestController
@RequestMapping("softSkill")
@CrossOrigin
public class SoftSkillREST {
    @Autowired
    private SoftSkillController softSkillController;
    
    @GetMapping("/lista")
    public List<SoftSkill> everybody() {
        return softSkillController.findAll();
    }
}
