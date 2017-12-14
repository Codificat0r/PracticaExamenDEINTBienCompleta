package com.example.practicaexamendeintbiencompleta.ui.lista.interactor;

/**
 * Created by carlos on 13/12/2017.
 */

public interface EditarAnadirInteractor {
    void anadirPersona(String nombre, String apellido, String pais, String edad, String telefono);
    void editarPersona(int id, String nombre, String apellido, String pais, String edad, String telefono);

    interface OnPeticionesListasListener {
        void onNombreError();
        void onApellidoError();
        void onPaisError();
        void onEdadError();
        void onTelefonoError();
        void onExito();
    }
}
