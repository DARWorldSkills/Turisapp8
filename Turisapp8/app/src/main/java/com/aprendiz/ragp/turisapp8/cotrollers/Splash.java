package com.aprendiz.ragp.turisapp8.cotrollers;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aprendiz.ragp.turisapp8.R;
import com.aprendiz.ragp.turisapp8.maps.Todos;
import com.aprendiz.ragp.turisapp8.models.GestorDB;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        inputData();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,MenuT.class);
                startActivity(intent);
                finish();
            }
        };
        Timer timer = new Timer();
        timer.schedule(timerTask,1200);
    }

    private void inputData() {
        GestorDB gestorDB = new GestorDB(this);
        SQLiteDatabase db = gestorDB.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM LUGARES;",null);
        if (!cursor.moveToFirst()){
            gestorDB.inputHoteles(this);
            gestorDB.inputSitios(this);
            gestorDB.inputRestaurantes(this);
        }
        cursor.close();
        db.close();

    }
}
