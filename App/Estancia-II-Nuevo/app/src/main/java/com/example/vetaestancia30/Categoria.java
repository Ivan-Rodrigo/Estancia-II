package com.example.vetaestancia30;

public class Categoria {
    String id,categori,fecha;

    public Categoria() {
    }

    public Categoria(String id, String categori, String fecha) {
        this.id = id;
        this.categori = categori;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategori() {
        return categori;
    }

    public void setCategori(String categori) {
        this.categori = categori;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
