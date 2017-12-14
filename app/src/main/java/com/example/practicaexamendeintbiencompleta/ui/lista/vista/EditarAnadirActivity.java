package com.example.practicaexamendeintbiencompleta.ui.lista.vista;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import com.example.practicaexamendeintbiencompleta.R;
import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;
import com.example.practicaexamendeintbiencompleta.ui.lista.contrato.ContratoEditarAnadir;
import com.example.practicaexamendeintbiencompleta.ui.lista.presentador.EditarAnadirPresentador;

public class EditarAnadirActivity extends AppCompatActivity implements ContratoEditarAnadir.Vista {

    private ContratoEditarAnadir.Presentador presentador;
    private TextInputLayout tilNombre;
    private TextInputLayout tilApellido;
    private TextInputLayout tilPais;
    private TextInputLayout tilEdad;
    private TextInputLayout tilTelefono;
    private TextInputEditText edtNombre;
    private TextInputEditText edtApellido;
    private TextInputEditText edtPais;
    private TextInputEditText edtEdad;
    private TextInputEditText edtTelefono;
    private FloatingActionButton fab;
    private Persona persona;
    private int id;
    private int accion;
    public static final String ACCION = "accion";
    public static final String PERSONA = "persona";
    public static final String ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_anadir);

        inicializar();

        if (accion == ContratoEditarAnadir.EDITAR) {
            persona = (Persona) getIntent().getSerializableExtra(PERSONA);
            id = getIntent().getIntExtra(ID, 0);
        }
    }

    private void inicializar() {
        tilNombre = findViewById(R.id.tilNombre);
        tilApellido = findViewById(R.id.tilApellido);
        tilPais = findViewById(R.id.tilPais);
        tilEdad = findViewById(R.id.tilEdad);
        tilTelefono = findViewById(R.id.tilTelefono);
        edtNombre = findViewById(R.id.edtNombre);
        edtNombre.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ponerTilsErrorsANull();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtApellido = findViewById(R.id.edtApellido);
        edtApellido.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ponerTilsErrorsANull();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtPais = findViewById(R.id.edtPais);
        edtPais.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ponerTilsErrorsANull();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtEdad = findViewById(R.id.edtEdad);
        edtEdad.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ponerTilsErrorsANull();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        edtTelefono = findViewById(R.id.edtTelefono);
        edtTelefono.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ponerTilsErrorsANull();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        presentador = new EditarAnadirPresentador(this);
        accion = getIntent().getIntExtra(ACCION, 0);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (accion == ContratoEditarAnadir.ANADIR) {
                    presentador.pedirAnadirPersona(edtNombre.getText().toString(), edtApellido.getText().toString(), edtPais.getText().toString(), edtEdad.getText().toString(), edtTelefono.getText().toString());
                }
                if (accion == ContratoEditarAnadir.EDITAR) {
                    presentador.pedirEditarPersona(persona.getId(), edtNombre.getText().toString(), edtApellido.getText().toString(), edtPais.getText().toString(), edtEdad.getText().toString(), edtTelefono.getText().toString());
                }
            }
        });
    }


    @Override
    public void finalizar() {
        finish();
    }

    @Override
    public void mostrarNombreError() {
        ponerTilsErrorsANull();
        tilNombre.setError("Debes introducir un nombre");
    }

    @Override
    public void mostrarApellidoError() {
        ponerTilsErrorsANull();
        tilApellido.setError("Debes introducir un apellido");
    }

    @Override
    public void mostrarPaisError() {
        ponerTilsErrorsANull();
        tilPais.setError("Debes introducir un país");
    }

    @Override
    public void mostrarEdadError() {
        ponerTilsErrorsANull();
        tilEdad.setError("Debes introducir una edad y debe ser de la longitud correcta");
    }

    @Override
    public void mostrarTelefonoError() {
        ponerTilsErrorsANull();
        tilEdad.setError("Debes introducir un telefono y debe ser de la longitud correcta");
    }

    private void ponerTilsErrorsANull() {
        tilNombre.setError(null);
        tilApellido.setError(null);
        tilPais.setError(null);
        tilEdad.setError(null);
        tilTelefono.setError(null);
    }
}
