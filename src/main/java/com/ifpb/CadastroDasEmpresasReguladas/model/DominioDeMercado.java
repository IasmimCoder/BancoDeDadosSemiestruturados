package com.ifpb.CadastroDasEmpresasReguladas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_dominio_empresa")
public class DominioDeMercado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer codigo;
    private String descricao;

    // Getters e Setters
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
