package uiMain;
import gestorAplicacion.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main{
    static Scanner entrada = new Scanner(System.in);
    static Cine[] cines;

    public static void main(String[] args){
        int opcion;
        boolean finalizar=false;

        while(!finalizar){
            System.out.println("-------Sistema para la compra de boletos de cine-----------");
            System.out.println("1.- Comprar boletos para un cine");
            System.out.println("2.- Segunda operación");
            System.out.println("3.- Tercera operación");
            System.out.println("4.- Cuarta operaciòn");
            System.out.println("5.- Quinta operaciòn");
            System.out.println("6.- Terminar");
            System.out.println("Bienvenido, por favor elija la operación que desea hacer");

            opcion = entrada.nextInt();

            switch(opcion){

                case 1:
                    primeraOperacion();
                    break;

                default:
                    System.out.println("El número ingresado debe estar entre 1 y 6");
            }
        }
        
        
    }
    public static void error(){System.out.println("Error");}

    public static void primeraOperacion(){

        String peliculaDeseada; int opcion = 1;
        System.out.println("Por favor ingrese el nombre de la pelìcula que desea ver: ");
        peliculaDeseada = entrada.nextLine();

        

        System.out.println("Estos son los cines en los que puede ver la película");

        for (int i = 0; i<cines.length; i++){
            if (cines[i].hayPelicula(peliculaDeseada)){
                System.out.println(opcion + ". " +cines[i].getNombre() + ":");
                ArrayList<Funcion> funcionesPelicula = cines[i].obtenerFunciones(peliculaDeseada);
                for (Funcion funcion: funcionesPelicula){
                    System.out.println("-"+funcion.getSala().getNombre()+", a las "+funcion.getHorario());
                }
                System.out.println("");
                opcion++;
            }
        }

    }
    
}