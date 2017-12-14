package com.example.practicaexamendeintbiencompleta.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.practicaexamendeintbiencompleta.R;
import com.example.practicaexamendeintbiencompleta.data.db.modelo.Persona;

import java.util.ArrayList;

/**
 * Created by carlos on 13/12/2017.
 */

public class PersonasAdapter extends ArrayAdapter<Persona> {
    public PersonasAdapter(@NonNull Context context) {
        super(context, R.layout.persona_item, new ArrayList<Persona>());
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PersonaHolder personaHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.persona_item, null);

            personaHolder = new PersonaHolder();

            personaHolder.txvNombre = view.findViewById(R.id.txvNombre);
            personaHolder.txvEdad = view.findViewById(R.id.txvEdad);

            view.setTag(personaHolder);
        } else {
            personaHolder = (PersonaHolder) view.getTag();
        }
        Persona persona = getItem(position);

        personaHolder.txvNombre.setText(persona.getNombre() + " " + persona.getApellido());
        personaHolder.txvEdad.setText(Integer.toString(persona.getEdad()));

        return view;
    }

    private class PersonaHolder {
        TextView txvNombre;
        TextView txvEdad;
    }
}
