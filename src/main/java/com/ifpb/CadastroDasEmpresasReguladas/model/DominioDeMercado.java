package com.ifpb.CadastroDasEmpresasReguladas.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_dominio_mercado")
public class DominioDeMercado {

    @Id
    @JsonProperty("Codigo")
    private Integer codigo;

    @Column(nullable = false, unique = true, length = 23)
    @JsonProperty("Descricao")
    private String descricao;

    @OneToMany(mappedBy = "mercodigo", cascade = CascadeType.ALL)
    private List<Empresa> empresas;

    public DominioDeMercado(Integer codigo){
        this.codigo = codigo;
    }

    public DominioDeMercado(){}

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