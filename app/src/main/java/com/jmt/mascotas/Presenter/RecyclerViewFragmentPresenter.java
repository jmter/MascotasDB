package com.jmt.mascotas.Presenter;

import android.content.Context;
import android.util.Log;
import android.view.View;

import com.jmt.mascotas.Adapter.MascotaAdaptador;
import com.jmt.mascotas.Fragment.IRecyclerViewFragmentView;
import com.jmt.mascotas.POJO.Mascota;
import com.jmt.mascotas.db.ConstructorMascota;

import java.util.ArrayList;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascota constructorMascota;
    private ArrayList<Mascota> mascota;


    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotas();

    }


    @Override
    public void obtenerMascotas() {
        Log.i("PRESENTER","Obtener MAscota");
        constructorMascota = new ConstructorMascota(context);
        mascota = constructorMascota.obtenerDatos();

    }

    @Override
    public void mostrarMascostas(View v) {
        iRecyclerViewFragmentView.generarLinearLayoutManager(v);
        iRecyclerViewFragmentView.iniciarAdaptador(iRecyclerViewFragmentView.crearAdaptador(mascota));

    }
}
