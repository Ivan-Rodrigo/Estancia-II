package com.example.vetaestancia30;

public class Clientes {

    String id,nombre,documento,email,telefono,direccion,fecha_nacimiento,compras,ultima_compra,fecha;

    public Clientes(){

    }

    public Clientes(String id, String nombre, String documento, String email, String telefono, String direccion, String fecha_nacimiento, String compras, String ultima_compra, String fecha) {
        this.id = id;
        this.nombre = nombre;
        this.documento = documento;
        this.email = email;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fecha_nacimiento = fecha_nacimiento;
        this.compras = compras;
        this.ultima_compra = ultima_compra;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getCompras() {
        return compras;
    }

    public void setCompras(String compras) {
        this.compras = compras;
    }

    public String getUltima_compra() {
        return ultima_compra;
    }

    public void setUltima_compra(String ultima_compra) {
        this.ultima_compra = ultima_compra;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
