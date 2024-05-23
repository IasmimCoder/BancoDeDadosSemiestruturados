package com.ifpb.CadastroDasEmpresasReguladas.repositories;

import com.ifpb.CadastroDasEmpresasReguladas.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository <Empresa, String> {

}