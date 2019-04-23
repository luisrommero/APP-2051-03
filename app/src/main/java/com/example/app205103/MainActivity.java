package com.example.app205103;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    Spinner SpnrOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpnrOpciones = (Spinner)findViewById(R.id.SpnrOpciones);

        final String[] ArrayDeOpciones = new String[]{ "Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5" };
        ArrayAdapter<String> Adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);

        Adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        SpnrOpciones.setAdapter(Adaptador);


    }
}
