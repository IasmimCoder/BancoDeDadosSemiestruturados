package com.ifpb.CadastroDasEmpresasReguladas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifpb.CadastroDasEmpresasReguladas.model.DominioDeMercado;
import com.ifpb.CadastroDasEmpresasReguladas.repository.DominioDeMercadoRepository;

import com.ifpb.CadastroDasEmpresasReguladas.exceptions.NotFoundException;

@Service
public class DominioDeMercadoService {

    @Autowired
    private DominioDeMercadoRepository dominioDeMercadoRepository;

    public List<DominioDeMercado> findAll() {
        return dominioDeMercadoRepository.findAll();
    }

    public DominioDeMercado findById(Integer codigo) {
        return dominioDeMercadoRepository.findById(codigo).orElseThrow(
            () -> new NotFoundException("Domínio de mercado não encontrado com o código: " + codigo)
        );
    }

    public DominioDeMercado save(DominioDeMercado dominioDeMercado) {
       return dominioDeMercadoRepository.save(dominioDeMercado);
    }

    public DominioDeMercado update(DominioDeMercado dominioDeMercado, Integer codigo) {
        DominioDeMercado dominioDeMercadoAtualizado = dominioDeMercadoRepository.findById(codigo).get();
        dominioDeMercadoAtualizado.setDescricao(dominioDeMercado.getDescricao());

        return save(dominioDeMercadoAtualizado);
    }

    public void deleteById(Integer mercodigo) {
        this.findById(mercodigo);
        dominioDeMercadoRepository.deleteById(mercodigo);
    }
}