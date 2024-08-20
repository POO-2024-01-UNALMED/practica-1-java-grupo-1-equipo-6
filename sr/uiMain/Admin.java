package uiMain;
import gestorAplicacion.*;
import java.util.ArrayList;
import java.util.Scanner;

import BaseDatos.Serializador;

import java.util.List;

public class Admin{
	public static void main(String[] args){ 
        
   	 Scanner entrada = new Scanner(System.in);
   	 	
   	 	
   	 	Cine.cargarCines();
   	 	Cliente.cargarClientes();
   	 	Funcion.cargarFunciones();
   	 	Maquina.cargarMaquinas();
   	 	Pelicula.cargarPeliculas();
   	 	Sala.cargarSalas();
   	 	ZonaDeJuegos.cargarZonasDeJuegos();
   	 	
        Interfaz.crearObjetos();
        int opcion;
        boolean finalizar=false;
        
        while(!finalizar){
            System.out.println("-------Sistema para la compra de boletos de cine-----------");
            System.out.println("1.- Comprar boletos para un cine");
            System.out.println("2.- Gestionar Zona de Juegos");
            System.out.println("3.- Gestionar Peliculas");
            System.out.println("4.- Cuarta operaciòn");
            System.out.println("5.- Quinta operaciòn");
            System.out.println("------------------");
            System.out.println("6. Comprar boleta para jugar maquinitas");
            System.out.println("7. Menu de Creacion");
            System.out.println("8. Asignaciones");
            System.out.println("9.- Terminar");
            System.out.println("Por favor elija la operación que desea hacer");
            

            opcion = entrada.nextInt();

            switch(opcion){

                case 1:
                   Interfaz.primeraOperacion();
                    break;
                case 2:
                    Interfaz.gestionarZonaDeJuegos();
                    break;
                case 3:
                    Interfaz.gestionarPeliculas();
                    break;
                case 5:
                	Interfaz.comprarTarjeta();
                case 6:
                    Interfaz.comprarBoletaJuegos();
                    break;
                case 7:
                    Interfaz.creacion();
                    break;
                case 8:
                	Interfaz.asignacion();
                	break;

                default:
                    System.out.println("El número ingresado debe estar entre 1 y 8");

                case 9:
                  System.out.println("Hasta la proxima");
                  Cine.guardarCines();
                  Cliente.guardarClientes();
                  Funcion.guardarFunciones();
                  Maquina.guardarMaquinas();
                  Pelicula.guardarPeliculas();
                  Sala.guardarSalas();
                  ZonaDeJuegos.guardarZonasDeJuegos();
                  System.exit(0);
                  break;
                  
            }
            
        }
}
}




    
    

    
     
    

    

        