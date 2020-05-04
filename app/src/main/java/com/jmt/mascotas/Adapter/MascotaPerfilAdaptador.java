package com.jmt.mascotas.Adapter;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.jmt.mascotas.POJO.Mascota;
import com.jmt.mascotas.R;

import java.util.ArrayList;

public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascota;
    Activity activity;

    public MascotaPerfilAdaptador(ArrayList<Mascota> mascota, Activity activity){
        this.mascota = mascota;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_perfil,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder mascotaViewHolder, int position) {
        Mascota masc = mascota.get(position);
        mascotaViewHolder.imagen.setImageResource(masc.getFoto());
        mascotaViewHolder.raiting.setText(masc.getRaiting());

    }

    @Override
    public int getItemCount() {
        return mascota.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imagen;
        private TextView nombre;
        private TextView raiting;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen  = (ImageView) itemView.findViewById(R.id.imagenP);
            raiting = (TextView) itemView.findViewById(R.id.raitingP);
        }
    }
}
