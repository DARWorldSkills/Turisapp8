package com.aprendiz.ragp.turisapp8.cotrollers;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprendiz.ragp.turisapp8.R;
import com.aprendiz.ragp.turisapp8.maps.Todos;
import com.aprendiz.ragp.turisapp8.models.Lugar;

public class Detalle extends AppCompatActivity {
    TextView txtNombre, txtDescripcion;
    ImageView imgDetalle;
    Lugar lugar;
    FloatingActionButton btnmapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        inizialite();
        inputData();

        btnmapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detalle.this, Todos.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        inputData();
    }

    @Override
    protected void onStart() {
        super.onStart();
        inputData();
    }

    private void inizialite() {
        txtNombre = findViewById(R.id.txtNombreDescripcion);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        imgDetalle = findViewById(R.id.imgDetalle);
        btnmapa = findViewById(R.id.btnMapaDetalle);
    }

    private void inputData() {
        lugar = MenuT.lugar;
        txtNombre.setText(lugar.getNombre());
        txtDescripcion.setText(lugar.getDescripcion());
        BitmapFactory.Options op = new BitmapFactory.Options();
        op.inSampleSize=2;
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),lugar.getImagen(),op);
        imgDetalle.setImageBitmap(bitmap);
    }
}
