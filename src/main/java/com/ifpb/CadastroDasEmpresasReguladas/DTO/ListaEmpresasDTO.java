package com.ifpb.CadastroDasEmpresasReguladas.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaEmpresasDTO {

    public ArrayList<EmpresaDTO> value;

    public ArrayList<EmpresaDTO> getValue() {
        return value;
    }

    public void setValue(ArrayList<EmpresaDTO> value) {
        this.value = value;
    }
}