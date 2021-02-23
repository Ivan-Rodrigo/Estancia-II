import java.util.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import java.io.*;
import java.time.LocalDate;

public class Agencia{
    static Scanner entrada = new Scanner (System.in);
    static ArrayList <Accesorio> listaAccesoris = new ArrayList <Accesorio>();
    static ArrayList <GenerarMoto> listaMotos = new ArrayList <GenerarMoto>();
    static Inventario inventario = new Inventario();
    static float pago;
    static float pagar;
    static int eliminar;
    static float dinero;
    static String edad,nombre;
    static float cambio;
    static Accesorio salvado;
    static int productos;
    static LocalDate fecha=LocalDate.now();
    

    public static void main(String[] args)throws FileNotFoundException, IOException{
        boolean bandera=true;
        boolean tri=true;
        int opc=0;
        do{ 
            System.out.println("\n");
            System.out.println("\tQuien sera el que usa el Sistema");
            System.out.println("\t1.-Gerenta\n\t2.-Cajero\n\t3.salir Y Generar Reporte");
            do{
                try {
                    opc=entrada.nextInt();
                    tri=false;
                    
                } catch (Exception e) {
                    System.out.println("Ingrese un numero");
                    entrada.nextLine();
                }

            }while(tri);
            
            
    
            switch (opc) {
                //Solo lo usa el gerente y puede registrar
                case 1:
                int op;
                
                System.out.println("\tDijite una Opcion\n1.-Registrar Motos A Pedido\n2.-Registrar Accesorios\n3.-Inventario");
                op=entrada.nextInt();
                    
                    switch (op) {
                        case 1:
                            addMotos();
                        break;
    
                        case 2:
                            addAccesorios();
                        break;

                        case 3:
                            manejoInventario();
                            verInventario();
                        break; 
                    
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }
    
                    
                    
                break;
    
                //Es para el cajero
                case 2:
                    
                    vender();

                break;

                case 3:
                   
                    ventaFinal(salvado);  
                    System.out.println("Gracias Por Usarnos");
                    bandera=false;
                
                break;
            
                default:
                    System.out.println("Opcion no valida");
                break;
            }

        }while(bandera);        
    }

    static public void addMotos(){
        GenerarMoto moto= new GenerarMoto();
        String color;
        String marca;
        int cilindros;
        String modelo;
        float precio;
        System.out.println("\tCreando Tu Moto a Tu Placer");
        System.out.println("\n");
        System.out.println("Ingrese el Color de la Moto");
        entrada.nextLine();
        color=entrada.nextLine();
        moto.setColor(color);

        System.out.println("Ingrese la Marca de la moto");
        marca=entrada.next();
        moto.setMarca(marca);

        System.out.println("Ingrese el numero de Cilindros del motor");
        cilindros=entrada.nextInt();
        moto.setCilindros(cilindros);

        System.out.println("Ingrese el modelo de la moto");
        modelo=entrada.next();
        moto.setModelo(modelo);

        System.out.println("Ingrese el precio de venta de la Moto");
        precio=entrada.nextFloat();
        moto.setPrecio(precio);

        listaMotos.add(moto);

        System.out.println("Moto a Pedido Generada");
    }

