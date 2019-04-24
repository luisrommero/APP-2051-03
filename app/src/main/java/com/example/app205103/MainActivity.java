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

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Spinner SpnrOpciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SpnrOpciones = (Spinner)findViewById(R.id.SpnrOpciones);

        //Alternativa 1: Cargar el Adapter a partir de una Array en Java
        //final String[] ArrayDeOpciones = new String[]{ "Opción 1", "Opción 2", "Opción 3", "Opción 4", "Opción 5" };
        //ArrayAdapter<String> Adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ArrayDeOpciones);

        //Alternativa 2: Cargar el Adapter a partir de una string-array en los recursos de la app.
        //ArrayAdapter<CharSequence> Adaptador = ArrayAdapter.createFromResource(this, R.array.opciones_array, android.R.layout.simple_spinner_item);
        //Adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //Alternativa 3: Cargar el adapter con opciones obtenidas de un recurso exterior (web service)
        //Crear un httpRequest a una API
        //Obtener respuesta e interpretarla (JSON, XML)
        //Cargar los valores del JSON o XML en un objeto de tipo Array;
        String[] ArrayDeOpciones = new String[3];
        try
        {
            String JSON = "{\"Autos\":[ {\"Marca\":\"Mazda\", \"Modelo\":\"3\"}, { \"Marca\":\"BMW\", \"Modelo\":\"M5\"},  { \"Marca\":\"VW\", \"Modelo\":\"Jetta\"}]}";
            JSONObject json = new JSONObject(JSON);
            JSONArray jArray = json.getJSONArray("Autos");
            System.out.println(">>>LENGTH: " + jArray.length());
            for (int i = 0; i < jArray.length(); i++)
            {
                JSONObject ObjetoJSON = jArray.getJSONObject(i);
                ArrayDeOpciones[i] = ObjetoJSON.getString("Modelo");
                System.out.println(">>>>>ArrayDeOpciones[i]" + ArrayDeOpciones[i]);
            }
        }
        catch (Exception e)
        {
            System.out.println("ERROR: " + e.getMessage());
        }

        ArrayAdapter<String> Adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ArrayDeOpciones);

        SpnrOpciones.setAdapter(Adaptador);


    }
}
