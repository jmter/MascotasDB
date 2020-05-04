package com.jmt.mascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.jmt.mascotas.POJO.Mascota;
import com.jmt.mascotas.R;

import java.util.ArrayList;

import static java.util.Date.parse;

public class ConstructorMascota {

    private Context context;

    public ConstructorMascota(Context context) {
        this.context = context;

    }

    public ArrayList<Mascota> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerMascotas();
    }

    public void insertarMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Lola");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.mascota1);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Pepe");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.mascota2);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Felipe");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.mascota3);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Lalo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.mascota4);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Marley");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.mascota5);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE,"Sergio");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_FOTO,R.drawable.mascota6);
        db.insertarMascota(contentValues);
    }

    public void darLikeMascota(Mascota mascota){
        int raiting = Integer.parseInt(mascota.getRaiting()) ;
        raiting ++;
        Log.i("Constructor", Integer.toString(raiting));
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTA_LIKES_RAITING, raiting);
        db.insertarLike(contentValues);
    }

    public int obtenerLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContactos(mascota);
    }

}
