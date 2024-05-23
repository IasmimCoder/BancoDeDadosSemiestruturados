package com.ifpb.CadastroDasEmpresasReguladas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifpb.CadastroDasEmpresasReguladas.model.DominioDeMercado;
import com.ifpb.CadastroDasEmpresasReguladas.repository.DominioDeMercadoRepository;
import com.ifpb.CadastroDasEmpresasReguladas.service.DominioDeMercadoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/v1/dominioDeMercado")
public class DominioDeMercadoController {

    @Autowired
    private DominioDeMercadoService dominioDeMercadoService;

    @GetMapping()
    public ResponseEntity<List<DominioDeMercado>> findAll() {
        List<DominioDeMercado> listaDominios = dominioDeMercadoService.findAll();
        return ResponseEntity.ok(listaDominios);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<DominioDeMercado> getById(@PathVariable Integer codigo) {
        DominioDeMercado dominioDeMercado = dominioDeMercadoService.findById(codigo);
        return ResponseEntity.ok(dominioDeMercado);
    }

    @PostMapping()
    public ResponseEntity<DominioDeMercado> create(@RequestBody DominioDeMercado dominioDeMercado) {
        DominioDeMercado dominioNovo = dominioDeMercadoService.save(dominioDeMercado);
        
        return ResponseEntity.created(null).body(dominioNovo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DominioDeMercado> update(@PathVariable Integer id, @RequestBody DominioDeMercado dominioDeMercado) {
        DominioDeMercado dominioDeMercadoAtualizado = dominioDeMercadoService.update(dominioDeMercado);
        
        return ResponseEntity.ok(dominioDeMercadoAtualizado);
    }

    @DeleteMapping("/{codigo}")
    public void deleteById(@PathVariable Integer mercodigo){
        dominioDeMercadoService.deleteById(mercodigo);
    }
}
