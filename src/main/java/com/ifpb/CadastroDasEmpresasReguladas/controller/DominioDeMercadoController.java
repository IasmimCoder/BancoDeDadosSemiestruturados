package com.ifpb.CadastroDasEmpresasReguladas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifpb.CadastroDasEmpresasReguladas.service.DominioDeMercadoService;

@RestController
@RequestMapping("/api/v1/dominioDeMercado")
public class DominioDeMercadoController {

    @Autowired
    private DominioDeMercadoService dominioDeMercadoService;

    // @GetMapping("/")
    // public String findAll() {
    //     List<DominioDeMercado> listaDominios = 
        
    // }

}