    static public void addAccesorios(){
        int gene;
        System.out.println("1.-Generar accesorios Automaticos\n2.-Genrerar Manualmente");
        gene=entrada.nextInt();

        switch (gene) {
            case 1:
                Accesorio acce = new Casco("Casco", "Fox", "Negro y rojo", 1050.0f, "Polarizado gris", "Fibra de carbono", "Enduro");
                listaAccesoris.add(acce);
                acce= new Chamarra("Chamarra", "Harley", "Negra", 2000.0f, "Piel con malla", "Caballero");
                listaAccesoris.add(acce);
                acce = new Luces("Faros", "Vipeer", "Blanca", 700.0f, 10, "Alojena");
                listaAccesoris.add(acce);

                System.out.println("Los accesorios Fueron Creados Correctamento");
                
            break;

            case 2:
                int opc;
                System.out.println("\tQue desea generar");
                System.out.println("1.-Cascos\n2.-Chamarras\n3.-Luces");
                opc=entrada.nextInt();
                if (opc==1){
                    System.out.println("Ingrese el nombre");
                    String nombre=entrada.next();
                    System.out.println("Ingrese la marca");
                    String marca=entrada.next();
                    System.out.println("ingrese el color");
                    entrada.nextLine();
                    String color=entrada.nextLine();
                    System.out.println("ingrese el Precio");
                    float precio=entrada.nextFloat();
                    System.out.println("Ingrese el color de la mica");
                    String colorMica=entrada.next();
                    System.out.println("Ingrese el material");
                    entrada.nextLine();
                    String material=entrada.nextLine();
                    System.out.println("Ingrese el tipo del Casco");
                    String tipoCasco=entrada.next();
                    acce = new Casco(nombre, marca, color, precio, colorMica, material, tipoCasco);
                    listaAccesoris.add(acce);

                }
                if(opc==2){
                    System.out.println("Ingrese el nombre");
                    String nombre=entrada.next();
                    System.out.println("Ingrese la marca");
                    String marca=entrada.next();
                    System.out.println("ingrese el color");
                    String color=entrada.next();
                    System.out.println("ingrese el Precio");
                    float precio=entrada.nextFloat();
                    System.out.println("Ingrese el material");
                    entrada.nextLine();
                    String material=entrada.nextLine();
                    System.out.println("Ingrese si el pata dama o Caballero");
                    String genero=entrada.next();
                    acce = new Chamarra( nombre, marca,color, precio, material, genero);
                    listaAccesoris.add(acce);

                }
                if(opc==3){
                    System.out.println("Ingrese el nombre");
                    String nombre=entrada.next();
                    System.out.println("Ingrese la marca");
                    entrada.nextLine();
                    String marca=entrada.nextLine();
                    System.out.println("ingrese el color");
                    String color=entrada.next();
                    System.out.println("ingrese el Precio");
                    float precio=entrada.nextFloat();
        
                    System.out.println("Ingrese el Numero de leds");
                    int numeroLeds=entrada.nextInt();
                    System.out.println("Ingrese el tipo de Luz");
                    String tipoLuz=entrada.next();
                    acce = new Luces( nombre, marca, color, precio, numeroLeds, tipoLuz);
                    listaAccesoris.add(acce);

                }
            break;
        
            default:
                System.out.println("Opcion no valida");
            break;
        }

    }

    static public void generearTikec(int eliminar)throws FileNotFoundException, IOException{
        
            File archivo;
        
            try {
                
                archivo= new File("C:\\Users\\rodro\\Desktop\\Proyecto Poo\\ticket"+(eliminar+1)+".txt");

                if (archivo.createNewFile()){
                    System.out.println("archivo creado");
                }
                
            } catch (Exception e) {
                System.out.println(" no se creo ");
                
            }
        
        FileWriter archivoEscribir = new FileWriter("ticket"+(eliminar+1)+".txt");
        PrintWriter escribir = new PrintWriter(archivoEscribir);
        


        escribir.println("                 COMPROBANTE DE COMPRA ");
        escribir.println("               AGENCIA DOS RUEDAS LOCAS ");
        escribir.println("  Fecha de Venta:"+fecha+"                                 ");
        escribir.println("                                                           ");
        escribir.println(" Cliente:                                                  ");
        escribir.println(""+nombre+"\tCon Edad De :"+edad+"                          ");
        escribir.println("                                                           ");
        escribir.println("      Moto :"+listaMotos.get(eliminar).getMarca()+" Modelo :"+listaMotos.get(eliminar).getModelo()+"");
        escribir.println("      Descripcion: "+listaMotos.get(eliminar).getColor()+" Con :"+listaMotos.get(eliminar).getCilindros()+" Cilindros");
        escribir.println("      Precio :$"+listaMotos.get(eliminar).getPrecio()+"     ");
        escribir.println("      Total a Pagar  $:"+listaMotos.get(eliminar).getPrecio()+"");
        escribir.println("      Pago con $: "+pago+"                                     ");
        escribir.println("      Cambio  $:"+pagar+"                              ");
        escribir.println("                                                           ");
        escribir.println("                                                           ");
        escribir.println("                                                           ");
        escribir.println("                                                           ");
        escribir.println("ticket del dia sin valor fisca                             ");
        

        if (archivoEscribir != null){
            archivoEscribir.close();
        }

       System.out.println("Generado");
    }
    

