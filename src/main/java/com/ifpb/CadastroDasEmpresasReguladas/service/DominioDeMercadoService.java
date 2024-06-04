package com.ifpb.CadastroDasEmpresasReguladas.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifpb.CadastroDasEmpresasReguladas.DTO.ListaDominiosDTO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ifpb.CadastroDasEmpresasReguladas.model.DominioDeMercado;
import com.ifpb.CadastroDasEmpresasReguladas.repository.DominioDeMercadoRepository;
import com.ifpb.CadastroDasEmpresasReguladas.exceptions.NotFoundException;

@Service
public class DominioDeMercadoService {

    @Autowired
    private DominioDeMercadoRepository dominioDeMercadoRepository;

    public List<DominioDeMercado> findAll() {
        return dominioDeMercadoRepository.findAll();
    }

    public DominioDeMercado findById(Integer codigo) {
        return dominioDeMercadoRepository.findById(codigo).orElseThrow(
            () -> new NotFoundException("Domínio de mercado não encontrado com o código: " + codigo)
        );
    }

    public DominioDeMercado save(DominioDeMercado dominioDeMercado) {
       return dominioDeMercadoRepository.save(dominioDeMercado);
    }

    public DominioDeMercado update(DominioDeMercado dominioDeMercado, Integer codigo) {
        DominioDeMercado dominioDeMercadoAtualizado = dominioDeMercadoRepository.findById(codigo).get();
        dominioDeMercadoAtualizado.setDescricao(dominioDeMercado.getDescricao());

        return save(dominioDeMercadoAtualizado);
    }

    public void deleteById(Integer codigo) {
        this.findById(codigo);
        dominioDeMercadoRepository.deleteById(codigo);
    }

    @PostConstruct
    public void getGovToTableDominioMercado() throws IOException, InterruptedException {

        if (dominioDeMercadoRepository.count()==0) {

            try {
                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://dados.susep.gov.br/olinda/servico/empresas/versao/v1/odata/DominioMercado?$format=json")).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                ObjectMapper mapper = new ObjectMapper();
                ListaDominiosDTO listaDominiosDTO = mapper.readValue(response.body(), ListaDominiosDTO.class);

                for(DominioDeMercado dominioDeMercado: listaDominiosDTO.value){
                    save(dominioDeMercado);
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteAll() {
        dominioDeMercadoRepository.deleteAll();
    }
}