package com.ifpb.CadastroDasEmpresasReguladas.controller;

import com.ifpb.CadastroDasEmpresasReguladas.model.DominioDeMercado;
import com.ifpb.CadastroDasEmpresasReguladas.model.Empresa;
import com.ifpb.CadastroDasEmpresasReguladas.model.EmpresaDTO;
import com.ifpb.CadastroDasEmpresasReguladas.service.EmpresaService;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.BeanUtils;
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
    public ResponseEntity<Empresa> saveEmpresa(@RequestBody EmpresaDTO empresaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(empresaService.save(empresaDTO));
    }

    @PostMapping("/lista")
    public ResponseEntity<List<EmpresaDTO>> createList(@RequestBody List<EmpresaDTO> listaDeEmpresas) {
        for (EmpresaDTO empresaDTO : listaDeEmpresas) {
            saveEmpresa(empresaDTO);
        }

        return ResponseEntity.ok(listaDeEmpresas);
    }

    @GetMapping()
    public ResponseEntity<List<Empresa>> findAll() {
        List<Empresa> listaDeEmpresas = empresaService.findAll();
        return ResponseEntity.ok(listaDeEmpresas);
    }

    @GetMapping("/{entcodigofip}")
    public ResponseEntity<Empresa> findById(@PathVariable(value = "entcodigofip") String entcodigofip) {
        Empresa empresa = empresaService.findById(entcodigofip);
        return ResponseEntity.ok(empresa);
    }

    @PutMapping("/{entcodigofip}")
    public ResponseEntity<Empresa> update(@PathVariable String entcodigofip, @RequestBody EmpresaDTO empresaDTO) {
        Empresa empresaAtualizada = empresaService.update(entcodigofip, empresaDTO);
        return ResponseEntity.ok(empresaAtualizada);
    }
    
    @DeleteMapping("/{entcodigofip}")
    public void deleteById(@PathVariable String entcodigofip){
        empresaService.deleteById(entcodigofip);
    }

    @DeleteMapping
    public void deleteAll(){
        empresaService.deleteAll();
    }
}