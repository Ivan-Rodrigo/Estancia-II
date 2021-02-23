public class Luces extends Accesorio{
    private int numeroLeds;
    private String tipoLuz;

    public Luces (String nombre,String marca,String color,float precio,int numeroLeds, String tipoLuz){
        super(nombre, marca, color, precio);
        this.numeroLeds=numeroLeds;
        this.tipoLuz=tipoLuz;
    }

    public int getNumeroLeds() {
        return numeroLeds;
    }

    public String getTipoLuz() {
        return tipoLuz;
    }


    
    
}