package com.jmt.mascotas.Fragment;

import android.view.View;

import com.jmt.mascotas.Adapter.MascotaAdaptador;
import com.jmt.mascotas.Adapter.MascotaPerfilAdaptador;
import com.jmt.mascotas.POJO.Mascota;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascota);
    public void generarLinearLayoutManager(View v);
    public void iniciarAdaptador(MascotaAdaptador mascotaAdaptador);
}
