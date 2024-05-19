package com.mycompany.supermercado.models;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Venda {
    
    private Integer idVenda;
    private LocalDate dataVenda;
    private Double valorVenda; 
    private Integer idCliente;
    
    List<ItemVenda> itens = new ArrayList<>(); 

    public Venda(LocalDate dataVenda, Double valorVenda, Integer idCliente) {
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
        this.idCliente = idCliente;
    }

    public Venda(Integer idVenda, LocalDate dataVenda, Double valorVenda, Integer idCliente) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
        this.idCliente = idCliente;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public LocalDate getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDate dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }
}