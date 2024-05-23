package com.ifpb.CadastroDasEmpresasReguladas.service;

import com.ifpb.CadastroDasEmpresasReguladas.exceptions.NotFoundException;
import com.ifpb.CadastroDasEmpresasReguladas.model.Contato;
import com.ifpb.CadastroDasEmpresasReguladas.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ContatoService {

    @Autowired
    ContatoRepository contatoRepository;

    public List<Contato> findAll() {
        return contatoRepository.findAll();
    }

    public Optional<Contato> findById(UUID id) {
        Optional<Contato> contatoOptional = contatoRepository.findById(id);
        if(contatoOptional.isEmpty()) {
            throw new NotFoundException("Contato não encontrado!");
        }

        return contatoRepository.findById(id);
    }

    public String delete(UUID id) {
        Optional<Contato> contatoOptional = contatoRepository.findById(id);
        if (contatoOptional.isEmpty()) {
            throw new NotFoundException("Contato não encontrado!");
        }
        contatoRepository.delete(contatoOptional.get());

        return "Contato deletado!";
    }

    public Contato update(Contato contato, UUID id) {
        Optional<Contato> contatoOptional = contatoRepository.findById(id);
        if (contatoOptional.isEmpty()) {
            throw new NotFoundException("Contato não encontrado!");
        }
        contatoOptional.get().setDdd(contato.getDdd());
        contatoOptional.get().setFax(contato.getFax());
        contatoOptional.get().setTelefone(contato.getTelefone());

        return contatoRepository.save(contatoOptional.get());
    }
}