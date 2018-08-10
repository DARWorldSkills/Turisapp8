package com.aprendiz.ragp.turisapp8.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.aprendiz.ragp.turisapp8.R;
import com.aprendiz.ragp.turisapp8.models.GestorDB;
import com.aprendiz.ragp.turisapp8.models.Lugar;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsSitios extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_sitios);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        GestorDB gestorDB = new GestorDB(this);
        List<Lugar> lugarList = gestorDB.listLugar("sitios");
        for (int i=0; i<lugarList.size();i++){
            LatLng latLng = new LatLng(lugarList.get(i).getLatitud(), lugarList.get(i).getLogitud());
            mMap.addMarker(new MarkerOptions().position(latLng).title(lugarList.get(i).getNombre()));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        }


    }
}
