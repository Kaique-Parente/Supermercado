package com.mycompany.supermercado.utils;

public class Conversor {
    
    public static Double converterValor(String t){
        return Double.valueOf(t.substring(3).replace(',', '.'));
    }
    
}
