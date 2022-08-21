package com.example.rengoring;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.loopj.android.http.AsyncHttpClient;

public class agregarresiduoFragment extends Fragment {

    Button btn_iniciarsesion;
    Button btn_agregar;
    Spinner spi;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_agregarresiduo, container, false);



    }

    @Override
    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);


        btn_agregar = getView().findViewById(R.id.btn_agregar);
        btn_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity().getApplicationContext(),"Agregado con éxito",Toast.LENGTH_SHORT).show();
            }
        });


        spi = getView().findViewById(R.id.spResiduo);
        // titulo = (TextView)findViewById(R.id.textView6);

        String[] residuo = {"Seleccione un residuo", "Envases de vidrio", "Plástico fino (PET)", "Plástico grueso", "Cartón", "Latas compactadas", "Papel",
                "Poliestireno", "Pedacería de vidrio", "Pilas", "Metales diversos", "Orgánicos", "Tetrapak", "Telas", "Sanitarios", "Varios"};

        /*ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.spinner_item_rengoring, alcaldia);
        spi.setAdapter(adaptador);
        ArrayAdapter<String> adaptador2 = new ArrayAdapter<String>(this, R.layout.spinner_list_rengoring, alcaldia);
        spi.setAdapter(adaptador2);*/
        ArrayAdapter<String> adaptador3 = new ArrayAdapter<String>(getActivity().getApplicationContext(), R.layout.spinner_selected_fragments, residuo);
        adaptador3.setDropDownViewResource(R.layout.spinner_list_fragments);
        spi.setAdapter(adaptador3);
        //spi.setPopupBackgroundDrawable(null);
        spi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> spn, View v, int posicion, long id) {

            }

            public void onNothingSelected(AdapterView<?> spn) {

            }
        });
    }




}
