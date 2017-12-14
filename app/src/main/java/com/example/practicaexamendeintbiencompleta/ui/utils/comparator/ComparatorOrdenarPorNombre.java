package com.example.practicaexamendeintbiencompleta.ui.utils.comparator;

import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;

import java.util.Comparator;

/**
 * Created by carlos on 13/12/2017.
 */

public class ComparatorOrdenarPorNombre implements Comparator<Persona> {
    @Override
    public int compare(Persona persona, Persona t1) {
        return persona.getNombre().compareTo(t1.getNombre());
    }
}
