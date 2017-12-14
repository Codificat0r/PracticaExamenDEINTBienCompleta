package com.example.practicaexamendeintbiencompleta.ui.lista.interactor;

import android.content.Context;

import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;

import java.util.List;

/**
 * Created by carlos on 13/12/2017.
 */

public interface ListaInteractor {
    void obtenerDatos();
    void consultarPreferenciaMostrarLista(Context contexto);
    void borrarPersona(Persona persona);

    interface OnPeticionesListasListener {
        void onExito(List<Persona> personas);
        void onPreferenciaMostrarListaConsultada(boolean mostrarLista);
    }
}
