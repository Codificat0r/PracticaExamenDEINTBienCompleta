package com.example.practicaexamendeintbiencompleta.ui.utils;

/**
 * Created by carlos on 13/12/2017.
 */

public class CommonUtils {
    public static boolean comprobarCampoLleno(String texto) {
        if (texto.trim().isEmpty())
            return false;
        return true;
    }

    public static boolean comprobarLongitudCorrecta(String texto, int longitudRequerida) {
        if (texto.length() <= longitudRequerida)
            return true;
        return false;
    }
}
