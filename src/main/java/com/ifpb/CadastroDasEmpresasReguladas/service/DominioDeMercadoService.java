package com.ifpb.CadastroDasEmpresasReguladas.service;

import java.util.List;
import org.springframework.http.ResponseEntity;

import com.ifpb.CadastroDasEmpresasReguladas.model.DominioDeMercado;
import com.ifpb.CadastroDasEmpresasReguladas.repository.DominioDeMercadoRepository;

import com.ifpb.CadastroDasEmpresasReguladas.exceptions.NotFoundException;

public class DominioDeMercadoService {

    private DominioDeMercadoRepository dominioDeMercadoRepository;

    public ResponseEntity<List<DominioDeMercado>> findAll() {
        List<DominioDeMercado> listaDominios = dominioDeMercadoRepository.findAll();
        return ResponseEntity.ok(listaDominios);
    }

    public ResponseEntity<DominioDeMercado> findById(Integer codigo) {
        DominioDeMercado dominioDeMercado = dominioDeMercadoRepository.findById(codigo).orElseThrow(
            () -> new NotFoundException("Domínio de mercado não encontrado com o código: " + codigo)
        );
        return ResponseEntity.ok(dominioDeMercado);
    }

}
