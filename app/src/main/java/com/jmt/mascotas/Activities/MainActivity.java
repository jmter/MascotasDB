package com.jmt.mascotas.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.jmt.mascotas.Adapter.PageAdapter;
import com.jmt.mascotas.Fragment.PerfilFragment;
import com.jmt.mascotas.Fragment.RecyclerFragment;
import com.jmt.mascotas.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    private ImageView favoritos;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar mitoolbar = findViewById(R.id.mitoolbarini);
        tabLayout = findViewById(R.id.tabs);
        viewPager = findViewById(R.id.viewPager);

        toolbar();
        setUpViewPager();
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
                    Intent intent1 = new Intent(getBaseContext(), Contacto.class);
                    startActivity(intent1);
                    break;
                case R.id.action_acerca:
                    Intent intent2 = new Intent(getBaseContext(), Acercade.class);
                    startActivity(intent2);
                    break;
            }
            return true;
        }
    });
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

    private ArrayList<Fragment> agregarFragment(){
        ArrayList<Fragment> fragments =  new ArrayList<>();

        fragments.add(new RecyclerFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager (){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragment()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout .getTabAt(0).setIcon(R.drawable.ic_tap_casa);
        tabLayout .getTabAt(1).setIcon(R.drawable.ic_tap_perro);

    }

}
