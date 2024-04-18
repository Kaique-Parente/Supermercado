package com.mycompany.supermercado.models;

import java.time.LocalDate;

public class RelatorioSintetico {
    
    private final Venda venda;
    private final LocalDate data;
    private final Cliente cliente;
    private final Double valor;

    public RelatorioSintetico(Venda venda) {
        this.venda = venda;
        data = venda.getData();
        cliente = venda.getCliente();
        valor = venda.getTotal();
    }

    public Venda getVenda() {
        return venda;
    }

    public LocalDate getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Double getValor() {
        return valor;
    }
}
