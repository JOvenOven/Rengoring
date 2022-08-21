package com.example.rengoring;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class agregarRes extends AppCompatActivity {
    private AsyncHttpClient cliente;
    private Spinner spResiduo;
    EditText edtcantidad;
    double cantidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        edtcantidad=(EditText)findViewById(R.id.edtCantidad);
        cliente=new AsyncHttpClient();
        spResiduo=(Spinner)findViewById(R.id.spResiduo);

        llenarSpinner();


    }

    private void llenarSpinner(){

        String url="http://192.168.1.66/Rengoring/obtenerResiduos.php";
        cliente.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {

                if(statusCode == 200){
                    cargarSpinner(new String(responseBody));
                }

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

            }
        });
    }

    private void cargarSpinner(String respuesta) {

        ArrayList<TipoResiduo> listatp = new ArrayList<TipoResiduo>();

        try {
            JSONArray jsonArreglo = new JSONArray(respuesta);
            for (int i = 0; i < jsonArreglo.length(); i++) {

                TipoResiduo tp = new TipoResiduo();
                //a.setId_alc(jsonArreglo.getJSONObject(i).getInt("id_alc"));
                tp.setDes_res(jsonArreglo.getJSONObject(i).getString("des_res"));
                listatp.add(tp);
                //a.setDes_alc(jsonArreglo.getJSONObject(i).getString("des_alc"));
                //lista.add(a);


            }

            ArrayAdapter<TipoResiduo> al = new ArrayAdapter<TipoResiduo>(this, android.R.layout.simple_dropdown_item_1line, listatp);
            spResiduo.setAdapter(al);

            //String text = spAlcaldias.getSelectedItem().toString();
            //txtres.setText(text);

            spResiduo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String text = spResiduo.getSelectedItem().toString();


                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void agregarRes(View view){

        String text =spResiduo.getSelectedItem().toString();
        String tcantidad= edtcantidad.getText().toString();
        cantidad = Double.valueOf(tcantidad);

        String method="agregarRes";
        BackgroundTask backgroundTask=new BackgroundTask(this);
        backgroundTask.execute(method,tcantidad,text);
        finish();




    }



}
