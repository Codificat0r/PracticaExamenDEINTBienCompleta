package com.example.practicaexamendeintbiencompleta.ui.lista.presentador;

import com.example.practicaexamendeintbiencompleta.ui.lista.contrato.ContratoEditarAnadir;
import com.example.practicaexamendeintbiencompleta.ui.lista.interactor.EditarAnadirInteractor;
import com.example.practicaexamendeintbiencompleta.ui.lista.interactor.EditarAnadirInteractorImpl;

/**
 * Created by carlos on 13/12/2017.
 */

public class EditarAnadirPresentador implements EditarAnadirInteractor.OnPeticionesListasListener, ContratoEditarAnadir.Presentador {

    private ContratoEditarAnadir.Vista vista;
    private EditarAnadirInteractor interactor;

    public EditarAnadirPresentador(ContratoEditarAnadir.Vista vista) {
        this.vista = vista;
        interactor = new EditarAnadirInteractorImpl(this);
    }

    @Override
    public void onNombreError() {
        vista.mostrarNombreError();
    }

    @Override
    public void onApellidoError() {
        vista.mostrarApellidoError();
    }

    @Override
    public void onPaisError() {
        vista.mostrarPaisError();
    }

    @Override
    public void onEdadError() {
        vista.mostrarEdadError();
    }

    @Override
    public void onTelefonoError() {
        vista.mostrarTelefonoError();
    }

    @Override
    public void onExito() {
        vista.finalizar();
    }

    @Override
    public void pedirAnadirPersona(String nombre, String apellido, String pais, String edad, String telefono) {
        interactor.anadirPersona(nombre, apellido, pais, edad, telefono);
    }

    @Override
    public void pedirEditarPersona(int id, String nombre, String apellido, String pais, String edad, String telefono) {
        interactor.editarPersona(id, nombre, apellido, pais, edad, telefono);
    }
}
