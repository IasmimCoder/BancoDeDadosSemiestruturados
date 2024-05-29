package com.ifpb.CadastroDasEmpresasReguladas.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_empresa")
public class Empresa {

    @Id
    private String entcodigofip; //chave primária

    @Column
    private String entcgc;

    @Column(nullable = false)
    private String entnome;

    @Column
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime dataautorizacao;

    @ManyToOne
    @JoinColumn(name = "mercodigo_id", nullable = false)
    private DominioDeMercado mercodigo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_empresa_contato",
            joinColumns = @JoinColumn(name = "empresa_id", referencedColumnName = "entcodigofip"),
            inverseJoinColumns = @JoinColumn(name = "contato_id", referencedColumnName = "id"))
    private Contato contato = new Contato();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "tb_empresa_endereco",
            joinColumns = @JoinColumn(name = "empresa_id", referencedColumnName = "entcodigofip"),
            inverseJoinColumns = @JoinColumn(name = "endereco_id", referencedColumnName = "id"))
    private Endereco endereco = new Endereco();

    public Empresa() {
    }

    public Empresa(DominioDeMercado mercodigo, String entcodigofip, String entnome, String entcgc, LocalDateTime dataautorizacao, Contato contato, Endereco endereco) {
        this.mercodigo = mercodigo;
        this.entcodigofip = entcodigofip;
        this.entnome = entnome;
        this.entcgc = entcgc;
        this.dataautorizacao = dataautorizacao;
        this.contato = contato;
        this.endereco = endereco;
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

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Empresa{" +
                "entcgc='" + entcgc + '\'' +
                ", entcodigofip='" + entcodigofip + '\'' +
                ", entnome='" + entnome + '\'' +
                ", dataautorizacao=" + dataautorizacao +
                ", mercodigo=" + mercodigo +
                ", contato=" + contato +
                ", endereco=" + endereco +
                '}';
    }
}
