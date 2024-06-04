package com.ifpb.CadastroDasEmpresasReguladas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ifpb.CadastroDasEmpresasReguladas.model.DominioDeMercado;
import com.ifpb.CadastroDasEmpresasReguladas.service.DominioDeMercadoService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


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

    @PostMapping("/lista")
    public ResponseEntity<List<DominioDeMercado>> createList(@RequestBody List<DominioDeMercado> listaDeDominios) {
        for (DominioDeMercado dominioDeMercado : listaDeDominios) {
            create(dominioDeMercado);
        }
        
        return ResponseEntity.ok(listaDeDominios);
    }
    
    @PostMapping()
    public ResponseEntity<DominioDeMercado> create(@RequestBody DominioDeMercado dominioDeMercado) {
        DominioDeMercado dominioNovo = dominioDeMercadoService.save(dominioDeMercado);
        
        return ResponseEntity.created(null).body(dominioNovo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<DominioDeMercado> update(@PathVariable Integer codigo, @RequestBody DominioDeMercado dominioDeMercado) {
        return ResponseEntity.ok(dominioDeMercadoService.update(dominioDeMercado, codigo));
    }

    @DeleteMapping("/{codigo}")
    public void deleteById(@PathVariable Integer codigo){
        dominioDeMercadoService.deleteById(codigo);
    }

    @DeleteMapping()
    public void deleteAll(){
        dominioDeMercadoService.deleteAll();
    }
}
