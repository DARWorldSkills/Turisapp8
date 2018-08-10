package com.aprendiz.ragp.turisapp8.cotrollers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprendiz.ragp.turisapp8.R;
import com.aprendiz.ragp.turisapp8.models.Lugar;

public class Detalle extends AppCompatActivity {
    TextView txtNombre, txtDescripcion;
    ImageView imgDetalle;
    Lugar lugar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        inizialite();
        inputData();
    }

    private void inizialite() {
        txtNombre = findViewById(R.id.txtNombreDescripcion);
        txtDescripcion = findViewById(R.id.txtDescripcion);
        imgDetalle = findViewById(R.id.imgDetalle);
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
