package com.ifpb.CadastroDasEmpresasReguladas.controller;

import com.ifpb.CadastroDasEmpresasReguladas.model.Contato;
import com.ifpb.CadastroDasEmpresasReguladas.repositories.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/contato")
public class ContatoController {

    @Autowired
    ContatoRepository contatoRepository;

    @GetMapping
    public ResponseEntity<List<Contato>> getAllContatos(){
        return ResponseEntity.status(HttpStatus.OK).body(contatoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneContato(@PathVariable(value = "id") UUID id){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);
        if (!contatoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(contatoOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteContato(@PathVariable(value = "id") UUID id){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);
        if (contatoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado!");
        }
        contatoRepository.delete(contatoOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body(("O contato foi deletado!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateContato(@PathVariable(value = "id") UUID id, @RequestBody Contato contato){
        Optional<Contato> contatoOptional = contatoRepository.findById(id);
        if (contatoOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contato não encontrado!.");
        }
        contato.setId(id);
        return ResponseEntity.status(HttpStatus.OK).body(contatoRepository.save(contato));
    }
}