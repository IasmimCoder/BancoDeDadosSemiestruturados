package com.ifpb.CadastroDasEmpresasReguladas.service;

import com.ifpb.CadastroDasEmpresasReguladas.exceptions.NotFoundException;
import com.ifpb.CadastroDasEmpresasReguladas.model.Contato;
import com.ifpb.CadastroDasEmpresasReguladas.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Contato findById(UUID id) {
        return contatoRepository.findById(id).orElseThrow(
            () -> new NotFoundException("Contato não encontrado!")
        );
    }

    public void delete(UUID id) {
        Optional<Contato> contatoOptional = contatoRepository.findById(id);
        if (contatoOptional.isEmpty()) {
            throw new NotFoundException("Contato não encontrado!");
        }
        contatoRepository.delete(contatoOptional.get());
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