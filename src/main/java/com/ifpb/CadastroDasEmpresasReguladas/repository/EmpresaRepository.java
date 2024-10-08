package com.ifpb.CadastroDasEmpresasReguladas.repository;

import com.ifpb.CadastroDasEmpresasReguladas.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, String> {
    long count();
}