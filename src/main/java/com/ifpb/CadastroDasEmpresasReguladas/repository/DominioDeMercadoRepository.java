package com.ifpb.CadastroDasEmpresasReguladas.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpb.CadastroDasEmpresasReguladas.model.DominioDeMercado;

@Repository
public interface DominioDeMercadoRepository extends JpaRepository<DominioDeMercado, Integer>{
    long count();
}
