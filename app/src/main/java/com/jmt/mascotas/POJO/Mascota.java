package com.jmt.mascotas.POJO;

public class Mascota {

    private int id;
    private String nombre;
    private String raiting;
    private int foto;

    public Mascota(){
    }
    public Mascota(int id, String nombre, String raiting, int foto){
        this.id = id;
        this.nombre = nombre;
        this.raiting = raiting;
        this.foto = foto;
    }
    public String getNombre() {
        return nombre;
    }

    public String getRaiting() {
        return raiting;
    }

    public int getFoto() {
        return foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRaiting(String raiting) {
        this.raiting = raiting;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
