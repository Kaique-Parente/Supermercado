package com.mycompany.supermercado.models;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Venda {
    
    private Cliente cliente;
    private Integer quantidade;
    private Double total; 
    private Produto produto;
    private LocalDate data;
    
    List<Produto> itemVenda = new ArrayList<>(); 
    
    public Venda(Cliente cliente, Integer quantidade, Double total, Produto produto) {
        this.cliente = cliente;
        this.quantidade = quantidade;
        this.total = total;
        this.produto = produto;
        itemVenda.add(produto);
        data = LocalDate.now();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    public List<Produto> getItemVenda() {
        return itemVenda;
    }
}