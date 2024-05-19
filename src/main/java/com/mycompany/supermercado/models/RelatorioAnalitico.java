package com.mycompany.supermercado.models;

public class RelatorioAnalitico {
    
    private String nomeProduto;
    private Double valorProduto;
    private Integer qtdProduto;

    public RelatorioAnalitico(String nomeProduto, Double valorProduto, Integer qtdProduto) {
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.qtdProduto = qtdProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(Double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public Integer getQtdProduto() {
        return qtdProduto;
    }

    public void setQtdProduto(Integer qtdProduto) {
        this.qtdProduto = qtdProduto;
    }
    
    
    
}
