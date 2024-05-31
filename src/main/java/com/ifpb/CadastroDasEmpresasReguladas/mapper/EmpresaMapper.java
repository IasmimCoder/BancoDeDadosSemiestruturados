package com.ifpb.CadastroDasEmpresasReguladas.mapper;

import com.ifpb.CadastroDasEmpresasReguladas.model.*;
import org.springframework.stereotype.Component;

@Component
public class EmpresaMapper {

    public static Empresa toEntity(EmpresaDTO empresaDTO) {
        var empresa = new Empresa();
        var contato = new Contato(empresaDTO.getDdd(),empresaDTO.getTelefone(),empresaDTO.getFax());
        var endereco = new Endereco(empresaDTO.getEndereco(),empresaDTO.getBairro(),empresaDTO.getCidade(),empresaDTO.getCep());

        empresa.setMercodigo(new DominioDeMercado(empresaDTO.getMercodigo()));
        empresa.setEndereco(verNullEndereco(endereco));
        empresa.setContato(verNullContato(contato));

        empresaDTO = verNullEmpresa(empresaDTO);

        empresa.setEntcodigofip(empresaDTO.getEntcodigofip());
        empresa.setEntnome(empresaDTO.getEntnome());
        empresa.setEntcgc(empresaDTO.getEntcgc());

        return empresa;
    }

    public static Contato verNullContato(Contato contato){
        if (contato.getDdd()==null){
            contato.setDdd("Não registrado!");
        }
        if (contato.getFax()==null){
            contato.setFax("Não registrado!");
        }
        if (contato.getTelefone()==null){
            contato.setTelefone("Não registrado!");
        }
        return contato;
    }

    public static Endereco verNullEndereco(Endereco endereco){
        if (endereco.getEndereco()==null){
            endereco.setEndereco("Não registrado!");
        }
        if (endereco.getBairro()==null){
            endereco.setBairro("Não registrado!");
        }
        if (endereco.getCep()==null){
            endereco.setCep("Não registrado!");
        }
        if (endereco.getCidade()==null){
            endereco.setCidade("Não registrado!");
        }
        return endereco;
    }

    public static EmpresaDTO verNullEmpresa(EmpresaDTO empresaDTO){
        if (empresaDTO.getDataautorizacao()==null){
            empresaDTO.setDataautorizacao("Não registrado!");
        }
        if (empresaDTO.getEntcgc()==null||empresaDTO.getEntcgc().equals("00000000000000")){
            empresaDTO.setEntcgc("Não registrado!");
        }
        if(empresaDTO.getDataautorizacao()==null){
            empresaDTO.setDataautorizacao("Não registrado!");
        }
        return empresaDTO;
    }
}