    static public void vender()throws FileNotFoundException, IOException{
        if (listaAccesoris.size()==0 && listaMotos.size()==0){
            System.out.println("No procuctos Cargados Para Vender");
        }
        else{
            System.out.println("\t\tPUNTO DE VENTA ");
        System.out.println("Seleccione una opcion");
        System.out.println("\t1.-Vender Motos\n\t2.-Vender Accesorios");

        int opc=entrada.nextInt();
            
            switch(opc){
                case 1:
                    if(listaMotos.size()==0){
                        System.out.println("No Hay Motos Creadas");
                    }
                    else{
                        for(int i=0;i<listaMotos.size();i++){
                            System.out.println((i+1)+" Las Motos del Catalogo son:\n"+listaMotos.get(i).getMarca()+"\tCuenta con "+listaMotos.get(i).getCilindros()+" Cilindros"+"\tSu Color es:"+listaMotos.get(i).getColor()+"\tCon el precio de $:"+listaMotos.get(i).getPrecio());
                            System.out.println("\n");
                        }
                        
        
                        System.out.println("Elija la moto que Desea vender");
                        eliminar = entrada.nextInt();
                        eliminar = eliminar - 1;
                        System.out.println("La moto a vender es :"+listaMotos.get(eliminar).getMarca()+"\tDe Color :"+listaMotos.get(eliminar).getColor()+"\tCon el precio a Pagar de:"+listaMotos.get(eliminar).getPrecio());
                        System.out.println("Ingrese la Cantidad a pagar");
                        pago=entrada.nextFloat();
                        
                        if(pago>=listaMotos.get(eliminar).getPrecio()){
                                pagar= pago-listaMotos.get(eliminar).getPrecio();
                                System.out.println("Su cambio es :"+pagar);
                                
                        }
                        while(pago<listaMotos.get(eliminar).getPrecio()){
                            System.out.println("No Puede pagar Falta efectivo");
                            pago=entrada.nextFloat();
                        }
                        System.out.println("Ingrese Su Nombre Completo");
                            entrada.nextLine();
                            nombre=entrada.nextLine();
                        System.out.println("Ingrese Su Edad");
                            edad=entrada.nextLine();
                            generearTikec(eliminar);
                            listaMotos.remove(eliminar);
                        
                        System.out.println(" \n");
                
                        
                    }
                    break;
                   
    
                case 2:
                    if(listaAccesoris.size()==0){
                        System.out.println("No hay Accesorios Generados para Vender");
                    }
                    else{
                        System.out.println("Que Accesorio desea Vender");
                    System.out.println("1.-Casco\n2.-Chamarras\n3.-Luces");
                    int articulo=entrada.nextInt();
                    
                    switch (articulo) {
                        case 1:
                            for(int i=0;i<listaAccesoris.size();i++){
                                if(listaAccesoris.get(i) instanceof Casco){
                                    System.out.println("Los Cascos que Manejamos son :\n"+(i+1)+" "+listaAccesoris.get(i).getMarca()+"\tEn Color :"+listaAccesoris.get(i).getColor()+"\tCon el precio de $"+listaAccesoris.get(i).getPrecio());
                                }
                            }

                            System.out.println("Elija el Codigo del el casco a Comprar");
                            int compra=entrada.nextInt();
                            compra= compra-1;
                            System.out.println("El Casco a Vender es:"+listaAccesoris.get(compra).getMarca()+"Con el Precio de $"+listaAccesoris.get(compra).getPrecio());
                            System.out.println("Ingrese la Cantidad a pagar");
                            dinero=entrada.nextInt();
                            if(dinero>=listaAccesoris.get(compra).getPrecio()){
                                cambio= dinero-listaAccesoris.get(compra).getPrecio();
                                System.out.println("Su cambio es :"+cambio);
                            }
                            while(dinero<listaAccesoris.get(compra).getPrecio()){
                                System.out.println("No se puede Pagar le falta Efectivo");
                                dinero=entrada.nextFloat();
                            }

                            ticketAcce(compra);
                            salvado=listaAccesoris.remove(compra);


                        break;
                        case 2:
                        for(int i=0;i<listaAccesoris.size();i++){
                            if(listaAccesoris.get(i) instanceof Chamarra){
                                System.out.println("Las Chamarras que Manejamos son :\n"+(i+1)+" "+listaAccesoris.get(i).getMarca()+"\tEn Color :"+listaAccesoris.get(i).getColor()+"\tCon el precio de $"+listaAccesoris.get(i).getPrecio());
                            }
                        }

                        System.out.println("Ingrese El Codigo de la Chamarra a Comprar");
                         compra=entrada.nextInt();
                        compra= compra-1;
                        System.out.println("La Chamarra a Vender es:"+listaAccesoris.get(compra).getMarca()+"Con el Precio de $"+listaAccesoris.get(compra).getPrecio());
                        System.out.println("Ingrese la Cantidad a pagar");
                         dinero=entrada.nextInt();
                        if(dinero>=listaAccesoris.get(compra).getPrecio()){
                            cambio= dinero-listaAccesoris.get(compra).getPrecio();
                            System.out.println("Su cambio es :"+cambio);
                        }
                        while(dinero<listaAccesoris.get(compra).getPrecio()){
                            System.out.println("No se puede Pagar le falta Efectivo");
                            dinero=entrada.nextFloat();
                        }

                        ticketAcce(compra);
                        salvado=listaAccesoris.remove(compra);
                        break;
                        case 3:
                        for(int i=0;i<listaAccesoris.size();i++){
                            if(listaAccesoris.get(i) instanceof Luces){
                                System.out.println("Las Luces que Manejamos son :\n"+(i+1)+" "+listaAccesoris.get(i).getMarca()+"\tEn Color :"+listaAccesoris.get(i).getColor()+"\tCon el precio de $"+listaAccesoris.get(i).getPrecio());
                            }
                        }

                        System.out.println("Ingrese el Codigo de las Luces  a Comprar");
                         compra=entrada.nextInt();
                        compra= compra-1;
                        System.out.println("Las Luces  a Vender Son:"+listaAccesoris.get(compra).getMarca()+"Con el Precio de $"+listaAccesoris.get(compra).getPrecio());
                        System.out.println("Ingrese la Cantidad a pagar");
                         dinero=entrada.nextInt();
                        if(dinero>=listaAccesoris.get(compra).getPrecio()){
                            cambio= dinero-listaAccesoris.get(compra).getPrecio();
                            System.out.println("Su cambio es :"+cambio);
                        }
                        while(dinero<listaAccesoris.get(compra).getPrecio()){
                            System.out.println("No se puede Pagar le falta Efectivo");
                            dinero=entrada.nextFloat();
                        }

                        ticketAcce(compra);
                        salvado=listaAccesoris.remove(compra);
                        break;
                    
                        default:
                            System.out.println("Opcion no valida");
                            break;
                    }

                    }
                    
                break;
                    
                
    
            }

        }
        
    }

