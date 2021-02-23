public class Chamarra extends Accesorio{

    private String material;
    private String genero;

    public Chamarra (String nombre,String marca,String color,float precio,String material,String genero){
        super(nombre, marca, color, precio);
        this.material=material;
        this.genero=genero;
    }

    public String getMaterial() {
        return material;
    }


    public String getGenero() {
        return genero;
    }

        
    
}