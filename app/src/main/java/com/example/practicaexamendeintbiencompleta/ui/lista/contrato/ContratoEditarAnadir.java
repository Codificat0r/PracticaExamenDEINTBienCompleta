package com.example.practicaexamendeintbiencompleta.ui.lista.contrato;

/**
 * Created by carlos on 13/12/2017.
 */

public interface ContratoEditarAnadir {
    int EDITAR = 0;
    int ANADIR = 1;

    interface Vista {
        void finalizar();
        void mostrarNombreError();
        void mostrarApellidoError();
        void mostrarPaisError();
        void mostrarEdadError();
        void mostrarTelefonoError();
    }

    interface Presentador {
        void pedirAnadirPersona(String nombre, String apellido, String pais, String edad, String telefono);
        void pedirEditarPersona(int id, String nombre, String apellido, String pais, String edad, String telefono);
    }
}
