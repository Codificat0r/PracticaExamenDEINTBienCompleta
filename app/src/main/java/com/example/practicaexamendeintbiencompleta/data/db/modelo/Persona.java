package com.example.practicaexamendeintbiencompleta.data.db.modelo;

import android.support.annotation.NonNull;

import java.io.Serializable;

/**
 * Created by carlos on 13/12/2017.
 */

public class Persona implements Serializable, Comparable<Persona> {
    private int id;
    private String nombre;
    private String apellido;
    private String pais;
    private int edad;
    private String telefono;

    public Persona(int id, String nombre, String apellido, String pais, int edad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.edad = edad;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public int compareTo(@NonNull Persona persona) {
        return this.getNombre().compareTo(persona.getNombre());
    }
}
