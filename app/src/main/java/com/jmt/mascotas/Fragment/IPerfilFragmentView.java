package com.jmt.mascotas.Fragment;

import android.view.View;

import com.jmt.mascotas.Adapter.MascotaPerfilAdaptador;
import com.jmt.mascotas.POJO.Mascota;

import java.util.ArrayList;

public interface IPerfilFragmentView {

    public MascotaPerfilAdaptador crearAdaptador(ArrayList<Mascota> mascota);
    public void generarGridLayoutManager(View v);
}
