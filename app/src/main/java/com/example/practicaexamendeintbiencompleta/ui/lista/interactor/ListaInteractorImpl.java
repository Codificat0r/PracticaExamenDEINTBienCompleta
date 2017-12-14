package com.example.practicaexamendeintbiencompleta.ui.lista.interactor;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;
import com.example.practicaexamendeintbiencompleta.data.db.repositorio.PersonasRepositorio;

/**
 * Created by carlos on 13/12/2017.
 */

public class ListaInteractorImpl implements ListaInteractor {
    OnPeticionesListasListener listener;

    public ListaInteractorImpl(OnPeticionesListasListener listener) {
        this.listener = listener;
    }

    @Override
    public void obtenerDatos() {
        listener.onExito(PersonasRepositorio.getInstance().getPersonas());
    }

    @Override
    public void consultarPreferenciaMostrarLista(Context contexto) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(contexto);
        listener.onPreferenciaMostrarListaConsultada(preferences.getBoolean("mostrar_lista", true));
    }

    @Override
    public void borrarPersona(Persona persona) {
        PersonasRepositorio.getInstance().borrarPersona(persona);
        listener.onExito(PersonasRepositorio.getInstance().getPersonas());
    }
}
