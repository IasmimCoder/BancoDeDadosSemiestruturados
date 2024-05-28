package com.ifpb.CadastroDasEmpresasReguladas.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpb.CadastroDasEmpresasReguladas.model.Endereco;
import com.ifpb.CadastroDasEmpresasReguladas.repository.EnderecoRepository;

import com.ifpb.CadastroDasEmpresasReguladas.exceptions.NotFoundException;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public List<Endereco> findAll() {
       return enderecoRepository.findAll();
    }

    public Endereco findById(UUID id) {
        return enderecoRepository.findById(id).orElseThrow(
            () -> new NotFoundException("Endereço não encontrado")
        );
    }

    public void delete(UUID id) {
        this.findById(id);
        enderecoRepository.deleteById(id);
    }

    public Endereco save(Endereco endereco) {
       return enderecoRepository.save(endereco);
    }

    public Endereco update(Endereco endereco, UUID id) {
       Endereco enderecoAtualizado = findById(id);

       enderecoAtualizado.setBairro(endereco.getBairro());
       enderecoAtualizado.setCep(endereco.getCep());
       enderecoAtualizado.setCidade(endereco.getCidade());
       enderecoAtualizado.setEndereco(endereco.getEndereco());
    
       return save(enderecoAtualizado);
    }
}
