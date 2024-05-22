package com.ifpb.CadastroDasEmpresasReguladas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifpb.CadastroDasEmpresasReguladas.model.DominioDeMercado;
import com.ifpb.CadastroDasEmpresasReguladas.repository.DominioDeMercadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/dominioDeMercado")
public class DominioDeMercadoController {

    @Autowired
    private DominioDeMercadoRepository dominioDeMercadoRepository;

    @GetMapping()
    public ResponseEntity<List<DominioDeMercado>> findAll() {
        List<DominioDeMercado> listaDominios = dominioDeMercadoRepository.findAll();
        return ResponseEntity.ok(listaDominios);
        
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<DominioDeMercado> getById(@PathVariable Integer codigo) {
        DominioDeMercado dominioDeMercado = dominioDeMercadoRepository.findById(codigo);
        return ResponseEntity.ok(dominioDeMercado);
    }
    

}
