package com.mycompany.supermercado.models;

import java.time.LocalDate;

public class Produto {
    
    private long codigo;
    private String nome;
    private String marca;
    private String categoria;
    private Double valor;
    private LocalDate validade;
    private Integer quantidade;
    private boolean status;

    public Produto(long codigo, String nome, String marca, String categoria, Double valor, LocalDate validade, Integer quantidade, boolean status) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.valor = valor;
        this.validade = validade;
        this.quantidade = quantidade;
        this.status = status;
    }

    public Produto(String nome, String marca, String categoria, Double valor, LocalDate validade, Integer quantidade, boolean status) {
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.valor = valor;
        this.validade = validade;
        this.quantidade = quantidade;
        this.status = status;
    }

    public Produto(long codigo, String nome, String marca, Double valor, Integer quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.marca = marca;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getValidade() {
        return validade;
    }

    public void setValidade(LocalDate validade) {
        this.validade = validade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
   
}
