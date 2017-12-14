package com.example.practicaexamendeintbiencompleta.ui.lista.interactor;

import android.content.Intent;

import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;
import com.example.practicaexamendeintbiencompleta.data.db.repositorio.PersonasRepositorio;
import com.example.practicaexamendeintbiencompleta.ui.utils.CommonUtils;

/**
 * Created by carlos on 13/12/2017.
 */

public class EditarAnadirInteractorImpl implements EditarAnadirInteractor {
    private OnPeticionesListasListener listener;

    public EditarAnadirInteractorImpl(OnPeticionesListasListener listener) {
        this.listener = listener;
    }

    @Override
    public void anadirPersona(String nombre, String apellido, String pais, String edad, String telefono) {
        if (!CommonUtils.comprobarCampoLleno(nombre)) {
            listener.onNombreError();
        } else if (!CommonUtils.comprobarCampoLleno(apellido)) {
            listener.onApellidoError();
        } else if (!CommonUtils.comprobarCampoLleno(pais)) {
            listener.onPaisError();
        } else if (!CommonUtils.comprobarCampoLleno(edad) || !CommonUtils.comprobarLongitudCorrecta(edad, 2)) {
            listener.onEdadError();
        } else if (!CommonUtils.comprobarCampoLleno(telefono) || !CommonUtils.comprobarLongitudCorrecta(telefono, 9)) {
            listener.onTelefonoError();
        } else {
            PersonasRepositorio repo = PersonasRepositorio.getInstance();
            repo.anadirPersona(new Persona(repo.siguienteIdLibre(), nombre, apellido, pais, Integer.parseInt(edad), telefono));
            listener.onExito();
        }
    }

    @Override
    public void editarPersona(int id, String nombre, String apellido, String pais, String edad, String telefono) {
        if (!CommonUtils.comprobarCampoLleno(nombre)) {
            listener.onNombreError();
        } else if (!CommonUtils.comprobarCampoLleno(apellido)) {
            listener.onApellidoError();
        } else if (!CommonUtils.comprobarCampoLleno(pais)) {
            listener.onPaisError();
        } else if (!CommonUtils.comprobarCampoLleno(edad) || !CommonUtils.comprobarLongitudCorrecta(edad, 2)) {
            listener.onEdadError();
        } else if (!CommonUtils.comprobarCampoLleno(telefono) || !CommonUtils.comprobarLongitudCorrecta(telefono, 9)) {
            listener.onTelefonoError();
        } else {
            PersonasRepositorio repo = PersonasRepositorio.getInstance();
            repo.reemplazarPersona(new Persona(id, nombre, apellido, pais, Integer.parseInt(edad), telefono), id);
            listener.onExito();
        }
    }
}
