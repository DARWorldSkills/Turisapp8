package com.aprendiz.ragp.turisapp8.models;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aprendiz.ragp.turisapp8.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterT extends RecyclerView.Adapter<AdapterT.Holder> {
    List<Lugar> lugarList = new ArrayList<>();
    int item;
    Context context;
    private OnItemClickListener mlistener;
    public interface OnItemClickListener{
        void itemClick(int position);
    }

    public AdapterT(List<Lugar> lugarList, int item, Context context) {
        this.lugarList = lugarList;
        this.item = item;
        this.context = context;
    }

    public void setMlistener(OnItemClickListener mlistener) {
        this.mlistener = mlistener;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item,parent,false);
        Holder holder = new Holder(view,mlistener);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return lugarList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView imgItem = itemView.findViewById(R.id.imgItem);
        public Holder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener!=null){
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            listener.itemClick(position);
                        }
                    }
                }
            });

        }

        public void connectData(Lugar lugar){
            TextView txtNombre;
            TextView txtUbicacion;
            TextView txtDescripcion;
            if (item==R.layout.item_list){
                txtNombre = itemView.findViewById(R.id.txtNombreItem);
                txtUbicacion = itemView.findViewById(R.id.txtUbiacionItem);
                txtDescripcion = itemView.findViewById(R.id.txtDescripcionItem);

                txtNombre.setText(lugar.getNombre());
                txtUbicacion.setText(lugar.getUbicacion());
                txtDescripcion.setText(lugar.getDescripcionC());


            }

            if (item==R.layout.item_grid){
                txtNombre = itemView.findViewById(R.id.txtNombreItem);
                txtUbicacion = itemView.findViewById(R.id.txtUbiacionItem);

                txtNombre.setText(lugar.getNombre());
                txtUbicacion.setText(lugar.getUbicacion());


            }


            if (item==R.layout.item_land){
                txtNombre = itemView.findViewById(R.id.txtNombreItem);
                txtNombre.setText(lugar.getNombre());
            }


            BitmapFactory.Options op = new BitmapFactory.Options();
            op.inSampleSize=4;
            Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),lugar.getImagen(),op);
            imgItem.setImageBitmap(bitmap);







        }



    }
}
