package com.ifpb.CadastroDasEmpresasReguladas.service;


import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifpb.CadastroDasEmpresasReguladas.DTO.EmpresaDTO;
import com.ifpb.CadastroDasEmpresasReguladas.DTO.ListaEmpresasDTO;
import com.ifpb.CadastroDasEmpresasReguladas.mapper.EmpresaMapper;
import com.ifpb.CadastroDasEmpresasReguladas.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

        empresaAtualizada.setDataautorizacao(empresaDTO.getDataautorizacao());
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

    @PostConstruct
    public void getGovToTableEmpresa() throws IOException, InterruptedException {

        if (empresaRepository.count()==0) {

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://dados.susep.gov.br/olinda/servico/empresas/versao/v1/odata/DadosCadastrais?$format=json")).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                ObjectMapper mapper = new ObjectMapper();
                ListaEmpresasDTO listaEmpresasDTO = mapper.readValue(response.body(), ListaEmpresasDTO.class);

                for(EmpresaDTO empresaDTO: listaEmpresasDTO.value){
                    save(empresaDTO);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}