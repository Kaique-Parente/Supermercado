package com.mycompany.supermercado.models;

import java.util.Date;

public class RelatorioSintetico {
    
    private Date dataVenda;
    private Integer idCliente;
    private String nome;
    private Float vlrVenda;

    public RelatorioSintetico(Date dataVenda, Integer idCliente, String nome, Float vlrVenda) {
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.nome = nome;
        this.vlrVenda = vlrVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getVlrVenda() {
        return vlrVenda;
    }

    public void setVlrVenda(Float vlrVenda) {
        this.vlrVenda = vlrVenda;
    }
}
