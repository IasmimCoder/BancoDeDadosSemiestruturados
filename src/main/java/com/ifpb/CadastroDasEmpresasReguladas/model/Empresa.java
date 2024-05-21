package com.ifpb.CadastroDasEmpresasReguladas.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "tb_empresa")
public class Empresa {

    @Id
    private String entcgc; //chave primaria

    @Column(nullable = false, unique = true)
    private String entcodigofip; 

    @ManyToOne //muitas empresas para um mercodigo
    @JoinColumn(name = "mercodigo_id", nullable = false)
    private DominioDeMercado mercodigo;
    
    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "endereco_id", referencedColumnName = "id")
    // private Endereco endereco; 

    @Column(nullable = false, unique = true)
    private String entnome;

    @Column(nullable = false)
    private LocalDateTime dataautorizacao;

    public Empresa() {
    }

    // public Empresa(DominioDeMercado mercodigo, String entcodigofip, String entnome, String entcgc, LocalDateTime dataautorizacao, Endereco enderEmpreseco) {
    //     this.mercodigo = mercodigo;
    //     this.entcodigofip = entcodigofip;
    //     this.entnome = entnome;
    //     this.entcgc = entcgc;
    //     this.dataautorizacao = dataautorizacao;
    //     // this.endereco = enderEmpreseco;
    // }

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

    // public Endereco getEndereco() {
    //     return this.endereco;
    // }

    // public void setEndereco(Endereco enderEmpreseco) {
    //     this.endereco = enderEmpreseco;
    // }

    // @Override
    // public String toString() {
    //     return "{" +
    //         " mercodigo='" + getMercodigo() + "'" +
    //         ", entcodigofip='" + getEntcodigofip() + "'" +
    //         ", entnome='" + getEntnome() + "'" +
    //         ", entcgc='" + getEntcgc() + "'" +
    //         ", dataautorizacao='" + getDataautorizacao() + "'" +
    //         ", enderEmpreseco='" + getEndereco() + "'" +
    //         "}";
    // }
    
}
