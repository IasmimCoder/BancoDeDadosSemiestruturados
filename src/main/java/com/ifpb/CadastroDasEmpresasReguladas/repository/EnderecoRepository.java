package com.ifpb.CadastroDasEmpresasReguladas.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpb.CadastroDasEmpresasReguladas.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, UUID>{

}
