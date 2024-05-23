package com.ifpb.CadastroDasEmpresasReguladas.model;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_contato")
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @OneToOne(mappedBy = "contato")
    private Empresa empresa;

    @Column
    private String telefone;
    @Column
    private String ddd;
    @Column
    private String fax;

    public Contato() {
    }

    public Contato(String ddd, String telefone, String fax) {
        this.ddd = ddd;
        this.telefone = telefone;
        this.fax = fax;
    }

    public String getDdd() {
        return this.ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public UUID getId() {
        return this.id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Empresa getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "{" +
            " ddd='" + ddd + "'" +
            ", telefone='" + telefone + "'" +
            ", fax='" + fax + "'" +
            "}";
    }
}