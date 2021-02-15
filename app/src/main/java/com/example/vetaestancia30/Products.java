package com.example.vetaestancia30;

public class Products {

    String id,id_categoria,codigo,descripcion,imagen,stock,precio_compa,precio_venta,ventas,fecha;

    public Products(){

    }

    public Products(String id, String id_categoria, String codigo, String descripcion, String imagen, String stock, String precio_compa, String precio_venta, String ventas, String fecha) {
        this.id = id;
        this.id_categoria = id_categoria;
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.stock = stock;
        this.precio_compa = precio_compa;
        this.precio_venta = precio_venta;
        this.ventas = ventas;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(String id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrecio_compa() {
        return precio_compa;
    }

    public void setPrecio_compa(String precio_compa) {
        this.precio_compa = precio_compa;
    }

    public String getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(String precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getVentas() {
        return ventas;
    }

    public void setVentas(String ventas) {
        this.ventas = ventas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
