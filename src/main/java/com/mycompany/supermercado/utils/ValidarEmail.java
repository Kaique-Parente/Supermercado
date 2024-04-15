package com.mycompany.supermercado.utils;

import java.util.regex.Pattern;

public class ValidarEmail {

    public String email;

    public static String validar(String email) {

        if (email == null || email.isEmpty()) {
            return "E-mail inválido";
        }

        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailRegex);
        if (pattern.matcher(email).matches()) {
            return "E-mail válido";
        } else {
            return "E-mail inválido";
        }

    }

}
