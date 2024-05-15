package com.mycompany.supermercado.models;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ConverterData {
     public static Date convertToDate(LocalDate data) {
        return Date.from(data.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
    
    public static LocalDate convertToLocalDate(Date data) {
        return Instant.ofEpochMilli(data.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
    }
}
