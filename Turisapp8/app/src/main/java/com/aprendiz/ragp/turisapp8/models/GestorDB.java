package com.aprendiz.ragp.turisapp8.models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.aprendiz.ragp.turisapp8.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GestorDB extends SQLiteOpenHelper{
    public GestorDB(Context context) {
        super(context, Constants.DATABASE_NAME,null,Constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.script);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inputSitios(Context context){
        SQLiteDatabase db = getWritableDatabase();
        InputStream is = context.getResources().openRawResource(R.raw.sitios);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String linea;
        int i=0;
        try {
            while ((linea=reader.readLine())!=null){
                String [] strings = linea.split(";");
                ContentValues values = new ContentValues();
                values.put("IMAGEN",Constants.imagenesSitios[i]);
                values.put("NOMBRE",strings[0]);
                values.put("DESCRIPCIONC",strings[1]);
                values.put("UBICACION",strings[2]);
                values.put("DESCRIPCION",strings[3]);
                values.put("LATITUD",Double.parseDouble(strings[4]));
                values.put("LONGITUD",Double.parseDouble(strings[5]));
                values.put("LUGAR","sitio");
                db.insert("LUGARES",null,values);
                i++;
            }
        }catch (IOException e){
            Log.e("Errore en el reader",e.getMessage());
        }

        db.close();
    }

    public void inputRestaurantes(Context context){
        SQLiteDatabase db = getWritableDatabase();
        InputStream is = context.getResources().openRawResource(R.raw.restaurantes);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String linea;
        int i=0;
        try {
            while ((linea=reader.readLine())!=null){
                String [] strings = linea.split(";");
                ContentValues values = new ContentValues();
                values.put("IMAGEN",Constants.imagenesRestaurante[i]);
                values.put("NOMBRE",strings[0]);
                values.put("DESCRIPCIONC",strings[1]);
                values.put("UBICACION",strings[2]);
                values.put("DESCRIPCION",strings[3]);
                values.put("LATITUD",Double.parseDouble(strings[4]));
                values.put("LONGITUD",Double.parseDouble(strings[5]));
                values.put("LUGAR","restaurante");
                db.insert("LUGARES",null,values);
                i++;
            }
        }catch (IOException e){
            Log.e("Errore en el reader",e.getMessage());
        }

        db.close();
    }

    public void inputHoteles(Context context){
        SQLiteDatabase db = getWritableDatabase();
        InputStream is = context.getResources().openRawResource(R.raw.hoteles);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        String linea;
        int i=0;
        try {
            while ((linea=reader.readLine())!=null){
                String [] strings = linea.split(";");
                ContentValues values = new ContentValues();
                values.put("IMAGEN",Constants.imagenesHoteles[i]);
                values.put("NOMBRE",strings[0]);
                values.put("DESCRIPCIONC",strings[1]);
                values.put("UBICACION",strings[2]);
                values.put("DESCRIPCION",strings[3]);
                values.put("LATITUD",Double.parseDouble(strings[4]));
                values.put("LONGITUD",Double.parseDouble(strings[5]));
                values.put("LUGAR","hotel");
                db.insert("LUGARES",null,values);
                i++;
            }
        }catch (IOException e){
            Log.e("Errore en el reader",e.getMessage());
        }

        db.close();
    }

    public List<Lugar> listLugar(String lugar){
        List<Lugar> results = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LUGARES WHERE LUGAR ='"+lugar+"';",null);
        if (cursor.moveToFirst()){
            do {
                Lugar lugar1 = new Lugar();
                lugar1.setImagen(cursor.getInt(0));
                lugar1.setNombre(cursor.getString(1));
                lugar1.setDescripcionC(cursor.getString(2));
                lugar1.setUbicacion(cursor.getString(3));
                lugar1.setDescripcion(cursor.getString(4));
                lugar1.setLatitud(cursor.getDouble(5));
                lugar1.setLogitud(cursor.getDouble(6));
                lugar1.setLugar(cursor.getString(7));
                results.add(lugar1);

            }while (cursor.moveToNext());

        }


        return results;
    }




}
