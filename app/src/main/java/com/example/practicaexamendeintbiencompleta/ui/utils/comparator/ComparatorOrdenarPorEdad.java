package com.example.practicaexamendeintbiencompleta.ui.utils.comparator;

import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;

import java.util.Comparator;

/**
 * Created by carlos on 13/12/2017.
 */

public class ComparatorOrdenarPorEdad implements Comparator<Persona> {
    @Override
    public int compare(Persona persona, Persona t1) {
        if (persona.getEdad() > t1.getEdad())
            return 1;
        else if (persona.getEdad() == t1.getEdad())
            return 0;
        else
            return -1;
    }
}
