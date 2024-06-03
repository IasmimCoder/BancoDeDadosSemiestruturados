package com.ifpb.CadastroDasEmpresasReguladas.mapper;

import com.ifpb.CadastroDasEmpresasReguladas.model.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

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
        empresa.setDataautorizacao(empresaDTO.getDataautorizacao());

        return empresa;
    }

    private static boolean validarTelefone(String telefone){
        //retira todos os caracteres não-numéricos (incluindo espaço,tab, etc)
       telefone = telefone.replaceAll("\\D","");

        if (telefone.startsWith("0800")) {

            //verifica se tem a qtde de numeros correta
            if (telefone.length() == 11){
                return true;
            }
            return false;
        }

        //verifica se tem a qtde de numeros correta
        if (!(telefone.length() >= 8 && telefone.length() <= 10)) return false;

       //verifica se o numero foi digitado com todos os dígitos iguais
       java.util.regex.Pattern p = java.util.regex.Pattern.compile(telefone.charAt(0)+"{"+telefone.length()+"}");
       java.util.regex.Matcher m = p.matcher(telefone);
       if(m.find()) return false;

       return true;
    }

    private static boolean validarFax(String fax){
    
       //retira todos os caracteres não-numéricos (incluindo espaço,tab, etc)
       fax = fax.replaceAll("\\D","");
   
       //verifica se tem a qtde de numeros correta
       if (!(fax.length() >= 8 && fax.length() <= 10)) return false;
    
       //verifica se o numero foi digitado com todos os dígitos iguais
       java.util.regex.Pattern p = java.util.regex.Pattern.compile(fax.charAt(0)+"{"+fax.length()+"}");
       java.util.regex.Matcher m = p.matcher(fax);
       if(m.find()) return false;
   
       //Se o número só tiver dez digitos não é um celular e por isso o número logo após o DDD deve ser 2, 3, 4, 5 ou 7 
       Integer[] prefixos = {2, 3, 4, 5, 7};
   
       if (fax.length() == 10 && java.util.Arrays.asList(prefixos).indexOf(Integer.parseInt(fax.substring(2, 3))) == -1) return false;
    
       //se passar por todas as validações acima, então está tudo certo
       return true;
    }

    public static boolean verificarDDD(String ddd){
        
        String[] DDDs = {
                "11", "12", "13", "14", "15", "16", "17", "18", "19",
                "21", "22", "24", "27", "28", "31", "32", "33", "34",
                "35", "37", "38", "41", "42", "43", "44", "45", "46",
                "47", "48", "49", "51", "53", "54", "55", "61", "62",
                "64", "63", "65", "66", "67", "68", "69", "71", "73",
                "74", "75", "77", "79", "81", "82", "83", "84", "85",
                "86", "87", "88", "89", "91", "92", "93", "94", "95",
                "96", "97", "98", "99"};

        for(String d: DDDs){
            if(ddd.equals(d)){
                return true;
            }
        }
        return false;
    }

    public static Contato verNullContato(Contato contato){
        if (contato.getDdd()==null){
            contato.setDdd("Não registrado!");
        } else if (!verificarDDD(contato.getDdd())) {
            contato.setDdd("Não registrado!");
        }

        if (contato.getFax()==null){
            contato.setFax("Não registrado!");
        }
        else if (!validarFax(contato.getFax())){
            contato.setFax("Não registrado!");
        }
        
        if (contato.getTelefone()==null||contato.getTelefone().isEmpty()){
            contato.setTelefone("Não registrado!");
        }
        else if (!validarTelefone(contato.getTelefone())){
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
        return empresaDTO;
    }
}