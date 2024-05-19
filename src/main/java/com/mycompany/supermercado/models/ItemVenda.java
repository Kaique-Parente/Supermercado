package com.mycompany.supermercado.models;

public class ItemVenda {
    
    private Integer idItemVenda;
    private Integer idVenda;
    private long idProduto;
    private Integer qtProduto;
    private Double vlrUnitario;

    public ItemVenda(Integer idItemVenda, Integer idVenda, long idProduto, Integer qtProduto, Double vlrUnitario) {
        this.idItemVenda = idItemVenda;
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.qtProduto = qtProduto;
        this.vlrUnitario = vlrUnitario;
    }

    public ItemVenda(Integer idVenda, long idProduto, Integer qtProduto, Double vlrUnitario) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.qtProduto = qtProduto;
        this.vlrUnitario = vlrUnitario;
    }

    public ItemVenda(long idProduto, Integer qtProduto, Double vlrUnitario) {
        this.idProduto = idProduto;
        this.qtProduto = qtProduto;
        this.vlrUnitario = vlrUnitario;
    }

    public Integer getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(Integer idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public Integer getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Integer idVenda) {
        this.idVenda = idVenda;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public Integer getQtProduto() {
        return qtProduto;
    }

    public void setQtProduto(Integer qtProduto) {
        this.qtProduto = qtProduto;
    }

    public Double getVlrUnitario() {
        return vlrUnitario;
    }

    public void setVlrUnitario(Double vlrUnitario) {
        this.vlrUnitario = vlrUnitario;
    }
    
    
    
}
