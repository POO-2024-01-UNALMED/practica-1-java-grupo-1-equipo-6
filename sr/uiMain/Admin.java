package uiMain;
import gestorAplicacion.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Admin{
    static Cine[] cines=new Cine[3];
    static Cliente usuario = new Cliente("Juan Manuel",200000);

    //Para probar la funcionalidad
    static Pelicula pelicula1 = new Pelicula("Intensamente","Infantil");
    static Pelicula pelicula2 = new Pelicula("Spiderman","Acción");
    static Pelicula pelicula3 = new Pelicula("Jason Vorhees","Terror");
    static Pelicula pelicula4 = new Pelicula("Deadpool","+18");
    static Pelicula pelicula5 = new Pelicula("Oppenheimer","Drama");
    static Pelicula pelicula6 = new Pelicula("Los Minions","Infantil");
    static Sala sala1 = new Sala(1,6,5);
    static Sala sala2 = new Sala(2,6,5);
    static Sala sala3 = new Sala(3,6, 5);
    static Funcion funcion1 = new Funcion(pelicula1, "4:00pm", 3, sala1);
    static Funcion funcion2 = new Funcion(pelicula2, "6:00pm", 5, sala2);
    static Funcion funcion3 = new Funcion(pelicula3, "8:00pm", 2, sala3);
    static Funcion funcion4 = new Funcion(pelicula4, "8:00pm", 2, sala3);
    static Funcion funcion5 = new Funcion(pelicula5, "7:00pm", 2, sala3);
    static Funcion funcion6 = new Funcion(pelicula6, "2:00pm", 2, sala3);

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
        Scanner entrada = new Scanner(System.in);

        funcionesCine3.add(funcion4);
        funcionesCine3.add(funcion5);
        funcionesCine3.add(funcion6);
        funcionesCine1.add(funcion1);
        funcionesCine2.add(funcion2);
        funcionesCine3.add(funcion3);
        cines[0] = cine1;
        cines[1] = cine2;
        cines[2] = cine3;

        cine1.agregarPeliculas();
        cine2.agregarPeliculas();
        cine3.agregarPeliculas();

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
            System.out.println("Por favor elija la operación que desea hacer");



            opcion = entrada.nextInt();

            switch(opcion){

                case 1:
                   primeraOperacion();
                    break;

                default:
                    System.out.println("El número ingresado debe estar entre 1 y 6");

                case 6:
                  System.out.println("Hasta la proxima");
                  System.exit(0);
                  break;
            }
        }


    }
    public static void error(){System.out.println("Error");}

    public static void limpiarConsola(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static Pelicula elegirPelicula(){
        Scanner entrada = new Scanner(System.in); Pelicula peliculaElegida = null;
        boolean condicion = true;ArrayList<Pelicula> peliculasEncontradas = null;

        while (condicion){
            //1. Preguntar por el nombre de la película
            System.out.print("Nombre de la película: ");
            String titulo = entrada.nextLine();

            peliculasEncontradas = Cine.buscarPeliculaPorNombre(titulo);
            
            //Informar si no hay resultados, y dar la opción de buscar nuevamente o salir
            if(peliculasEncontradas.size() == 0){
                System.out.print("No se encontró ningún resultado de película. ¿Desea realizar otra búsqueda(1) ó salir(0)?");
                String decision = entrada.nextLine();
                if(decision.equals("1")){
                    limpiarConsola();
                    continue;
                }else if(decision.equals("0")){
                    return null;
                }
            }else{
                break;
            }
        }
        System.out.println("Estos son algunos resultados coincidentes:");
        for (int i = 0; i < peliculasEncontradas.size(); i++) {
            System.out.println((i + 1) +". " + peliculasEncontradas.get(i).getTitulo());
        }
        System.out.println("");
        while(condicion){
            System.out.println("Selecciona la película con su número ó ingresa 0 para salir:");
            int decision = entrada.nextInt();

            if (decision>=1 && decision <= peliculasEncontradas.size()){
                peliculaElegida = peliculasEncontradas.get(decision-1);
                break;
            }
            else if(decision == 0){
                break;
            }
            else{
                System.out.println("Opción no valida");
                System.out.println("");
            }
        }

        if(peliculasEncontradas.size() == 0){
            System.out.print("No se encontró ningún resultado de película. ¿Desea realizar otra búsqueda(1) ó salir(0)?");
            String decision = entrada.nextLine();
            if(decision.equals("1")){
                limpiarConsola();
                elegirPelicula();
                return null;
            }else if(decision.equals("0")){
                return null;
            }
        }
        limpiarConsola();
        return peliculaElegida;
    }

    public static void primeraOperacion() {
        limpiarConsola();
        String peliculaDeseada; 
        Pelicula peliculaParaVer = null;
        Cine cineElegido = null;
        ArrayList<Funcion> funcionesPelicula = new ArrayList<>();

        peliculaParaVer = elegirPelicula();
        if (peliculaParaVer == null){
            limpiarConsola(); 
            return;
        }
        cineElegido = elegirCine(peliculaParaVer);
        if (cineElegido == null){
            limpiarConsola();
            return;
        }
        System.out.println(peliculaParaVer.getTitulo());
        System.out.println(cineElegido.getNombre());

    }

    public static Cine elegirCine(Pelicula pelicula){
        boolean condicion = true; Cine cineElegido=null; Scanner entrada = new Scanner(System.in);
        while(condicion){
            System.out.println("Seleccione el cine donde desea ver la película:");
            for (int i = 0; i < cines.length; i++) {
                System.out.println((i + 1) + ". " + cines[i].getNombre());
            }
            int cine = entrada.nextInt();
            if (cine >= 1 && cine <= cines.length) {
                cineElegido = cines[cine- 1];
            } else {
                System.out.println("Opción de cine no válida.");
                limpiarConsola();
                continue;
            }
            if (cineElegido.obtenerFunciones(pelicula).size() == 0){
                limpiarConsola();
                System.out.println(cineElegido.getNombre() + " No tiene funciones activas para la película " + pelicula.getTitulo() + ". Sin embargo, estas son las películas que se presentarán en el cine: ");
                System.out.println("");
                System.out.println(cineElegido.enseñarFunciones());
                System.out.println("");
                while(true){
                    System.out.println("¿Desea cambiar de cine(0) o prefiere seguir en este cine y elegir una de estas peliculas(1)?");
                    int opcion = entrada.nextInt();
                    if(opcion == 0){
                        limpiarConsola();
                        break;}
                    else if (opcion == 1){
                        ArrayList<Pelicula> opciones = cineElegido.peliculasActivas();
                        System.out.println("Elige la película: ");
                        int peliculaElegida = entrada.nextInt();
                        pelicula = opciones.get(peliculaElegida-1);
                        return cineElegido;
                    }
                    else{
                        continue;
                    }
                    
                }
                
            }else{
                break;
            }
            
            }//Hasta aquí llega el primer while
            return cineElegido;
        }
    }
     
    

    

        /*
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
        System.out.println("Se ha finalizado la compra");
        System.out.println("Detalles: ");
        System.out.println("Boleto para la película " + pelicula.getTitulo() + ", que se proyectará a las " + funcion.getHorario() + ", en la sala " + sala.getNumero() +" del cine "+ cine.getNombre()+".");

    }
*/