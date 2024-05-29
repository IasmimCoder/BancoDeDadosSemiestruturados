package com.ifpb.CadastroDasEmpresasReguladas.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.ifpb.CadastroDasEmpresasReguladas.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpb.CadastroDasEmpresasReguladas.exceptions.ExistingEntityException;
import com.ifpb.CadastroDasEmpresasReguladas.exceptions.NotFoundException;
import com.ifpb.CadastroDasEmpresasReguladas.repository.EmpresaRepository;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository empresaRepository;

    public Empresa save(EmpresaDTO empresaDTO) {
        var empresa = new Empresa();
        var contato = new Contato(empresaDTO.getDdd(),empresaDTO.getTelefone(),empresaDTO.getFax());
        var endereco = new Endereco(empresaDTO.getEndereco(),empresaDTO.getBairro(),empresaDTO.getCidade(),empresaDTO.getCep());

        empresa.setMercodigo(new DominioDeMercado(empresaDTO.getMercodigo()));
        empresa.setEndereco(endereco);
        empresa.setContato(contato);
        empresa.setEntcodigofip(empresaDTO.getEntcodigofip());
        empresa.setEntnome(empresaDTO.getEntnome());
        empresa.setEntcgc(empresaDTO.getEntcgc());

        if(empresaDTO.getDataautorizacao()!=null){
            String s = empresaDTO.getDataautorizacao();
            DateTimeFormatter parser = DateTimeFormatter.ofPattern("uuuu-MM-dd");
            LocalDateTime dateTime = LocalDate.parse(s, parser).atStartOfDay();
            empresa.setDataautorizacao(dateTime);
        }

        return empresaRepository.save(empresa);
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
}