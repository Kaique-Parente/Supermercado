package com.mycompany.supermercado.utils;

import java.util.regex.Pattern;

public class ValidarEmail {

    public String email;

    public static boolean validar(String email) {

        if (email == null || email.isEmpty()) {
            return false;
        }

        String emailRegex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                +"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();

    }

}
