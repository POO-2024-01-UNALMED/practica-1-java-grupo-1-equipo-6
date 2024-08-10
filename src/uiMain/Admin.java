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
        Pelicula peliculaParaVer=null;
        ArrayList<Cine> tienenPelicula = new ArrayList<Cine>();
        ArrayList<Funcion> funcionesPelicula = new ArrayList<Funcion>();
        System.out.println("Por favor ingrese el nombre de la pelìcula que desea ver: ");
        peliculaDeseada = entrada.nextLine();

        ArrayList<Pelicula> peliculasEncontradas = cines[0].buscarPeliculaPorNombre(peliculaDeseada);

        if(peliculasEncontradas.size()>0){
            System.out.println("Estos son algunos resultados coincidentes");
            for (int i = 0; i<peliculasEncontradas.size();i++){
                System.out.println((i+1) + ". "+peliculasEncontradas.get(i).getTitulo());
            }
            System.out.println("Selecciona la película que buscas o ingresa 0 si deseas salir");
            int eleccion;
            eleccion = entrada.nextInt();
            if (eleccion != 0){
                if(eleccion >= 1 && eleccion<=peliculasEncontradas.size()){
                    peliculaParaVer = peliculasEncontradas.get(eleccion);
                }
                else{
                    System.out.println("Opción no valida");
                }
            }else{  System.out.println("Regresando al menú");}
        } else{
            System.out.println("No se han encontrado resultados. ¿Desea realizar otra búsqueda?");
        }

        for (Cine cine: cines){
            if(cine.hayPelicula(peliculaParaVer)){
                tienenPelicula.add(cine);
            }
        }
        ArrayList<Funcion> opcionesPelicula;
        int opcion = 1;
        if(tienenPelicula.size() > 0){
            System.out.println("Estas son las funciones disponibles para ver la película");
            System.out.println("");
            for (int i = 0; i<tienenPelicula.size();i++){
                Cine cine = tienenPelicula.get(i);
                System.out.println("Cine" + cine.getNombre()+":");
                opcionesPelicula = cine.obtenerFunciones(peliculaParaVer);
                for (int j=0; j<opcionesPelicula.size();j++){
                    funcionesPelicula.add(opcionesPelicula.get(j));
                    System.out.println(opcion+". "+opcionesPelicula.get(j).getSala().getNombre() + ", "+funcionesPelicula.get(j).getHorario()+".");
                }
            System.out.println("");
            }
            opcion++;
        }else{
            System.out.println("Ninguno de nuestros cines tiene alguna función para la película "+peliculaParaVer.getTitulo());
        }

        Funcion funcionEscogida;
        String reserva;
        int funcionNumero;
        System.out.println("Desea hacer una reservación (S/N)");
        reserva = entrada.nextLine();
        int fila;
        int columna;
        Sala sala;
        String pago;
        Cine cineElegido;

        if(reserva.toUpperCase().equals("S")){
            do{
                System.out.println("Elige la función:");
                funcionNumero = entrada.nextInt();
            }while(funcionNumero>0 && funcionNumero < opcion);

            funcionEscogida = funcionesPelicula.get(funcionNumero-1);
            sala = funcionEscogida.getSala();
            cineElegido = sala.getCine();
            System.out.println("A continuación se muestran los asientos para dicha función");
            System.out.println("");
            System.out.println(sala.estadoSilleteria());
            System.out.println("");

            System.out.println("Escriba la posición del asiento indicando su fila y columna:");

            do{
                System.out.println("Fila: ");
                fila = entrada.nextInt();
                System.out.println("Columna");
                columna = entrada.nextInt();
            }while(fila>0 && fila<sala.getSillas().length && columna>0 && columna<sala.getSillas()[0].length);
            
            if(sala.estaDisponible(fila-1, columna-1)){
                System.out.println("El asiento está libre"); 
                System.out.println("");
                System.out.println("Opciones de pago:");
                System.out.println("1. Tarjeta de membresía");
                System.out.println("2. Efectivo");
                pago = entrada.nextLine();
                if (pago.equals("1")){
                    if(usuario.getTarjeta()!=null){
                        System.out.println("Desea pagar con: "); 
                        System.out.println("1. Los puntos de tu tarjeta");
                        System.out.println("2. El saldo de tu tarjeta");
                        int pagoTarjeta;
                        pagoTarjeta = entrada.nextInt();
                        if(pagoTarjeta == 1){
                            if(usuario.pagarConTarjeta(funcionEscogida.getBoleta().getPrecio(), true)){
                                sala.reservarSilla(fila-1, columna-1);
                                usuario.getTarjeta().agregarPuntos();
                                finalizarCompra(funcionEscogida, sala, peliculaParaVer, cineElegido);
                            }else{
                                System.out.println("No se pudo llevar a cabo la compra con los puntos de la tarjeta");
                            }
                        }else if(pagoTarjeta == 2){
                            if(usuario.pagarConTarjeta(funcionEscogida.getBoleta().getPrecio(), false)){
                                sala.reservarSilla(fila-1, columna-1);
                                usuario.getTarjeta().agregarPuntos();
                                finalizarCompra(funcionEscogida, sala, peliculaParaVer, cineElegido);
                            }else{
                                System.out.println("No se pudo llevar a cabo la compra con el saldo de la tarjeta"); 

                            }
                        }
                    } else{
                        System.out.println("No cuenta con tarjeta para llevar a cabo el pago"); 
                    }
                }else if (pago.equals("2")){
                    double saldoAntes = usuario.getSaldo();
                    usuario.pagarConSaldo(funcionEscogida.getBoleta().getPrecio();
                    if(saldoAntes != usuario.getSaldo()){
                        finalizarCompra(funcionEscogida, sala, peliculaParaVer, cineElegido);
                    }
                    else{
                        System.out.println("No se pudo llevar a cabo la compra con su saldo");
                    }
                }

            }else{
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