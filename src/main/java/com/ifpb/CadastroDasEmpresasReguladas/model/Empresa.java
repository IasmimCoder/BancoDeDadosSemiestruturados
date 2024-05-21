package com.ifpb.CadastroDasEmpresasReguladas.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tb_empresa")
public class Empresa {


    private String entcgc; //chave primaria
    private String entcodigofip; //chave primaria

    // @ManyToOne
    // @JoinColumn(name = "mercodigo_id")
    private DominioDeMercado mercodigo;
    
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    private Endereco enderEmpreseco; 

    private String entnome;
    private LocalDateTime dataautorizacao;

    public Empresa() {
    }

    public Empresa(DominioDeMercado mercodigo, String entcodigofip, String entnome, String entcgc, LocalDateTime dataautorizacao, Endereco enderEmpreseco) {
        this.mercodigo = mercodigo;
        this.entcodigofip = entcodigofip;
        this.entnome = entnome;
        this.entcgc = entcgc;
        this.dataautorizacao = dataautorizacao;
        this.enderEmpreseco = enderEmpreseco;
    }

    public DominioDeMercado getMercodigo() {
        return this.mercodigo;
    }

    public void setMercodigo(DominioDeMercado mercodigo) {
        this.mercodigo = mercodigo;
    }

    public String getEntcodigofip() {
        return this.entcodigofip;
    }

    public void setEntcodigofip(String entcodigofip) {
        this.entcodigofip = entcodigofip;
    }

    public String getEntnome() {
        return this.entnome;
    }

    public void setEntnome(String entnome) {
        this.entnome = entnome;
    }

    public String getEntcgc() {
        return this.entcgc;
    }

    public void setEntcgc(String entcgc) {
        this.entcgc = entcgc;
    }

    public LocalDateTime getDataautorizacao() {
        return this.dataautorizacao;
    }

    public void setDataautorizacao(LocalDateTime dataautorizacao) {
        this.dataautorizacao = dataautorizacao;
    }

    public Endereco getEnderEmpreseco() {
        return this.enderEmpreseco;
    }

    public void setEnderEmpreseco(Endereco enderEmpreseco) {
        this.enderEmpreseco = enderEmpreseco;
    }

    @Override
    public String toString() {
        return "{" +
            " mercodigo='" + getMercodigo() + "'" +
            ", entcodigofip='" + getEntcodigofip() + "'" +
            ", entnome='" + getEntnome() + "'" +
            ", entcgc='" + getEntcgc() + "'" +
            ", dataautorizacao='" + getDataautorizacao() + "'" +
            ", enderEmpreseco='" + getEnderEmpreseco() + "'" +
            "}";
    }
    
}
