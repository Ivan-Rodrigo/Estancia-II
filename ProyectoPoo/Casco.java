
public class Casco extends Accesorio{

    private String colorMica;
    private String material;
    private String tipoCasco;

    public Casco (String nombre,String marca,String color,float precio,String colorMica,String material,String tipoCasco){
        super(nombre, marca, color, precio);
        this.colorMica=colorMica;
        this.material=material;
        this.tipoCasco=tipoCasco;
    }

    public String getColorMica() {
        return colorMica;
    }


    public String getMaterial() {
        return material;
    }

    public String getTipoCasco() {
        return tipoCasco;
    }

    
        
}