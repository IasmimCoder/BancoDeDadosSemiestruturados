package com.ifpb.CadastroDasEmpresasReguladas.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.ifpb.CadastroDasEmpresasReguladas.mapper.EmpresaMapper;
import com.ifpb.CadastroDasEmpresasReguladas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ifpb.CadastroDasEmpresasReguladas.exceptions.ExistingEntityException;
import com.ifpb.CadastroDasEmpresasReguladas.exceptions.NotFoundException;
import com.ifpb.CadastroDasEmpresasReguladas.repository.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa save(EmpresaDTO empresaDTO) {
        return empresaRepository.save(EmpresaMapper.toEntity(empresaDTO));
    }

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa findById(String entcodigofip) {
       return empresaRepository.findById(entcodigofip).orElseThrow(
        () -> new NotFoundException("Empresa não encontrada com o Código: " + entcodigofip)
       );
    }

    public Empresa update(String entcodigofip, EmpresaDTO empresaDTO) {

        Empresa empresaAtualizada = findById(entcodigofip);

        if(empresaDTO.getDataautorizacao()!=null) {
            String s = empresaDTO.getDataautorizacao();
            DateTimeFormatter parser = DateTimeFormatter.ofPattern("uuuu-MM-dd");
            LocalDateTime dateTime = LocalDate.parse(s, parser).atStartOfDay();
            empresaAtualizada.setDataautorizacao(dateTime);
        }
        empresaAtualizada.setEntcgc(empresaDTO.getEntcgc());
        empresaAtualizada.setEntnome(empresaDTO.getEntnome());

        return empresaRepository.save(empresaAtualizada);
    }

    public void deleteById(String entcodigofip) {
       this.findById(entcodigofip);
       empresaRepository.deleteById(entcodigofip);
    }

    public void deleteAll(){
      empresaRepository.deleteAll();
    }

    public List<Empresa> findByName(String nome) {
        List<Empresa> empresas = new ArrayList<>();
        for (Empresa empresa : findAll()) {
            if(nome.equals(empresa.getEntnome())){
                empresas.add(empresa);
            }
        }

        if(empresas.isEmpty()){
            throw new NotFoundException("Empresa não encontrada!");
        }
        return empresas;
    }

    public List<Empresa> findByMercodigo(Integer mercodigo) {
        List<Empresa> empresas = new ArrayList<>();
        for (Empresa empresa : findAll()) {
            if(mercodigo.equals(empresa.getMercodigo().getCodigo())){
                empresas.add(empresa);
            }
        }

        if(empresas.isEmpty()){
            throw new NotFoundException("Nenhuma empresa cadastrada com esse código de mercado!");
        }
        return empresas;
    }
}