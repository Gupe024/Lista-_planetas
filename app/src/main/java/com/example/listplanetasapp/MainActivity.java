package com.example.listplanetasapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    ImageView imagen;
    TextView descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        imagen = findViewById(R.id.imagenPlaneta);
        descripcion = findViewById(R.id.descripcionPlanetas);

        String[] nombresdeplanetas = getResources().getStringArray(R.array.planetas_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, nombresdeplanetas);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int imagenid = getResources().getIdentifier(nombresdeplanetas[position].toLowerCase(), "drawable", getPackageName());
                imagen.setImageResource(imagenid);

                String[] planetaDescripcion = getResources().getStringArray(R.array.desripcion_planetas);
                descripcion.setText(planetaDescripcion[position]);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                descripcion.setText("No has seleccionado ningún planeta");
            }
        });

    }
}