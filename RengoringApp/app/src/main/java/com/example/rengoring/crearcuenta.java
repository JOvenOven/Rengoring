package com.example.rengoring;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

public class crearcuenta extends AppCompatActivity {


    Button btn_iniciarsesion;
    Button btn_crearcuenta;
    Spinner spi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearcuenta);


        btn_iniciarsesion = findViewById(R.id.btn_iniciarsesion);btn_crearcuenta = findViewById(R.id.btn_crearcuenta);
        btn_crearcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(crearcuenta.this, login.class));
                Toast.makeText(crearcuenta.this,"Registrado con éxito",Toast.LENGTH_SHORT).show();
                finish();
            }
        });




        spi = findViewById(R.id.spAlcaldias);
        // titulo = (TextView)findViewById(R.id.textView6);

        String[] alcaldia = {"Seleccione una alcaldía", "Álvaro Obregón", "Azcapotzalco", "Benito Juárez", "Coyoacán", "Cuajimalpa de Morelos",
                "Cuauhtémoc", "Gustavo A. Madero", "Iztacalco", "Iztapalapa", "Magdalena Contreras", "Miguel Hidalgo", "Milpa Alta", "Tláhuac",
                "Tlalpan", "Venustiano Carranza", "Xochimilco"};

        /*ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.spinner_item_rengoring, alcaldia);
        spi.setAdapter(adaptador);
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, R.layout.spinner_list_rengoring, alcaldia);
        spi.setAdapter(adaptador2);*/
        ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(this, R.layout.spinner_selected_rengoring, alcaldia);
        adaptador3.setDropDownViewResource(R.layout.spinner_list_rengoring);
        spi.setAdapter(adaptador3);
        //spi.setPopupBackgroundDrawable(null);
        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> spn, View v, int posicion, long id) {

            }

            public void onNothingSelected(AdapterView<?> spn) {

            }
        });
        btn_iniciarsesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(crearcuenta.this, login.class));
                finish();
            }
        });




    }


}
