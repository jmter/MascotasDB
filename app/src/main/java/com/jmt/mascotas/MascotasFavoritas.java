package com.jmt.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {
    private ImageView back;
    ArrayList<Mascota> mascota;
    private RecyclerView listaMascotas;
    private ImageView fav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);
        atras();
        ListaDeMascota();
        listaMascotas = (RecyclerView) findViewById(R.id.recycler2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMascotas.setLayoutManager(llm);
        iniciarAdaptador();

    }
    public void atras(){
        back = (ImageView) findViewById(R.id.back);
        fav = (ImageView) findViewById(R.id.favoritos);
        fav.setImageResource(0);
        back.setImageResource(R.drawable.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),MainActivity.class);
                startActivity(intent);

            }
        });
    }
    public void ListaDeMascota() {
        mascota = new ArrayList<Mascota>();

        mascota.add(new Mascota("Pepe","8",R.drawable.mascota2));
        mascota.add(new Mascota("Gaston","9",R.drawable.mascota4));
        mascota.add(new Mascota("Raspu","8",R.drawable.mascota6));
        mascota.add(new Mascota("Juan","10",R.drawable.mascota7));
        mascota.add(new Mascota("Fabian","10",R.drawable.mascota10));



    }
    public void iniciarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota, this);
        listaMascotas.setAdapter(adaptador);
    }
}
