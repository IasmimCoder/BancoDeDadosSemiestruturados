package com.ifpb.CadastroDasEmpresasReguladas.controller;

import com.ifpb.CadastroDasEmpresasReguladas.model.Empresa;
import com.ifpb.CadastroDasEmpresasReguladas.service.EmpresaService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) //gera uma fila
@RequestMapping("/api/v1/empresa")
public class EmpresaController {

    @Autowired
    EmpresaService empresaService;

    @PostMapping
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody Empresa empresa) {
        Empresa empresaCriada = empresaService.save(empresa);

        return ResponseEntity.status(HttpStatus.CREATED).body(empresaCriada);
    }

    @GetMapping()
    public ResponseEntity<List<Empresa>> findAll() {
        List<Empresa> listaDeEmpresas = empresaService.findAll();
        return ResponseEntity.ok(listaDeEmpresas);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Empresa> findById(@RequestParam String codigo) {
        Empresa empresa = empresaService.findById(codigo);
        return ResponseEntity.ok(empresa);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Empresa> update(@PathVariable String codigo, @RequestBody Empresa empresa) {
        Empresa empresaAtualizada = empresaService.update(codigo, empresa);
        return ResponseEntity.ok(empresaAtualizada);
    }
    
    @DeleteMapping
    public void deleteById(@PathVariable String codigo){
        empresaService.deleteById(codigo);
    }
    
}
