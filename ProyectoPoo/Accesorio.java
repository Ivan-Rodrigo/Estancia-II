public class Accesorio{
    protected String nombre;
    protected String marca;
    protected String color;
    protected float precio;
    

    public Accesorio(String nombre,String marca,String color,float precio){
        this.nombre=nombre;
        this.marca=marca;
        this.color=color;
        this.precio=precio;
        
    }



    public String getNombre() {
        return nombre;
    }


    public String getMarca() {
        return marca;
    }

    

    public String getColor() {
        return color;
    }


    public float getPrecio() {
        return precio;
    }


    
}