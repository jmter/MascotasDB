package com.jmt.mascotas.Activities;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import com.jmt.mascotas.Adapter.MascotaAdaptador;
import com.jmt.mascotas.POJO.Mascota;
import com.jmt.mascotas.R;

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

        Toolbar toolbar = findViewById(R.id.miToolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        ListaDeMascota();

        listaMascotas = (RecyclerView) findViewById(R.id.recycler2);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMascotas.setLayoutManager(llm);

        iniciarAdaptador();

    }


    public void ListaDeMascota() {
        mascota = new ArrayList<Mascota>();

        mascota.add(new Mascota(0, "Pepe","8",R.drawable.mascota2));
        mascota.add(new Mascota(1, "Gaston","9",R.drawable.mascota4));
        mascota.add(new Mascota(2, "Raspu","8",R.drawable.mascota6));
        mascota.add(new Mascota(3, "Juan","10",R.drawable.mascota7));
        mascota.add(new Mascota(4, "Fabian","10",R.drawable.mascota10));



    }
    public void iniciarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota, this);
        listaMascotas.setAdapter(adaptador);
    }
}
