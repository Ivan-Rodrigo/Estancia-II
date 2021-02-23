package com.example.vetaestancia30;

public class Ventas {
    String id,codigo,id_cliente,id_vendedor,productos,impuestos,neto,total,metodo_pago,fecha;

    public Ventas() {

    }

    public Ventas(String id, String codigo, String id_cliente, String id_vendedor, String productos, String impuestos, String neto, String total, String metodo_pago, String fecha) {
        this.id = id;
        this.codigo = codigo;
        this.id_cliente = id_cliente;
        this.id_vendedor = id_vendedor;
        this.productos = productos;
        this.impuestos = impuestos;
        this.neto = neto;
        this.total = total;
        this.metodo_pago = metodo_pago;
        this.fecha = fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(String id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public String getProductos() {
        return productos;
    }

    public void setProductos(String productos) {
        this.productos = productos;
    }

    public String getImpuestos() {
        return impuestos;
    }

    public void setImpuestos(String impuestos) {
        this.impuestos = impuestos;
    }

    public String getNeto() {
        return neto;
    }

    public void setNeto(String neto) {
        this.neto = neto;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
