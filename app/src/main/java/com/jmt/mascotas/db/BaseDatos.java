package com.jmt.mascotas.db;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.jmt.mascotas.POJO.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA + "("+
                ConstantesBaseDatos.TABLE_MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_MASCOTA_NOMBRE + " TEXT,"+
                ConstantesBaseDatos.TABLE_MASCOTA_FOTO + " INTEGER"+
                ")";

        String queryCrearTablaMascotaLikes = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES + "("+
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + " INTEGER,"+
                ConstantesBaseDatos.TABLE_MASCOTA_LIKES_RAITING + " INTEGER,"+
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTA + "(" + ConstantesBaseDatos.TABLE_MASCOTA_ID + ")"+
                ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaMascotaLikes);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor regristros = db.rawQuery(query, null);


        while (regristros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(regristros.getInt(0));
            mascotaActual.setNombre(regristros.getString(1));
            mascotaActual.setFoto(regristros.getInt(2));


           /* String queryL = "SELECT COUNT("+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_RAITING+")" +
                    " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + regristros.getInt(0);
            Cursor registrosL = db.rawQuery(queryL, null);
            mascotaActual.setRaiting(Integer.toString(registrosL.getInt(3)));
           */

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_RAITING+") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                    " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()){
                mascotaActual.setRaiting(Integer.toString(registrosLikes.getInt(0)));
            }else {
                mascotaActual.setRaiting("0");
            }


            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA,null,contentValues);
        db.close();
    }

    public void insertarLike(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTA_LIKES,null,contentValues);
        db.close();
    }

    public int obtenerLikesContactos(Mascota mascota){
        int likes = 0;

        String query = "SELECT COUNT("+ConstantesBaseDatos.TABLE_MASCOTA_LIKES_RAITING+")" +
                " FROM " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES +
                " WHERE " + ConstantesBaseDatos.TABLE_MASCOTA_LIKES_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        if (registros.moveToNext()){
            likes = registros.getInt(0);
        }

        db.close();

        return likes;
    }
}
