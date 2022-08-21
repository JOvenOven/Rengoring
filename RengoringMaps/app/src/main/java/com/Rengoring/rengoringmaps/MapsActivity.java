package com.Rengoring.rengoringmaps;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;
    Button botonAgregarUbicacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

       // boton de agregar ubicacion, por ahora solo usaremos clicklistenr botonAgregarUbicacion = (Button)findViewById(R.id.bAgregarUbicacion);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);





    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        /*

        UBICACIONES DE PRUEBAS

        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney pitero"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));

        LatLng popotla = new LatLng(19.453388, -99.175691);
        mMap.addMarker(new MarkerOptions().position(popotla).title("Marker in BATIZ CRACK"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(popotla));
    */



         //METODO PUNTOS QUE CONTIENE UBICACIONES DE PRUEBAS TAMBIEN

        puntos(googleMap);




        /*
        //metodo para agregar botes de basura cuando el usuario presione un punto en el mapa por un periodo considerable de tiempo.
        agregarBotes(googleMap);


         */

    }

    //https://www.youtube.com/channel/UC_tBJwfiDqQCGsHYUG03XmA
    //https://www.youtube.com/watch?v=smPjbSQQu10
    //https://www.youtube.com/watch?v=lnxY8pBrZl8&list=PL_963TKBW5HD1jL2aAOkafQdSLJ5wOxM8&index=2

    //https://www.youtube.com/watch?v=tPV8xA7m-iw
    public void puntos(GoogleMap googleMap){

        mMap = googleMap;
        final LatLng Batiz = new LatLng(19.453388, -99.175691);
        mMap.addMarker(new MarkerOptions().position(Batiz).title("Cecyt9 ").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Batiz));

        final LatLng parque_cañitas = new LatLng(19.453485, -99.177640);
        mMap.addMarker(new MarkerOptions().position(parque_cañitas).title("Parque cañitas ").icon(BitmapDescriptorFactory.fromResource(R.drawable.botemarcador)).anchor(0.0f,1.0f));

        final LatLng cAcopio = new LatLng(19.4481674,-99.1744146);
        mMap.addMarker(new MarkerOptions().position(cAcopio).title("Centro de acopio").icon(BitmapDescriptorFactory.fromResource(R.drawable.botemarcador)).anchor(0.0f,1.0f));
		
		final LatLng cAcopio2 = new LatLng(19.4500049,-99.1699398);
        mMap.addMarker(new MarkerOptions().position(cAcopio2).title("Centro de acopio").icon(BitmapDescriptorFactory.fromResource(R.drawable.botemarcador)).anchor(0.0f,1.0f));
		
    /*
        final LatLng monumentoRevolucion = new LatLng(19.4362086,-99.1568185);
        mMap.addMarker(new MarkerOptions().position(parque_cañitas).title("Marker in RevoBB").icon(BitmapDescriptorFactory.fromResource(R.drawable.botesitobb)));
        */

        final LatLng Revo = new LatLng(19.5127426,-99.1266753);
        mMap.addMarker(new MarkerOptions().position(Revo).title("Marker in OLIMPO").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));


    }

    public void agregarBotes(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(R.drawable.botespincheta)).anchor(0.0f,1.0f));

            }
        });
        LatLng centroCDMX = new LatLng(19.4319716,-99.1356141);
        mMap.addMarker(new MarkerOptions().position(centroCDMX).title("centro CDMX"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(centroCDMX));

    }


}
