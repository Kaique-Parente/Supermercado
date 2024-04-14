package com.mycompany.supermercado.models;

import java.util.List;
import java.util.ArrayList;

public class Venda {
    
    private Cliente cliente;
    private Integer quantidade;
    private Double total; 
    
    List<Produto> itemVenda = new ArrayList<>(); 
    
}