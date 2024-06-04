package com.ifpb.CadastroDasEmpresasReguladas.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ifpb.CadastroDasEmpresasReguladas.model.DominioDeMercado;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListaDominiosDTO {

    public ArrayList<DominioDeMercado> value;

    public ArrayList<DominioDeMercado> getValue() {
        return value;
    }

    public void setValue(ArrayList<DominioDeMercado> value) {
        this.value = value;
    }
}