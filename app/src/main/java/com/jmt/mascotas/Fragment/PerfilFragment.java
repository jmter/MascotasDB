package com.jmt.mascotas.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmt.mascotas.Adapter.MascotaPerfilAdaptador;
import com.jmt.mascotas.POJO.Mascota;
import com.jmt.mascotas.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment implements IPerfilFragmentView {

    private ArrayList<Mascota> mascota;
    private RecyclerView listaMascotas;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        ListaDeMascota();
        generarGridLayoutManager(v);
        crearAdaptador(mascota);
        return v;
    }




    @Override
    public MascotaPerfilAdaptador crearAdaptador(ArrayList<Mascota> mascota) {
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascota, getActivity());
        listaMascotas.setAdapter(adaptador);
        return adaptador;
    }



    @Override
    public void generarGridLayoutManager(View v) {
        listaMascotas = (RecyclerView) v.findViewById(R.id.rcvMascotasPerfil);
        GridLayoutManager llm = new GridLayoutManager(getActivity(),3);
        listaMascotas.setLayoutManager(llm);
    }

    public void ListaDeMascota() {
        mascota = new ArrayList<Mascota>();
        mascota.add(new Mascota(0, "Lola", "2", R.drawable.mascota6));
        mascota.add(new Mascota(1, "Pepe", "8", R.drawable.mascota6));
        mascota.add(new Mascota(2, "Lucia", "3", R.drawable.mascota6));
        mascota.add(new Mascota(3, "Gaston", "9", R.drawable.mascota6));
        mascota.add(new Mascota(4, "Ternu", "1", R.drawable.mascota6));
        mascota.add(new Mascota(5, "Raspu", "8", R.drawable.mascota6));
        mascota.add(new Mascota(6, "Juan", "10", R.drawable.mascota6));
        mascota.add(new Mascota(7, "Tuvieja", "1", R.drawable.mascota6));
        mascota.add(new Mascota(8, "Carlos", "1", R.drawable.mascota6));
    }

}
