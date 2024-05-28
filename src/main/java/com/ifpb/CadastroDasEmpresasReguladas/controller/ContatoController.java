package com.ifpb.CadastroDasEmpresasReguladas.controller;

import com.ifpb.CadastroDasEmpresasReguladas.model.Contato;
import com.ifpb.CadastroDasEmpresasReguladas.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<Contato>> getAllContatos() {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> getOneContato(@PathVariable(value = "id") UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.findById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteContato(@PathVariable(value = "id") UUID id) {
        contatoService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contato> updateContato(@PathVariable(value = "id") UUID id, @RequestBody Contato contato) {
        return ResponseEntity.status(HttpStatus.OK).body(contatoService.update(contato, id));
    }
}