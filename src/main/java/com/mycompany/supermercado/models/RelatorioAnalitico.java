package com.mycompany.supermercado.models;

public class RelatorioAnalitico {
    
    private final Venda venda;
    private final Produto produto;
    private final Long codBarras;
    private final Double valor;
    private final Integer quantidade;
    
    public RelatorioAnalitico(Venda venda) {
        this.venda = venda;
        produto = venda.getProduto();
        codBarras = produto.getCodigo();
        valor = produto.getValor();
        quantidade = produto.getQuantidade();
    }

    public Venda getVenda() {
        return venda;
    }

    public Produto getProduto() {
        return produto;
    }

    public Long getCodBarras() {
        return codBarras;
    }

    public Double getValor() {
        return valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    
    
}
