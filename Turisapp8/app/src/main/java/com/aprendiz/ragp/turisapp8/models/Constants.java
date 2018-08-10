package com.aprendiz.ragp.turisapp8.models;

import android.graphics.drawable.Drawable;

import com.aprendiz.ragp.turisapp8.R;

public class Constants {
    public static final String DATABASE_NAME="lugares.db";
    public static final int DATABASE_VERSION=1;
    public static final String script="CREATE TABLE LUGARES (IMAGEN INTEGER, NOMBRE TEXT, DESCRIPCIONC TEXT, UBICACION TEXT, DESCRIPCION TEXT, LATITUD INTEGER, LONGITUD INTEGER, LUGAR TEXT);";

    public static int modo_inicio=0;
    public static int [] imagenesSitios={
            R.drawable.portal_del_quindio,
            R.drawable.unicentro,
            R.drawable.calima,
            R.drawable.parque_cafe,
            R.drawable.panaca,
            R.drawable.salento,
            R.drawable.penas_blancas,
            R.drawable.granja_mama_lulu,
            R.drawable.los_arrieros

    };

    public static int [] imagenesHoteles={
            R.drawable.bolivar_plaza,
            R.drawable.mocawa,
            R.drawable.armenia,
            R.drawable.zuldemayda,
            R.drawable.decameron,
            R.drawable.heliconias,
            R.drawable.arrayanes,
            R.drawable.la_esperanza
    };

    public static int [] imagenesRestaurante={
            R.drawable.el_roble,
            R.drawable.la_fogata,
            R.drawable.dar_papaya,
            R.drawable.casa_verde,
            R.drawable.camelia_real,
            R.drawable.bosque_cocora,
            R.drawable.el_solar
    };


}
