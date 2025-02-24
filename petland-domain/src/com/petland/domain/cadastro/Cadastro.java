package com.petland.domain.cadastro;

public class Cadastro {
    private Integer id;
    private String nome;
    private Perfil perfil;
    private Endereco endereco;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Perfil getPerfil() {
        return this.perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public Endereco getEndereco() {
        return this.endereco;
    }

    public void setEndereco(Endereco enderecoEndereco) {
        this.endereco = enderecoEndereco;
    }

};