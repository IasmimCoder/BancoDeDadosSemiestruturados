package com.ifpb.CadastroDasEmpresasReguladas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpb.CadastroDasEmpresasReguladas.exceptions.ExistingEntityException;
import com.ifpb.CadastroDasEmpresasReguladas.exceptions.NotFoundException;
import com.ifpb.CadastroDasEmpresasReguladas.model.Empresa;
import com.ifpb.CadastroDasEmpresasReguladas.repository.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa save(Empresa empresa) {
        
      //  if(empresaRepository.existsByEntNome(empresa.getEntnome())) {
      //   throw new ExistingEntityException("Já existe uma empresa cadastrada com esse nome!");
      //  }
       
       return empresaRepository.save(empresa);
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa findById(String codigo) {
       return empresaRepository.findById(codigo).orElseThrow(
        () -> new NotFoundException("Empresa não encontrada com o CNPJ: " + codigo)
       );
    }

    public Empresa update(String codigo, Empresa empresa) {
       Empresa empresaAtualizada = findById(codigo);
    
       empresaAtualizada.setEntcodigofip(empresa.getEntcodigofip());
       empresaAtualizada.setDataautorizacao(empresa.getDataautorizacao());
       empresaAtualizada.setEntnome(empresa.getEntnome());


       return save(empresaAtualizada);
    }

    public void deleteById(String codigo) {
       this.findById(codigo);
       empresaRepository.deleteById(codigo);
    }

}
