package uiMain;
import gestorAplicacion.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin{
    static Scanner entrada = new Scanner(System.in);
    static Cine[] cines;
    static Cliente usuario = new Cliente("Juan Manuel",200000);

    //Para probar la funcionalidad
    static Pelicula pelicula1 = new Pelicula("Intensamente","Infantil");
    static Pelicula pelicula2 = new Pelicula("Spiderman","Acción");
    static Pelicula pelicula3 = new Pelicula("Jason  Vorhees","Terror");
    static Sala sala1 = new Sala(10,50);
    static Sala sala2 = new Sala(10,30);
    static Funcion funcion1 = new Funcion(pelicula1, "4:00pm", 3, sala1);
    
    static ArrayList<Funcion> funcionesCine1 = new ArrayList<Funcion>();
    static Cine cine1 = new Cine("Star Cine Medellín",funcionesCine1);

    public static void main(String[] args){ 

        sala1.setCine(cine1);

        funcionesCine1.add(funcion1);
        cines[0] = cine1;
        
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

        String peliculaDeseada; 
        Pelicula peliculaParaVer = null;
        ArrayList<Cine> tienenPelicula = new ArrayList<>();
        ArrayList<Funcion> funcionesPelicula = new ArrayList<>();
        
        Scanner entrada = new Scanner(System.in);  // Asegúrate de tener una instancia de Scanner

        System.out.println("Por favor ingrese el nombre de la película que desea ver: ");
        peliculaDeseada = entrada.nextLine();

        ArrayList<Pelicula> peliculasEncontradas = cines[0].buscarPeliculaPorNombre(peliculaDeseada);

        if (peliculasEncontradas.size() > 0) {
            System.out.println("Estos son algunos resultados coincidentes:");
            for (int i = 0; i < peliculasEncontradas.size(); i++) {
                System.out.println((i + 1) + ". " + peliculasEncontradas.get(i).getTitulo());
            }

            System.out.println("Selecciona la película que buscas o ingresa 0 si deseas salir");
            int eleccion = entrada.nextInt();
            entrada.nextLine(); // Para consumir el salto de línea después de nextInt()

            if (eleccion != 0) {
                if (eleccion >= 1 && eleccion <= peliculasEncontradas.size()) {
                    peliculaParaVer = peliculasEncontradas.get(eleccion - 1); // Ajuste del índice
                } else {
                    System.out.println("Opción no válida");
                }
            } else {
                System.out.println("Regresando al menú");
                return;  // Termina la operación si se elige salir
            }
        } else {
            System.out.println("No se han encontrado resultados. ¿Desea realizar otra búsqueda?");
            return;  // Termina la operación si no se encuentra la película
        }

        for (Cine cine : cines) {
            if (cine.hayPelicula(peliculaParaVer)) {
                tienenPelicula.add(cine);
            }
        }

        int opcion = 1;
        if (tienenPelicula.size() > 0) {
            System.out.println("Estas son las funciones disponibles para ver la película:");
            System.out.println("");

            for (Cine cine : tienenPelicula) {
                System.out.println("Cine " + cine.getNombre() + ":");
                ArrayList<Funcion> opcionesPelicula = cine.obtenerFunciones(peliculaParaVer);
                for (Funcion funcion : opcionesPelicula) {
                    funcionesPelicula.add(funcion);
                    System.out.println(opcion + ". " + funcion.getSala().getNombre() + ", " + funcion.getHorario() + ".");
                    opcion++;
                }
                System.out.println("");
            }
        } else {
            System.out.println("Ninguno de nuestros cines tiene alguna función para la película " + peliculaParaVer.getTitulo());
            return;  // Termina la operación si no hay funciones disponibles
        }

        System.out.println("¿Desea hacer una reservación (S/N)?");
        String reserva = entrada.nextLine();

        if (reserva.equalsIgnoreCase("S")) {
            int funcionNumero;
            do {
                System.out.println("Elige la función:");
                funcionNumero = entrada.nextInt();
                entrada.nextLine(); // Consumir el salto de línea
            } while (funcionNumero <= 0 || funcionNumero > funcionesPelicula.size());

            Funcion funcionEscogida = funcionesPelicula.get(funcionNumero - 1);
            Sala sala = funcionEscogida.getSala();
            Cine cineElegido = sala.getCine();

            System.out.println("A continuación se muestran los asientos para dicha función:");
            System.out.println("");
            System.out.println(sala.estadoSilleteria());
            System.out.println("");

            int fila, columna;
            do {
                System.out.println("Escriba la posición del asiento indicando su fila y columna:");
                System.out.print("Fila: ");
                fila = entrada.nextInt();
                System.out.print("Columna: ");
                columna = entrada.nextInt();
                entrada.nextLine(); // Consumir el salto de línea

            } while (fila <= 0 || fila > sala.getSillas().length || columna <= 0 || columna > sala.getSillas()[0].length);

            if (sala.estaDisponible(fila - 1, columna - 1)) {
                System.out.println("El asiento está libre");
                System.out.println("");
                System.out.println("Opciones de pago:");
                System.out.println("1. Tarjeta de membresía");
                System.out.println("2. Efectivo");

                String pago = entrada.nextLine();
                if (pago.equals("1")) {
                    if (usuario.getTarjeta() != null) {
                        System.out.println("Desea pagar con: ");
                        System.out.println("1. Los puntos de tu tarjeta");
                        System.out.println("2. El saldo de tu tarjeta");
                        int pagoTarjeta = entrada.nextInt();
                        entrada.nextLine(); // Consumir el salto de línea
                        if (pagoTarjeta == 1) {
                            if (usuario.pagarConTarjeta(funcionEscogida.getBoleta().getPrecio(), true)) {
                                sala.reservarSilla(fila - 1, columna - 1);
                                usuario.getTarjeta().agregarPuntos();
                                finalizarCompra(funcionEscogida, sala, peliculaParaVer, cineElegido);
                            } else {
                                System.out.println("No se pudo llevar a cabo la compra con los puntos de la tarjeta");
                            }
                        } else if (pagoTarjeta == 2) {
                            if (usuario.pagarConTarjeta(funcionEscogida.getBoleta().getPrecio(), false)) {
                                sala.reservarSilla(fila - 1, columna - 1);
                                usuario.getTarjeta().agregarPuntos();
                                finalizarCompra(funcionEscogida, sala, peliculaParaVer, cineElegido);
                            } else {
                                System.out.println("No se pudo llevar a cabo la compra con el saldo de la tarjeta");
                            }
                        }
                    } else {
                        System.out.println("No cuenta con tarjeta para llevar a cabo el pago");
                    }
                } else if (pago.equals("2")) {
                    double saldoAntes = usuario.getSaldo();
                    usuario.pagarConSaldo(funcionEscogida.getBoleta().getPrecio());
                    if (saldoAntes != usuario.getSaldo()) {
                        sala.reservarSilla(fila - 1, columna - 1);
                        finalizarCompra(funcionEscogida, sala, peliculaParaVer, cineElegido);
                    } else {
                        System.out.println("No se pudo llevar a cabo la compra con su saldo");
                    }
                }
            } else {
                System.out.println("El asiento se encuentra ocupado");
            }
        }
    }
    public static void finalizarCompra(Funcion funcion, Sala sala, Pelicula pelicula, Cine cine){
        usuario.agregarBoleta(new Boleta(funcion, usuario, sala, pelicula));
        System.out.println("Se ha finalizado la compra");
        System.out.println("Detalles: ");
        System.out.println("Boleto para la película " + pelicula.getTitulo() + ", que se proyectará a las " + funcion.getHorario() + ", en la sala " + sala.getNombre() +" del cine "+ cine.getNombre()+".");

    }
    
}