    static public void manejoInventario(){

        int contadorCascos=0;
        int contadorChamarras=0;
        int contadorLuces=0;
        int totalAcce;
        int totalMotos;
        for(int i=0;i<listaAccesoris.size();i++){
            if(listaAccesoris.get(i) instanceof Casco){
                contadorCascos++;
            }

            if(listaAccesoris.get(i) instanceof Chamarra){
                contadorChamarras++;
            }
            if(listaAccesoris.get(i) instanceof Luces){
                contadorLuces++;
            }
        }
        totalAcce=listaAccesoris.size();
        totalMotos=listaMotos.size();

        inventario.setTotalCascos(contadorCascos);
        inventario.setTotalChamarras(contadorChamarras);
        inventario.setTotalLuces(contadorLuces);
        inventario.setTotalAccesorios(totalAcce);
        inventario.setTotalMotos(totalMotos);
    }

    static public void verInventario(){
        
        System.out.println("1.-Inventario general\n2.-Inventario Por Accesorio\n3.-Inventario De Motos");
        int opc=entrada.nextInt();

        switch (opc) {
            case 1: 
                System.out.println("El total de Accesorios que tenemos son:"+inventario.getTotalAccesorios());
                for(int i=0;i<listaAccesoris.size();i++){
                    System.out.println("Su nombre es :"+listaAccesoris.get(i).getNombre()+"Con Precio de :"+listaAccesoris.get(i).getPrecio());
                }
                System.out.println("\n");
                System.out.println("El total de Motos son: "+inventario.getTotalMotos());
                for(int i=0;i<listaMotos.size();i++){
                    System.out.println("Su marca es :"+listaMotos.get(i).getMarca()+""+"Con precio de $"+listaMotos.get(i).getPrecio());
                }
                
            break;

            case 2:
                System.out.println("1.-Casco\n2.-Chamarras\n3.-Luces");
                int op=entrada.nextInt();
                if(op==1){
                    System.out.println("El total de Casco son"+inventario.getTotalCascos());
                    for(int i=0;i<listaAccesoris.size();i++){
                        if(listaAccesoris.get(i) instanceof Casco){
                            System.out.println("De Marcas:"+listaAccesoris.get(i).getMarca());
                        }
                    }
                }
                if(op==2){
                    System.out.println("El total de Chamarras son"+inventario.getTotalChamarras());
                    for(int i=0;i<listaAccesoris.size();i++){
                        if(listaAccesoris.get(i) instanceof Chamarra){
                            System.out.println("De Marcas:"+listaAccesoris.get(i).getMarca()+"De color"+listaAccesoris.get(i).getColor());
                        }
                    }

                }
                if (op==3){
                    System.out.println("El total de Luces son"+inventario.getTotalLuces());
                    for(int i=0;i<listaAccesoris.size();i++){
                        if(listaAccesoris.get(i) instanceof Luces){
                            System.out.println("De Marcas:"+listaAccesoris.get(i).getMarca());
                        }
                    }

                }
            break;

            case 3:
                System.out.println("El total de motos son:"+inventario.getTotalMotos());
                for(int i=0;i<listaMotos.size();i++){
                    System.out.println("De Marca : "+listaMotos.get(i).getMarca()+" con: "+listaMotos.get(i).getCilindros()+"Cilindros");
                }
            break;
        
            default:
                break;
        }
    }

