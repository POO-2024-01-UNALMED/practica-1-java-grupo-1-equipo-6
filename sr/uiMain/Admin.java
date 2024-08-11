package uiMain;
import gestorAplicacion.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin{
    static Scanner entrada = new Scanner(System.in);
    static Cine[] cines=new Cine[3];
    static Cliente usuario = new Cliente("Juan Manuel",200000);

    //Para probar la funcionalidad
    static Pelicula pelicula1 = new Pelicula("Intensamente","Infantil");
    static Pelicula pelicula2 = new Pelicula("Spiderman","Acción");
    static Pelicula pelicula3 = new Pelicula("Jason  Vorhees","Terror");
    static Sala sala1 = new Sala(1,6,5);
    static Sala sala2 = new Sala(2,6,5);
    static Sala sala3 = new Sala(3,6, 5);
    static Funcion funcion1 = new Funcion(pelicula1, "4:00pm", 3, sala1);
    static Funcion funcion2 = new Funcion(pelicula2, "6:00pm", 5, sala2);
    static Funcion funcion3 = new Funcion(pelicula3, "8:00pm", 2, sala3);
    
    static ArrayList<Funcion> funcionesCine1 = new ArrayList<Funcion>();
    static ArrayList<Funcion> funcionesCine2 = new ArrayList<Funcion>();
    static ArrayList<Funcion> funcionesCine3 = new ArrayList<Funcion>();
    static Cine cine1 = new Cine("Star Cine Medellín",funcionesCine1);
    static Cine cine2 = new Cine("Cine Colombia Plaza", funcionesCine2);
    static Cine cine3 = new Cine("Cinemark City Mall", funcionesCine3);
    
    

    public static void main(String[] args){ 
        sala1.setCine(cine1);
        sala2.setCine(cine2);
        sala3.setCine(cine3);


        funcionesCine1.add(funcion1);
        funcionesCine2.add(funcion2);
        funcionesCine3.add(funcion3);
        cines[0] = cine1;
        cines[1] = cine2;
        cines[2] = cine3;
        
        cine1.agregarPeliculas();
        
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
                
                case 6:
                	System.out.println("Hata la proxima");
                	System.exit(0);
                	break;
            }
        }
        
        
    }
    public static void error(){System.out.println("Error");}

    public static void primeraOperacion() {
        String peliculaDeseada; 
        Pelicula peliculaParaVer = null;
        Cine cineElegido = null;
        ArrayList<Funcion> funcionesPelicula = new ArrayList<>();
        
        Scanner entrada = new Scanner(System.in);

        // 1. Preguntar el nombre de la película
        System.out.println("Por favor ingrese el nombre de la película que desea ver: ");
        peliculaDeseada = entrada.nextLine();

        ArrayList<Pelicula> peliculasEncontradas = cines[0].buscarPeliculaPorNombre(peliculaDeseada);

        if (peliculasEncontradas.size() > 0) {
            System.out.println("Estos son algunos resultados coincidentes:");
            for (int i = 0; i < peliculasEncontradas.size(); i++) {
                System.out.println((i + 1) + ". " + peliculasEncontradas.get(i).getTitulo());
            }

            System.out.println("Selecciona la película que buscas o ingresa 0 si deseas salir:");
            int eleccion = entrada.nextInt();
            entrada.nextLine(); // Consumir el salto de línea después de nextInt()

            if (eleccion != 0 && eleccion >= 1 && eleccion <= peliculasEncontradas.size()) {
                peliculaParaVer = peliculasEncontradas.get(eleccion - 1);
            } else {
                System.out.println("Opción no válida o salida seleccionada.");
                
                return;
            }
        } else {
            System.out.println("No se han encontrado resultados. ¿Desea realizar otra búsqueda?");
            return;
        }

        // 2. Preguntar por el cine al cual se desea ir
        System.out.println("Por favor seleccione el cine donde desea ver la película:");
        for (int i = 0; i < cines.length; i++) {
            System.out.println((i + 1) + ". " + cines[i].getNombre());
        }

        int cineSeleccionado = entrada.nextInt();
        entrada.nextLine(); // Consumir el salto de línea después de nextInt()

        if (cineSeleccionado >= 1 && cineSeleccionado <= cines.length) {
            cineElegido = cines[cineSeleccionado - 1];
        } else {
            System.out.println("Opción de cine no válida.");
            return;
        }

        // 3. Mostrar las funciones disponibles en el cine seleccionado
        funcionesPelicula = cineElegido.obtenerFunciones(peliculaParaVer);

        if (funcionesPelicula.size() > 0) {
            System.out.println("Estas son las funciones disponibles para esta pelicula en " + cineElegido.getNombre() + ":");
            for (int i = 0; i < funcionesPelicula.size(); i++) {
                Funcion funcion = funcionesPelicula.get(i);
                System.out.println((i + 1) + ". Sala: " + funcion.getSala().getNumero() + ", Horario: " + funcion.getHorario());
            }
        } else {
            System.out.println("No hay funciones disponibles para la película " + peliculaParaVer.getTitulo() + " en el cine seleccionado.");
            return;
        }

        // 4. Seleccionar la función
        System.out.println("Elige la funcion que desees:");
        int funcionNumero = entrada.nextInt();
        entrada.nextLine(); // Consumir el salto de línea

        if (funcionNumero <= 0 || funcionNumero > funcionesPelicula.size()) {
            System.out.println("Opción de función no válida.");
            return;
        }

        Funcion funcionEscogida = funcionesPelicula.get(funcionNumero - 1);
        Sala sala = funcionEscogida.getSala();

        // 5. Seleccionar el asiento
        System.out.println("A continuación se muestran los asientos disponibles:");
        System.out.println(sala.estadoSilleteria());

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
            sala.reservarSilla(fila - 1, columna - 1);

            // 6. Finalizar la compra
            finalizarCompra(funcionEscogida, sala, peliculaParaVer, cineElegido);
        } else {
            System.out.println("El asiento se encuentra ocupado.");
        }
    }

    public static void finalizarCompra(Funcion funcion, Sala sala, Pelicula pelicula, Cine cine){
        usuario.agregarBoleta(new Boleta(funcion, usuario, sala, pelicula));
        System.out.println("Se ha finalizado la compra");
        System.out.println("Detalles: ");
        System.out.println("Boleto para la película " + pelicula.getTitulo() + ", que se proyectará a las " + funcion.getHorario() + ", en la sala " + sala.getNumero() +" del cine "+ cine.getNombre()+".");

    }
    
}