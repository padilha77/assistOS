package com.assistos.model;

public class Cliente {
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private String id;

    // Construtor
    public Cliente(String nome, String cpf, String telefone, String email, String rg, String id) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.id = id;
    }


    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }
    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
}
