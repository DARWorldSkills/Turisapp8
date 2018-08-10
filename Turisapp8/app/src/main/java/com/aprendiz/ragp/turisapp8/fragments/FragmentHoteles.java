package com.aprendiz.ragp.turisapp8.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import com.aprendiz.ragp.turisapp8.R;
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


    public FragmentHoteles() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_hoteles, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        position = getActivity().getWindowManager().getDefaultDisplay().getRotation();
        GestorDB gestorDB = new GestorDB(getContext());
        lugarList = gestorDB.listLugar("hotel");
        inputAdapter();






        return view;
    }

    private void inputAdapter() {
        if (position== Surface.ROTATION_0 || position==Surface.ROTATION_180){
            if (modo == 0) {
                item=R.layout.item_list;
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));

            }else {
                item=R.layout.item_grid;
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2, GridLayout.VERTICAL,false));
            }
            AdapterT adapterT = new AdapterT(lugarList,item,getContext());
            recyclerView.setAdapter(adapterT);
            recyclerView.setHasFixedSize(true);
            adapterT.setMlistener(new AdapterT.OnItemClickListener() {
                @Override
                public void itemClick(int position) {
                    
                }
            });


        }else {
            item=R.layout.item_land;
            AdapterT adapterT = new AdapterT(lugarList,item,getContext());
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
            recyclerView.setAdapter(adapterT);
            recyclerView.setHasFixedSize(true);

            adapterT.setMlistener(new AdapterT.OnItemClickListener() {
                @Override
                public void itemClick(int position) {

                }
            });

        }

    }


    public void switchModo(){
        switch (modo){
            case 0:
                modo=1;
                inputAdapter();
                break;

            case 1:
                modo=0;
                inputAdapter();
                break;
        }

    }

}
