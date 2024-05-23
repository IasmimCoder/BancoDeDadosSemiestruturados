package com.ifpb.CadastroDasEmpresasReguladas.controller;

import com.ifpb.CadastroDasEmpresasReguladas.model.Empresa;
import com.ifpb.CadastroDasEmpresasReguladas.repositories.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @PostMapping
    public ResponseEntity<Object> saveEmpresa(@RequestBody Empresa empresa) {
//        if(empresaRepository.existsByEntNome(empresa.getEntnome())) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).body("Já existe uma empresa cadastrada com esse nome!");
//        }

        return ResponseEntity.status(HttpStatus.CREATED).body(empresaRepository.save(empresa));
    }
}
