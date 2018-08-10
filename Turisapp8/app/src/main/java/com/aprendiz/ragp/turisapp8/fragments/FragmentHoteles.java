package com.aprendiz.ragp.turisapp8.fragments;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprendiz.ragp.turisapp8.R;
import com.aprendiz.ragp.turisapp8.cotrollers.Detalle;
import com.aprendiz.ragp.turisapp8.cotrollers.MenuT;
import com.aprendiz.ragp.turisapp8.maps.MapsHoteles;
import com.aprendiz.ragp.turisapp8.maps.Todos;
import com.aprendiz.ragp.turisapp8.models.AdapterT;
import com.aprendiz.ragp.turisapp8.models.GestorDB;
import com.aprendiz.ragp.turisapp8.models.Lugar;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHoteles extends Fragment {
    int position;
    int modo=0;
    RecyclerView recyclerView;
    List<Lugar> lugarList;
    int item;
    View view;
    public static Lugar lugar= new Lugar();
    Button btnCambio;


    public FragmentHoteles() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment_hoteles, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        position = getActivity().getWindowManager().getDefaultDisplay().getRotation();
        GestorDB gestorDB = new GestorDB(getContext());
        lugarList = gestorDB.listLugar("hotel");
        inputAdapter();






        return view;
    }

    private void inputAdapter() {
        if (position== Surface.ROTATION_0 || position==Surface.ROTATION_180){
            AdapterT adapterT;
            if (modo == 0) {
                item=R.layout.item_list;
                adapterT = new AdapterT(lugarList,item,getContext());
                recyclerView.setAdapter(adapterT);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

            }else {
                item=R.layout.item_grid;
                adapterT = new AdapterT(lugarList,item,getContext());
                recyclerView.setAdapter(adapterT);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2, GridLayout.VERTICAL,false));
            }

            adapterT.setMlistener(new AdapterT.OnItemClickListener() {
                @Override
                public void itemClick(int position) {
                    MenuT.lugar = lugarList.get(position);
                    Intent intent = new Intent(getContext(), Detalle.class);
                    startActivity(intent);
                }
            });

            FloatingActionButton btnMapaT = view.findViewById(R.id.btnMapaT);
            try {
                btnMapaT.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), MapsHoteles.class);
                        startActivity(intent);
                    }
                });
            }catch (Exception e){

            }


            btnCambio = view.findViewById(R.id.btnCambio);
            btnCambio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switchModo();
                }
            });


        }else {
            item=R.layout.item_land;
            AdapterT adapterT = new AdapterT(lugarList,item,getContext());
            recyclerView.setAdapter(adapterT);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setHasFixedSize(true);

            final TextView txtDescricpcion = view.findViewById(R.id.txtDescripcionLand);
            final ImageView imgDetalle = view.findViewById(R.id.imgLand);
            final BitmapFactory.Options op = new BitmapFactory.Options();
            op.inSampleSize=3;

            adapterT.setMlistener(new AdapterT.OnItemClickListener() {
                @Override
                public void itemClick(int position) {
                    lugar = lugarList.get(position);
                    MenuT.lugar = lugar;
                    txtDescricpcion.setText(lugar.getDescripcion());
                    Bitmap bitmap = BitmapFactory.decodeResource(getResources(),lugar.getImagen(),op);
                    imgDetalle.setImageBitmap(bitmap);
                }
            });

            FloatingActionButton floatingActionButton = view.findViewById(R.id.floatingActionButton);
            floatingActionButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MenuT.lugar = lugar;
                    Intent intent = new Intent(getContext(), Todos.class);
                    startActivity(intent);
                }
            });

        }

    }


    public void switchModo(){
        switch (modo){
            case 0:
                modo=1;
                inputAdapter();
                btnCambio.setBackground(getActivity().getDrawable(R.drawable.lista));
                break;

            case 1:
                modo=0;
                btnCambio.setBackground(getActivity().getDrawable(R.drawable.cuatro));
                inputAdapter();
                break;
        }

    }

}