    static public void ticketAcce(int compra)throws FileNotFoundException, IOException{
        File archivo;
        
            try {
                
                archivo= new File("C:\\Users\\rodro\\Desktop\\Proyecto Poo\\ticketAccesorios"+(compra+1)+".txt");

                if (archivo.createNewFile()){
                    System.out.println("archivo creado");
                }
                
            } catch (Exception e) {
                System.out.println(" no se creo ");
                
            }
        
        FileWriter archivoEscribir = new FileWriter("ticketAccesorios"+(compra+1)+".txt");
        PrintWriter escribir = new PrintWriter(archivoEscribir);
        
        
        escribir.println("                 COMPROBANTE DEL DIA                     ");
        escribir.println("               AGENCIA DOS RUEDAS LOCAS                   ");
        escribir.println("                                                           ");
        escribir.println("        Fecha:"+fecha);
        escribir.println("                                                           ");
        escribir.println("      Descripcion :"+listaAccesoris.get(compra).getNombre()+" "+listaAccesoris.get(compra).getMarca());
        escribir.println("      Precio $: "+listaAccesoris.get(compra).getPrecio()+"");
        escribir.println("      Total a Pagar $:"+listaAccesoris.get(compra).getPrecio());
        escribir.println("      Pago con $:"+dinero);
        escribir.println("      Cambio $:"+cambio);
        escribir.println("                                                           ");
        escribir.println("ticket del dia sin valor fiscal                             ");
        escribir.println("                                                           ");

        if (archivoEscribir != null){
            archivoEscribir.close();
        }
       System.out.println("Generado");
    }

    static public void ventaFinal(Accesorio salvado)throws FileNotFoundException, IOException{
        float vengtaDia;
        vengtaDia=salvado.getPrecio();
        File archivo;
        
            try {
                
                archivo= new File("C:\\Users\\rodro\\Desktop\\Proyecto Poo\\ticketVenta"+(1)+".txt");

                if (archivo.createNewFile()){
                    System.out.println("Archivo Final Creado");
                }
                
            } catch (Exception e) {
                System.out.println(" no se creo ");
                
            }
        FileWriter archivoEscribir = new FileWriter("ticketVenta"+(1)+".txt");
        PrintWriter escribir = new PrintWriter(archivoEscribir);
        
        escribir.println("                 COMPROBANTE DE COMPRA                     ");
        escribir.println("               AGENCIA DOS RUEDAS LOCAS                   ");
        escribir.println("                                                           ");
        escribir.println("      Los Poductos Vendidos Fueron :"                       );
        escribir.println("   :"+salvado.getNombre()+" "+salvado.getMarca()      );
        escribir.println("      El total Vendido Fue $:"+vengtaDia);
        escribir.println("                                                           ");
        escribir.println("ticket del Final del dia                                   ");
        escribir.println("                                                           ");

        if (archivoEscribir != null){
            archivoEscribir.close();
        }

    }
}