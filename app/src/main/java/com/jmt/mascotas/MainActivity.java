package com.jmt.mascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {
    ArrayList<Mascota> mascota;
    private RecyclerView listaMascotas;
    private ImageView favoritos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListaDeMascota();
        listaMascotas = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        listaMascotas.setLayoutManager(llm);
        iniciarAdaptador();
        toolbar();
        addFab();
    }

    public void toolbar() {
    Toolbar mitoolbar = findViewById(R.id.mitoolbarini);
    mitoolbar.inflateMenu(R.menu.menu_opciones);
    mitoolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            switch (item.getItemId()){
                case R.id.action_contacto:
                    Intent intent1 = new Intent(getBaseContext(),Contacto.class);
                    startActivity(intent1);
                    break;
                case R.id.action_acerca:
                    Intent intent2 = new Intent(getBaseContext(),Acercade.class);
                    startActivity(intent2);
                    break;
            }
            return true;
        }
    });
    }

        public void ListaDeMascota() {
        mascota = new ArrayList<Mascota>();
        mascota.add(new Mascota("Lola","2",R.drawable.mascota1));
        mascota.add(new Mascota("Pepe","8",R.drawable.mascota2));
        mascota.add(new Mascota("Lucia","3",R.drawable.mascota3));
        mascota.add(new Mascota("Gaston","9",R.drawable.mascota4));
        mascota.add(new Mascota("Ternu","1",R.drawable.mascota5));
        mascota.add(new Mascota("Raspu","8",R.drawable.mascota6));
        mascota.add(new Mascota("Juan","10",R.drawable.mascota7));
        mascota.add(new Mascota("Tuvieja","1",R.drawable.mascota8));
        mascota.add(new Mascota("Carlos","1",R.drawable.mascota9));
        mascota.add(new Mascota("Fabian","10",R.drawable.mascota10));



    }
    public void iniciarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota, this);
        listaMascotas.setAdapter(adaptador);
    }
    public void irFavoritos(View v){
        Intent intent = new Intent(this, MascotasFavoritas.class);
        startActivity(intent);

    }
    public void addFab (){
        FloatingActionButton miFab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        miFab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
    }

}
