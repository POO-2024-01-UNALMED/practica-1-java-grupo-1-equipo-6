package uiMain;
import gestorAplicacion.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Admin{

    Scanner entrada = new Scanner(System.in);


    Pelicula pelicula1 = new Pelicula("Blancanieves", "Infantil");
    Pelicula pelicula2 = new Pelicula("Guerra Mundial z", "Acciòn");
    Pelicula pelicula3 = new Pelicula("La patada mortal del mocho", "Superaciòn")

    Cliente usuario = new Cliente("Usuario", 50000);

    Sala sala1 = new Sala(10, 50);
    Sala sala2 = new Sala(20,20);

    Funcion funcion1 = new Funcion(pelicula1, "12:00 pm", 3, sala1);
    Funcion funcion2 = new Funcion(pelicula1, "4:00 pm", 3, sala2);
    Funcion funcion1 = new Funcion(pelicula2, "8:00pm", 3, sala2);

    ArrayList<Funcion> funciones1 = new ArrayList<Funcion>();
    ArrayList<Funcion> funciones2 = new ArrayList<Funcion>();
    ArrayList<Funcion> funciones3 = new ArrayList<Funcion>();

    funciones1.add(funcion1);
    funciones1.add(funcion3);
    funciones1.add(funcion2);
    funciones2.add(funcion3);
    funciones2.add(funcion1);

    Cine cine1 = new Cine("CineColombia", funciones1);
    Cine cine2 = new Cine("Cinepolis", funciones2);
    Cine cine3 = new Cine("Cineplux", funciones3);

    Cine[] cines = {cine1, cine2, cine3};
    Pelicula[] peliculas = {pelicula1, pelicula2, pelicula3};


    public static void main(String[] args){
        
    int decision = menuPrincipal();

    switch (decision){
        case 1:
            primeraOperacion();
            break;

    }

    }

    static int menuPrincipal(){

        int eleccion;

        do{
            System.out.println("-------Sistema para la compra de boletos de cine-----------");
            System.out.println("1.- Comprar boletos para un cine");
            System.out.println("2.- Segunda operación");
            System.out.println("3.- Tercera operación");
            System.out.println("4.- Cuarta operaciòn");
            System.out.println("5.- Quinta operaciòn");
            System.out.println("6.- Terminar");
            System.out.println("Bienvenido, por favor elija la operación que desea hacer");

            eleccion = entrada.nextInt();
        } while(Number.isInteger(eleccion) && eleccion>0 && eleccion<7);

        return eleccion
    }


    static void primeraOperacion(){

        int opcionCine, opcionPelicula;

        System.out.println("Escoge el cine para la bùsqueda");

        for (int i =0; i<cines.length;i++){
            System.out.prinln((i+1) +".- "+cines[i].getNombre());
        }

        opcionCine = entrada.nextInt();
        Cine cineElegido = cines[opcionCine-1];


        System.out.println("Escoge la pelìcula que deseas ver");

        for (int i =0; i<peliculas.length;i++){
            System.out.prinln((i+1) +".- "+peliculas[i].getNombre());
        }

        opcionPelicula = entrada.nextInt();
        Pelicula peliculaElegida = peliculas[opcionPelicula-1];

        if (cineElegido.hayPelicula(peliculaElegida) && if(cineElegido.obtenerFunciones(peliculaElegida).size != 0)){
            System.out.println("Estas son las funciones disponibles para la película");
            ArrayList<Funcion> funcionesDisponibles = cineElegido.obtenerFunciones(peliculaElegida);
            for (int i = 0;i<funcionesDisponibles.size();i++){
                System.out.println((i+1) + ".- "+ funcionesDisponibles.get(i).getHorario() + ",  em la sala " +funcionesDisponibles.get(i).getSala(),getNombre() + ".");
            }


            System.out.println("¿Hara una reservación?(S/N)");
            Strng reserva = entrada.nextLine();
            if(reserva.equals("S")){
                System.out.println("Elija la funciòn");
                int funcion = entrada.nextInt();
                Funcion funcionElegida =  funcionesDisponibles.get(funcion-1);
                Sala salaElegida = funcionElegida.getSala().getNombre();
                
                System.out.println("Elija un método de pago:");
                System.out.println("1. Con tarjeta");
                System.out.println("2. Saldo personal");

                int metodoDePago = entrada.nextInt();

                if (metodoDePago == 1){

                    if (usuario.pagarConTarjeta(funcionElegida.getBoleta().getPrecio(), true) == false){
                        System.out.println("No tiene suficientes puntos ni saldo para comprar la entrada");
                        int saldoUsuario = usuario.getSaldo();
                         System.out.println("Se procede al pago con su saldo personal");
                         usuario.pagarConSaldo();

                         if(saldoUsuario == usuario.getSaldo){
                            System.out.println("No se pudo llevar a cabo la compra")
                         }else{
                            
                            usuario.agregarBoleta(new Boleta(funcionElegida, this, salaElegida);)

                         }

                    }else{   usuario.agregarBoleta(new Boleta(funcionElegida, this, salaElegida);)}

                }

            }

        } else{
            System.out.prinln("Para la pelìcula elegida no se encuentran funciones disponibles.")
            System.out.prinln("¿Desea cambiar de cine(1) o de pelicula(2)?");

        }

    }
}