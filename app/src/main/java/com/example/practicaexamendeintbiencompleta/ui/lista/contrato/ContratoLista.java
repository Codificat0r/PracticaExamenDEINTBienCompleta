package com.example.practicaexamendeintbiencompleta.ui.lista.contrato;

import android.content.Context;

import com.example.practicaexamendeintbiencompleta.adapter.PersonasAdapter;
import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;

import java.util.List;

/**
 * Created by carlos on 13/12/2017.
 */

public interface ContratoLista {

    interface Vista {
        void cargarDatos(List<Persona> personas);
        void mostrarLista(boolean mostrarLista);
    }

    interface Presentador {
        void pedirDatos();
        void ordenar(PersonasAdapter adapter, int tipoOrden);
        void ordenarPorOrdenActual(PersonasAdapter adapter);
        void pedirConsultarPreferenciaMostrarLista(Context contexto);
        void pedirBorrarPersona(Persona persona);
    }

}
