package complejidad.basicoGrafica;

public class Main {

    public static void main(String[] args) {
	    Complejidad c = new Complejidad();
	    int ejecuciones = 15;
        int resultados[][] = new int[ejecuciones][2];
        for (int renglon=0; renglon < ejecuciones; renglon++) {
            int n = ((renglon - 1/2) * 1);
            resultados[renglon][0] = n;
            resultados[renglon][1] = c.lineal(n);
            
        }
        imprimir(resultados);
/*

        for (int renglon=0; renglon < ejecuciones; renglon++) {
            int n = (renglon + 1) * 1;
            resultados[renglon][0] = n;
            resultados[renglon][1] = c.cuadratica(n);
        }
        imprimir(resultados);

        /*
        for (int renglon=0; renglon < ejecuciones; renglon++) {
            int n = (renglon + 1) * 100;
            resultados[renglon][0] = n;
            resultados[renglon][1] = c.log(n);
        }
        imprimir(resultados);  */
    }

    private static void nada(){
        // hacer algo
    }


    private static void imprimir(int [][] resultado){
        int conta=15;
        for (int renglon = 0; renglon < resultado.length ; renglon++){
            System.out.println();
            conta--;

            for(int veces = 0; veces < resultado[renglon][1]-conta; veces++){

                
                System.out.print(" ");
                System.out.print("*");
                System.out.print(" ");
               
               
            }
            //for(int k=0;k<renglon;k++){
                //System.out.print("* ");
                
           // }
           //System.out.print("*");
           
            
        }

    }

}
