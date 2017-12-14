package com.example.practicaexamendeintbiencompleta.data.db.repositorio;

import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by carlos on 13/12/2017.
 */

public class PersonasRepositorio {
    private ArrayList<Persona> personas;
    private static PersonasRepositorio personasRepositorio;

    static {
        personasRepositorio = new PersonasRepositorio();
    }

    private PersonasRepositorio() {
        personas = new ArrayList<>();
        inicializar();
    }

    public void anadirPersona(Persona persona) {
        this.personas.add(persona);
    }

    private void inicializar() {
        anadirPersona(new Persona(1,"Carlos", "Cruz", "España", 20, "680805232"));
        anadirPersona(new Persona(2,"Pepe", "Pérez", "España",18,  "645566454"));
        anadirPersona(new Persona(3,"Antonio", "Cáñamo",  "España",25, "678345643"));
        anadirPersona(new Persona(4,"Maria", "Roto",  "España",34, "656121312"));
        anadirPersona(new Persona(5,"Oscar", "Laville",  "España",22, "667887564"));
    }

    public static PersonasRepositorio getInstance() {
        return personasRepositorio;
    }

    public ArrayList<Persona> getPersonas() {
        Collections.sort(personas);
        return personas;
    }

    public void reemplazarPersona(Persona personaNueva, int idPersonaAReemplazar) {
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() == idPersonaAReemplazar) {
                personas.set(i, personaNueva);
            }
        }
    }

    public void borrarPersona(Persona persona) {
        personas.remove(persona);
    }

    public int siguienteIdLibre() {
        int proximoId = 0;
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getId() > proximoId)
                proximoId = personas.get(i).getId();
        }
        proximoId++;
        return proximoId;
    }
}
