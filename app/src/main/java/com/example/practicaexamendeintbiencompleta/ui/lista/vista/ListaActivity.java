package com.example.practicaexamendeintbiencompleta.ui.lista.vista;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.practicaexamendeintbiencompleta.R;
import com.example.practicaexamendeintbiencompleta.adapter.PersonasAdapter;
import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;
import com.example.practicaexamendeintbiencompleta.ui.lista.contrato.ContratoEditarAnadir;
import com.example.practicaexamendeintbiencompleta.ui.lista.contrato.ContratoLista;
import com.example.practicaexamendeintbiencompleta.ui.lista.presentador.ListaPresentador;
import com.example.practicaexamendeintbiencompleta.ui.prefs.PreferenciasActivity;

import java.util.List;

public class ListaActivity extends AppCompatActivity implements ContratoLista.Vista{

    private ContratoLista.Presentador presentador;
    private ListView lstvPersonas;
    private Toolbar toolbar;
    private FloatingActionButton fab;
    private PersonasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        inicializar();

        setSupportActionBar(toolbar);

        lstvPersonas.setAdapter(adapter);

        presentador.pedirDatos();

        presentador.pedirConsultarPreferenciaMostrarLista(this);

        registerForContextMenu(lstvPersonas);
    }

    private void inicializar() {
        presentador = new ListaPresentador(this);
        toolbar = findViewById(R.id.toolbar);
        lstvPersonas = findViewById(R.id.lstvPersonas);
        lstvPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent i = new Intent(ListaActivity.this, EditarAnadirActivity.class);
                i.putExtra(EditarAnadirActivity.ID, adapter.getItem(position).getId());
                i.putExtra(EditarAnadirActivity.PERSONA, adapter.getItem(position));
                i.putExtra(EditarAnadirActivity.ACCION, ContratoEditarAnadir.EDITAR);
                startActivity(i);
            }
        });
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ListaActivity.this, EditarAnadirActivity.class);
                i.putExtra(EditarAnadirActivity.ACCION, ContratoEditarAnadir.ANADIR);
                startActivity(i);
            }
        });
        adapter = new PersonasAdapter(this);
    }

    @Override
    public void cargarDatos(List<Persona> personas) {
        adapter.clear();
        adapter.addAll(personas);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.lista_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mitmOrdenarNombre:
                presentador.ordenar(adapter, ListaPresentador.ORDENAR_POR_NOMBRE);
                break;
            case R.id.mitmOrdenarEdad:
                presentador.ordenar(adapter, ListaPresentador.ORDENAR_POR_EDAD);
                break;
            case R.id.mitmPreferencias:
                Intent i = new Intent(ListaActivity.this, PreferenciasActivity.class);
                startActivity(i);
                break;
        }
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        presentador.ordenarPorOrdenActual(adapter);
        presentador.pedirConsultarPreferenciaMostrarLista(this);
        presentador.pedirDatos();
    }

    @Override
    public void mostrarLista(boolean mostrarLista) {
        if (mostrarLista)
            lstvPersonas.setVisibility(View.VISIBLE);
        else
            lstvPersonas.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Acciones sobre la persona");
        getMenuInflater().inflate(R.menu.menu_contextual_lista, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        if (item.getItemId() == R.id.mitmBorrar) {
            presentador.pedirBorrarPersona(adapter.getItem(info.position));
        }
        return super.onContextItemSelected(item);
    }
}
