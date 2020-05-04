package com.jmt.mascotas.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jmt.mascotas.Adapter.MascotaAdaptador;
import com.jmt.mascotas.Adapter.MascotaPerfilAdaptador;
import com.jmt.mascotas.POJO.Mascota;
import com.jmt.mascotas.Presenter.IRecyclerViewFragmentPresenter;
import com.jmt.mascotas.Presenter.RecyclerViewFragmentPresenter;
import com.jmt.mascotas.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerFragment extends Fragment implements IRecyclerViewFragmentView{
    private RecyclerView listaMascotas;
    private ArrayList<Mascota> mascota;
    private IRecyclerViewFragmentPresenter presenter;

    public RecyclerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler, container, false);

        presenter = new RecyclerViewFragmentPresenter(this,getContext());
        presenter.mostrarMascostas(v);

    return v;
    }


    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascota) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascota, getActivity());
        return adaptador;
    }

    @Override
    public void generarLinearLayoutManager(View v) {
        listaMascotas = (RecyclerView) v.findViewById(R.id.recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public void iniciarAdaptador(MascotaAdaptador mascotaAdaptador) {

        listaMascotas.setAdapter(mascotaAdaptador);
    }


}
