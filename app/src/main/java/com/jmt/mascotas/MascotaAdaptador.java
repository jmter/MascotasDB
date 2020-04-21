package com.jmt.mascotas;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascota;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascota, Activity activity){
        this.mascota = mascota;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota masc = mascota.get(position);
        mascotaViewHolder.imagen.setImageResource(masc.getFoto());
        mascotaViewHolder.nombre.setText(masc.getNombre());
        mascotaViewHolder.raiting.setText(masc.getRaiting());
        mascotaViewHolder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Chupala", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,MascotasFavoritas.class);
                activity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascota.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private ImageView like;
        private TextView nombre;
        private TextView raiting;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen  = (ImageView) itemView.findViewById(R.id.imagen);
            like    = (ImageView) itemView.findViewById(R.id.like);
            nombre  = (TextView) itemView.findViewById(R.id.nombreMascota);
            raiting = (TextView) itemView.findViewById(R.id.raiting);
        }
    }
}
