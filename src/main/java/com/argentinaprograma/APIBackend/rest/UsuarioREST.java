/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.argentinaprograma.APIBackend.rest;

import com.argentinaprograma.APIBackend.controller.UsuarioController;
import com.argentinaprograma.APIBackend.model.Usuario;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guille
 */
@RestController
public class UsuarioREST {

    @Autowired
    private UsuarioController usuarioController;

    @PostMapping("/usuario")
    public Usuario nuevoUsuario(@RequestBody Usuario nuevoUser) {
        Usuario usuario = new Usuario();
        usuario.setEmail(nuevoUser.getEmail());
        usuario.setPwd(nuevoUser.getPwd());
        usuario.setUser(nuevoUser.getUser());
        usuario.setToken(getJWTToken(nuevoUser.getUser()));
        usuarioController.save(usuario);
        return usuario;
    }

    private String getJWTToken(String username) {
        String secretKey = "frase";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
        String token = Jwts.builder()
                .setId("apiBackend")
                .setSubject(username)
                .claim("authorities", grantedAuthorities
                        .stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                /* SI SE QUIERE HACER QUE EL TOKEN EXPIRE LUEGO DE UN TIEMPO USAMOS LO SIGUIENTE * 900000 = 15 MINUTOS - 1 MINUTO  = 60000 MILISEGUNDOS
		.setExpiration(new Date(System.currentTimeMillis()+900000))
                */
                .signWith(SignatureAlgorithm.HS512, secretKey.getBytes())
                .compact();
        return "Bearer " + token;
    }

}
