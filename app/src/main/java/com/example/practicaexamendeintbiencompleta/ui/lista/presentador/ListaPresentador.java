package com.example.practicaexamendeintbiencompleta.ui.lista.presentador;

import android.content.Context;

import com.example.practicaexamendeintbiencompleta.adapter.PersonasAdapter;
import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;
import com.example.practicaexamendeintbiencompleta.ui.lista.contrato.ContratoLista;
import com.example.practicaexamendeintbiencompleta.ui.lista.interactor.ListaInteractor;
import com.example.practicaexamendeintbiencompleta.ui.lista.interactor.ListaInteractorImpl;
import com.example.practicaexamendeintbiencompleta.ui.utils.comparator.ComparatorOrdenarPorEdad;
import com.example.practicaexamendeintbiencompleta.ui.utils.comparator.ComparatorOrdenarPorNombre;

import java.util.List;

/**
 * Created by carlos on 13/12/2017.
 */

public class ListaPresentador implements ContratoLista.Presentador, ListaInteractor.OnPeticionesListasListener {

    private ContratoLista.Vista vista;
    private ListaInteractor interactor;
    public static final int ORDENAR_POR_NOMBRE = 0;
    public static final int ORDENAR_POR_EDAD = 1;
    private int ordenActual;

    public ListaPresentador(ContratoLista.Vista vista) {
        this.vista = vista;
        interactor = new ListaInteractorImpl(this);
        //Por defecto está ordenado por nombre
        ordenActual = ORDENAR_POR_NOMBRE;
    }

    @Override
    public void pedirDatos() {
        interactor.obtenerDatos();
    }

    @Override
    public void ordenar(PersonasAdapter adapter, int tipoOrden) {
        if (tipoOrden == ORDENAR_POR_NOMBRE) {
            adapter.sort(new ComparatorOrdenarPorNombre());
            ordenActual = ORDENAR_POR_NOMBRE;
        }
        if (tipoOrden == ORDENAR_POR_EDAD) {
            adapter.sort(new ComparatorOrdenarPorEdad());
            ordenActual = ORDENAR_POR_EDAD;
        }
    }

    @Override
    public void ordenarPorOrdenActual(PersonasAdapter adapter) {
        if (ordenActual == ORDENAR_POR_NOMBRE) {
            ordenar(adapter, ORDENAR_POR_NOMBRE);
        }
        if (ordenActual == ORDENAR_POR_EDAD) {
            ordenar(adapter, ORDENAR_POR_EDAD);
        }
    }

    @Override
    public void pedirConsultarPreferenciaMostrarLista(Context contexto) {
        interactor.consultarPreferenciaMostrarLista(contexto);
    }

    @Override
    public void onPreferenciaMostrarListaConsultada(boolean mostrarLista) {
        vista.mostrarLista(mostrarLista);
    }

    @Override
    public void onExito(List<Persona> personas) {
        vista.cargarDatos(personas);
    }

    @Override
    public void pedirBorrarPersona(Persona persona) {
        interactor.borrarPersona(persona);
    }

}
