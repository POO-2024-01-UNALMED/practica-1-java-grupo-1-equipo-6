package uiMain;
import gestorAplicacion.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Interfaz{
    
    static Cliente usuario = new Cliente("Juan Manuel",200000,123);

    static Maquina arcade1 = new Maquina("Arcade1","Arcade",10,20);
    static Maquina arcade2 = new Maquina("Arcade2","Arcade",10,20);
    static Maquina danceDance1 = new Maquina("Dance Dance1","Dance Dance",12,20);
    static Maquina mesaDeDiscos1 = new Maquina("Mesa de discos1","Mesa de discos",12,20);
    static Maquina mesaDeDiscos2 = new Maquina("Mesa de discos2","Mesa de discos",12,20);
    static Maquina boxing1 = new Maquina("Boxing1","Boxing",8,20);
    static Maquina basket1 = new Maquina("Basket1","Basket",11,20);

    // Zonas de juegos
    static ZonaDeJuegos zona1 = new ZonaDeJuegos("Zona 1","08:00 AM - 07:00 PM");
    static ZonaDeJuegos zona2 = new ZonaDeJuegos("Zona 2","09:00 AM - 08:00 PM");
    static ZonaDeJuegos zona3 = new ZonaDeJuegos("Zona 3","08:00 AM - 08:00 PM");
    static ZonaDeJuegos zona4 = new ZonaDeJuegos("Zona 4","10:00 AM - 07:00 PM");

    static Bodega bodega = new Bodega("Bodega Central", 100);

    static Pelicula pelicula1 = new Pelicula("Intensamente", "Infantil", LocalTime.of(1, 35));
    static Pelicula pelicula2 = new Pelicula("Spiderman", "Acción", LocalTime.of(2, 10));
    static Pelicula pelicula3 = new Pelicula("Jason Vorhees", "Terror", LocalTime.of(1, 45));
    static Pelicula pelicula4 = new Pelicula("Deadpool", "+18", LocalTime.of(1, 50));
    static Pelicula pelicula5 = new Pelicula("Oppenheimer", "Drama", LocalTime.of(3, 0));
    static Pelicula pelicula6 = new Pelicula("Los Minions", "Infantil", LocalTime.of(1, 30));
    static Pelicula pelicula7 = new Pelicula("Toy Story", "Infantil", LocalTime.of(1, 40));
    static Pelicula pelicula8 = new Pelicula("El Conjuro", "Terror", LocalTime.of(1, 52));
    static Pelicula pelicula9 = new Pelicula("Inception", "Acción", LocalTime.of(2, 28));
    
    static Sala sala1 = new Sala(1, 6, 5);  // Sala 1, 6 filas y 5 columnas
    static Sala sala2 = new Sala(2, 8, 6);  // Sala 2, 8 filas y 6 columnas
    static Sala sala3 = new Sala(3, 10, 8); // Sala 3, 10 filas y 8 columnas
    static Sala sala4 = new Sala(4, 7, 6);  // Sala 4, 7 filas y 6 columnas
    static Sala sala5 = new Sala(5, 9, 7);  // Sala 5, 9 filas y 7 columnas
    static Sala sala6 = new Sala(6, 5, 5);  // Sala 6, 5 filas y 5 columnas
    static Sala sala7 = new Sala(7, 8, 5);  // Sala 7, 8 filas y 5 columnas
    static Sala sala8 = new Sala(8, 10, 10); // Sala 8, 10 filas y 10 columnas
    static Sala sala9 = new Sala(9, 7, 8);  // Sala 9, 7 filas y 8 columnas
    static Sala sala10 = new Sala(10, 9, 8); // Sala 10, 9 filas y 8 columnas
    static Sala sala11 = new Sala(11, 6, 6); // Sala 11, 6 filas y 6 columnas
    static Sala sala12 = new Sala(12, 8, 7); // Sala 12, 8 filas y 7 columnas
    static Sala sala13 = new Sala(13, 10, 10); // Sala 13, 10 filas y 10 columnas
    static Sala sala14 = new Sala(14, 7, 7); // Sala 14, 7 filas y 7 columnas
    static Sala sala15 = new Sala(15, 9, 9); // Sala 15, 9 filas y 9 columnas
    static Sala sala16 = new Sala(16, 10, 8); // Sala 16, 10 filas y 8 columnas
    static Sala sala17 = new Sala(17, 8, 6); // Sala 17, 8 filas y 6 columnas
    static Sala sala18 = new Sala(18, 5, 5); // Sala 18, 5 filas y 5 columnas
    static Sala sala19 = new Sala(19, 7, 6); // Sala 19, 7 filas y 6 columnas
    static Sala sala20 = new Sala(20, 8, 8); // Sala 20, 8 filas y 8 columnas
    static Sala sala21 = new Sala(21, 6, 6); // Sala 21, 6 filas y 6 columnas
    static Sala sala22 = new Sala(22, 8, 7); // Sala 22, 8 filas y 7 columnas
    static Sala sala23 = new Sala(23, 10, 9); // Sala 23, 10 filas y 9 columnas
    static Sala sala24 = new Sala(24, 9, 8); // Sala 24, 9 filas y 8 columnas
    static Sala sala25 = new Sala(25, 10, 10); // Sala 25, 10 filas y 10 columnas

     static Funcion funcion1 = new Funcion(pelicula1, "Normal", sala1, 200);
     static Funcion funcion2 = new Funcion(pelicula2, "Normal", sala2, 250);
     static Funcion funcion3 = new Funcion(pelicula3, "Normal", sala3, 300);
     static Funcion funcion4 = new Funcion(pelicula4, "Normal", sala4, 400);
     static Funcion funcion5 = new Funcion(pelicula5, "Normal", sala5, 500);
     static Funcion funcion6 = new Funcion(pelicula6, "Normal", sala6, 120);
     static Funcion funcion7 = new Funcion(pelicula7, "Normal", sala7, 220);

     // Cine 2
     static Funcion funcion8 = new Funcion(pelicula8, "Normal", sala8, 280);
     static Funcion funcion9 = new Funcion(pelicula9, "Normal", sala9, 350);
     static Funcion funcion10 = new Funcion(pelicula1, "Normal", sala10, 190);
     static Funcion funcion11 = new Funcion(pelicula3, "Normal", sala11, 270);
     static Funcion funcion12 = new Funcion(pelicula7, "Normal", sala12, 230);
     static Funcion funcion13 = new Funcion(pelicula4, "Normal", sala13, 410);

     // Cine 3
     static Funcion funcion14 = new Funcion(pelicula2, "Normal", sala14, 260);
     static Funcion funcion15 = new Funcion(pelicula5, "Normal", sala15, 500);
     static Funcion funcion16 = new Funcion(pelicula8, "Normal", sala16, 300);
     static Funcion funcion17 = new Funcion(pelicula9, "Normal", sala17, 340);
     static Funcion funcion18 = new Funcion(pelicula6, "Normal", sala18, 130);
     static Funcion funcion19 = new Funcion(pelicula7, "Normal", sala19, 200);

     // Cine 4
     static Funcion funcion20 = new Funcion(pelicula9, "Normal", sala20, 330);
     static Funcion funcion21 = new Funcion(pelicula6, "Normal", sala21, 140);
     static Funcion funcion22 = new Funcion(pelicula7, "Normal", sala22, 210);
     static Funcion funcion23 = new Funcion(pelicula3, "Normal", sala23, 300);
     static Funcion funcion24 = new Funcion(pelicula4, "Normal", sala24, 420);
     static Funcion funcion25 = new Funcion(pelicula5, "Normal", sala25, 480);


     // Crear listas de funciones para cada cine
     
     
     static Cine cine1 = new Cine("Cine A",zona1);
     static Cine cine2 = new Cine("Cine B", zona2);
     static Cine cine3 = new Cine("Cine C", zona3);
     static Cine cine4 = new Cine("Cine D",zona4);
    

    public static void limpiarConsola(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void primeraOperacion() {
        limpiarConsola();
        Scanner entrada = new Scanner(System.in);

        System.out.println("Has elegido la opcion de comprar boleta, ingresa el número del cine para ver la película");

        //Para mostrar en pantalla cada uno de los cines
        for (int i = 1; i <= cines.length; i++){
          System.out.println(i + ". " +cines[i-1].getNombre());
        }

        boolean condicion = true;
        int eleccion = 0;
        Cine cineEscogido = null;

        //En este bucle nos aseguramos de que el usuario haga una elección válida
        while(condicion){
          eleccion = entrada.nextInt();

          if(eleccion > cines.length || eleccion <= 0){
            System.out.println("Debes ingresar un número entre 1 y " + cines.length);
            continue; //Volvemos a llevar a cabo el bucle, para volver a pedir el cine.
          }
          cineEscogido = cines[eleccion - 1]; //Almacenamos el cine en una variable.
          condicion = false;
        }
        condicion = true;

        System.out.println("Elegiste " + cineEscogido.getNombre());

        System.out.println("Estas son las películas que actualmente maneja nuestro cine:");

        //Se muestran en pantalla todas las películas que están en poder del cine, para que el usuario elija.
        for(int i = 1; i<=Cine.peliculas.size() ; i++){
          System.out.println(i + ". " + Cine.peliculas.get(i - 1).getTitulo());
        }

        Pelicula peliculaElegida = null;
        System.out.println("Ingresa el número de la pelicula que deseas ver:");

        //Nuevamente en este bucle nos mantenemos hasta que la elección sea correcta.
        while(condicion){
          int pelicula = entrada.nextInt();

          if(pelicula > Cine.peliculas.size() || pelicula <= 0){
            System.out.println("Debes ingresar un número entre 1 y "+Cine.peliculas.size());
            continue; //Reiniciamos el bucle, luego de darle la indicación al usuario.
          }
        peliculaElegida = Cine.peliculas.get(pelicula - 1); //Almacenamos la película en una variable.
        condicion = false;
        }
        
        condicion = true;

        /*En este bucle while le damos la opción al usuario de que cambie el cine o la película siempre y cuando
        La película no tenga función activa en el cine.*/
        boolean primeraIteracion = true;
        while(condicion){                         //El método verifica que la película tenga por lo menos una función, en el cine que el usuario eligió.
          boolean existenciaFuncion = usuario.comprarBoleta(cineEscogido, peliculaElegida);
          if(!existenciaFuncion){
            if (primeraIteracion){
                System.out.println("En este momento no hay funciones disponibles para " + peliculaElegida.getTitulo() + " en " + cineEscogido.getNombre());
                primeraIteracion = false;
            }
            System.out.println("¿Qué quieres cambiar para hacer de nuevo la búsqueda?: \n 1. El cine\n 2. La película");
            int cambio = entrada.nextInt();
          //Se le permite al usuario cambiar su elección de cine o de película, para buscat nuevamente.  
            if(cambio == 1){
              cineEscogido = cambioCine(cineEscogido, peliculaElegida);
              continue; //Con el nuevo cine, volvemos a ejecutar el bucle.
            } else if(cambio == 2){
              peliculaElegida = cambioPelicula(peliculaElegida, cineEscogido);
              continue; //Con la nueva película, volvemos a ejecutar el bucle.
            }
              else{
                  System.out.println("Entrada no valida");
                  continue;
              }
          }
          condicion = false;
        }
        condicion = true;
        //Ahora que tenemos película y cine, se muestran todas las funciones que puede escoger el usuario.
        System.out.println("A continuación se muestran la/las funciones que puede elegir para ver " + peliculaElegida.getTitulo());
        ArrayList<Funcion> funcionesPosibles = cineEscogido.obtenerFunciones(peliculaElegida);
        for (int i = 1; i<=funcionesPosibles.size();i++){
            System.out.println(i + ". " +funcionesPosibles.get(i-1).getDia() + ", sala " +funcionesPosibles.get(i-1).getSala().getNumero() + ", a las " + funcionesPosibles.get(i-1).getHorario() + funcionesPosibles.get(i-1).getMomentoDelDia());
        }
        //Muy importante preguntarle al usuario si quiere continuar con el proceso o darlo por terminado.
        System.out.println("¿Desea hacer una reserva? \n1. Sí\n2. No. Salir.");
        int reserva;
        //Nos aseguramos que escoja correctamente, si quiere terminar, damos por finalizada la operación.
        while(condicion){
            reserva = entrada.nextInt();
            if (reserva != 1 && reserva != 2){
                System.out.println("Entrada no válida");
                continue;
            } else if (reserva == 2){
                return; //Salir
            }
            condicion = false;
        }
        condicion = true;

        Funcion funcionElegida = null;
        //Dando una respuesta positiva le preguntamos qué función quiere tomar, si solo hay una función la tomamos simplemente:
        if (funcionesPosibles.size() == 1){
            funcionElegida = funcionesPosibles.get(0);
        } else{
            System.out.println("Elija el número de la funcion a la que desea asistir: ");
            while (condicion){
                int funcion = entrada.nextInt();
                if (funcion <= 0 || funcion>funcionesPosibles.size()){
                    System.out.println("Entrada no válida");
                    continue;
                }
                funcionElegida = funcionesPosibles.get(funcion - 1);
                condicion = false;
            }
        }
        condicion = true; 

        //Ahora mostramos en pantalla todas las sillas de sala, y le decimos que elija por fila y columna el asiento:
        System.out.println("Esta es la distribución de las sillas de la sala en la función escogida:");
        System.out.println(funcionElegida.getSala().estadoSilleteria());
        System.out.println("Ingrese por fila y por columna el asiento que desea ocupar:");
        int fila = 0, columna = 0;
        //En este bucle se verifica que el asiento elegido no se encuente ocupado, de ser así, se pregunta nuevamente:
        while (condicion){
            System.out.println("Fila: ");
            fila = entrada.nextInt();
            System.out.println("Columna: ");
            columna = entrada.nextInt();
            if (funcionElegida.getSala().estaDisponible(fila -1, columna-1)){
                System.out.println("El asiento está disponible");
                condicion = false;
            } else{
                System.out.println("El asiento no está disponible, intente con otro");
                continue;
            }
        }
        condicion = true;
        int precioBoleto = funcionElegida.getPrecio(); //Precio de la entrada.
        //Ahora se continúa con el pago de la entrada, si el usuario no tiene tarjeta, directamente vamos al pago con su saldo personal.
        System.out.println("Se procede con el pago de su boleto");
        boolean tieneTarjeta = usuario.getTarjeta(); //Si tiene tarjeta o no.
        if (!tieneTarjeta){
            System.out.println("Como no tiene ninguna tarjeta a su nombre, se procede al pago con su saldo");
            boolean resultado = usuario.pagarConSaldo(precioBoleto); 
            if (resultado){
                funcionElegida.getSala().reservarSilla(fila-1, columna -1); //Marcar como ocupado el asiento.
                System.out.println("Se ha realizado exitosamente el pago.\nDetalles de la operación:\nNombre del Cliente: " + usuario.getNombre() + "\nIdentificacion: " + usuario.getIdentificacion() + "\nPelícula: " + peliculaElegida.getTitulo() + "\nSala de la proyección: " + funcionElegida.getSala().getNumero() + "\nDia: " + funcionElegida.getDia() + "\nCine: " + cineEscogido.getNombre() + "\nAsiento: fila " + fila + " y columna " + columna + "\nPrecio de la boleta: " + precioBoleto); //Detalles de la compra
                return;
            } else{
                System.out.println("No tienes suficiente dinero para comprar la boleta");
                return; //Finalizar el proceso si no hay dinero suficiente.
            }
        }
        //Hasta este punto llegamos si el usuario tiene tarjeta de membresía. Le preguntamos si quiere pagar con tarjeta o con su saldo personal. 
        while(condicion){
            System.out.println("¿Desea llevar a cabo el pago con su tarjeta?\n1. Sí\n2. No");
            int pago = entrada.nextInt();
            if(pago == 1){
                condicion = false; //Si elige con tarjeta, salimos del bucle.
            }
            else if (pago == 2){
                System.out.println("Se procede entonces con el pago desde su saldo");
                boolean resultado = usuario.pagarConSaldo(precioBoleto);
                if (resultado){
                    funcionElegida.getSala().reservarSilla(fila-1, columna -1);
                    System.out.println("Se ha realizado exitosamente el pago.\nDetalles de la operación:\nNombre del Cliente: " + usuario.getNombre() + "\nIdentificacion: " + usuario.getIdentificacion() + "\nPelícula: " + peliculaElegida.getTitulo() + "\nSala de la proyección: " + funcionElegida.getSala().getNumero()+ "\nDia: " + funcionElegida.getDia() + "\nCine: " + cineEscogido.getNombre() + "\nAsiento: fila " + fila + " y columna " + columna + "\nPrecio de la boleta: " + precioBoleto); //Detalles de la compra.
                condicion = false;
                return;
                } else{
                    System.out.println("No tienes suficiente dinero para comprar la boleta");
                    return; //Si no tiene suficiente dinero, damos por finalizada la operación.
                }
            }
            else{
                System.out.println("Entrada no válida.");
                continue;
            }
        }
        condicion = true;
        //En este bucle se va a tratar del pago con el saldo o los puntos de la tarjeta del usuario
        while (condicion){
            System.out.println("Desea pagar con:\n1. El saldo de su tarjeta\n2. Los puntos de su tarjeta");
            int pago = entrada.nextInt();
            if (pago == 1){
                if(usuario.pagarSaldoTarjeta(precioBoleto)){
                    funcionElegida.getSala().reservarSilla(fila-1, columna -1);
                    int puntosGanados = usuario.agregarPuntos(); //Si se completa el pago con el saldo de la tarjeta, se agregan los puntos correspondientes de acuerdo al plan de la tarjeta.
                    System.out.println("Has ganado " + puntosGanados + " puntos por tu compra, gracias a que tienes plan " + usuario.getTipoTarjeta() +"."); //Se le informa al usuario sobre los puntos.
                    condicion = false;
                } else{
                    System.out.println("No tiene saldo suficiente en su tarjeta. ¿Quiere pagar con los puntos de la tarjeta:\n1. Sí\n.2. Finalizar Proceso");
                    int otroPago = entrada.nextInt();
                    if (otroPago == 1){
                        if(usuario.pagarPuntosTarjeta(precioBoleto)){
                            funcionElegida.getSala().reservarSilla(fila-1, columna -1);
                            precioBoleto = funcionElegida.getPrecio()/100; //Si paga con los puntos de la tarjeta se hace la conversión de los puntos gastados.
                            condicion = false;
                        } else{
                            System.out.println("No tienes tampoco puntos suficientes en la tarjeta. Finalizando el prceso.");
                            return;
                        }
                    } else if (otroPago == 2){
                        condicion = false;
                        return;
                    } else{
                        System.out.println("Entrada no válida");
                        continue;
                    }
                }
            } else if (pago == 2){
                if (usuario.pagarPuntosTarjeta(precioBoleto)){
                    funcionElegida.getSala().reservarSilla(fila-1, columna -1);
                    precioBoleto = funcionElegida.getPrecio()/100;
                    condicion = false;
                }
                else{
                    System.out.println("No tiene suficientes puntos en su tarjeta. ¿Quiere pagar con el saldo de la tarjeta:\n1. Sí\n2. Finalizar Proceso");
                    int otroPago = entrada.nextInt();
                    if (otroPago == 1){
                        if (usuario.pagarSaldoTarjeta(precioBoleto)){
                            funcionElegida.getSala().reservarSilla(fila-1, columna -1);
                            int puntosGanados = usuario.agregarPuntos();
                            System.out.println("Has ganado " + puntosGanados + " puntos por tu compra, gracias a que tienes plan " + usuario.getTipoTarjeta());
                            condicion = false;
                        }else{
                            System.out.println("No tienes tampoco saldo suficiente. Finalizando el proceso");
                            return;
                        }
                    } else if (otroPago == 2){
                        condicion = false;
                        return;
                    } else{
                        System.out.println("Entrada no válida");
                        continue;
                    }            
                }
            }
        }
        System.out.println("Se ha realizado exitosamente el pago.\nDetalles de la operación:\nNombre del Cliente: " + usuario.getNombre() + "\nIdentificacion: " + usuario.getIdentificacion() + "\nPelícula: " + peliculaElegida.getTitulo() + "\nSala de la proyección: " + funcionElegida.getSala().getNumero() + "\nDia: " + funcionElegida.getDia() + "\nCine: " + cineEscogido.getNombre() + "\nAsiento: fila " + fila + " y columna " + columna + "\nPrecio de la boleta: " + precioBoleto); //Detalles de la compra.
    }

    public static Cine cambioCine(Cine cine, Pelicula pelicula){
        Scanner entrada = new Scanner(System.in);
        ArrayList<Cine> cinesConPelicula = new ArrayList<Cine>();
        Cine cineEscogido = null;

        /*En caso de que el usuario quiera cambiar de cine,se buscan todos los que tengan verdaderamente
        funciones para la película.*/
        for(int j = 0; j<cines.length; j++){
          if(cines[j] != cine){
            if(cines[j].hayPelicula(pelicula)){
              cinesConPelicula.add(cines[j]);
            }
          }
        }
        //Es posible que no haya ningún cine con función para la película, se lo decimos al usuario
        if(cinesConPelicula.size() == 0){
          System.out.println("En este momento, " + pelicula.getTitulo() + " no tiene ninguna función activa en ninguno de nuestros cines, lo único que puedes hacer es cambiar de película");
          return cine;
        }

        //Se muestran todas las opciones que tiene para cambiar el cine
        System.out.println("Puedes encontrar funciones para " + pelicula.getTitulo() + " en:");
        for(int i = 1; i <= cinesConPelicula.size();i++){
          System.out.println(i + ". " + cinesConPelicula.get(i - 1).getNombre());
        }

        System.out.println("\nElige el cine: ");
        //En este bucle nos aseguramos que su elección sea válida.
        boolean condicion = true;
        while(condicion){
            int decision = entrada.nextInt();
            if(decision <= 0 || decision > cinesConPelicula.size()){
                System.out.println("Entrada no válida");
                continue;
          }
            cineEscogido = cinesConPelicula.get(decision - 1);
            condicion = false;
        }
        return cineEscogido; //Retornamos el nuevo cine.
      }

    public static Pelicula cambioPelicula(Pelicula pelicula, Cine cine){
        Scanner entrada = new Scanner(System.in);
        Pelicula peliculaEscogida = null;
        //Como el usuario quiere cambiar la película, le mostramos cuáles tienen función en la semana.
        System.out.println("Estas son las películas que están incluidas en la programación semanal \n" + cine.enseñarFunciones());
        ArrayList<Pelicula> peliculasElegibles = cine.peliculasActivas(); //Obtenemos todas estas películas para mostrarlas.
        System.out.println("Elige el número de la película por la que quieres cambiar: ");
        for (int j = 1;j <= peliculasElegibles.size(); j++ ){
            System.out.println(j + ". " + peliculasElegibles.get(j - 1).getTitulo());
        }
        //Nos aseguramos que haga una elección correcta.
        boolean condicion = true;
        while(condicion){
            int eleccion = entrada.nextInt();
            if (eleccion <= 0 || eleccion > peliculasElegibles.size()){
                System.out.println("Entrada no válida");
                continue;
            }
            peliculaEscogida = peliculasElegibles.get(eleccion - 1);
            condicion = false;
        }
        return peliculaEscogida; //Retornamos la nueva película.
      }
    
    public static void crearObjetos(){
        
    	
    	sala1.setCine(cine1);
        sala2.setCine(cine2);
        sala3.setCine(cine3);
       
    
        
        
        
        zona1.agregarMaquina(arcade1);
        zona1.agregarMaquina(danceDance1);
        zona2.agregarMaquina(boxing1);
        zona3.agregarMaquina(basket1);
        zona3.agregarMaquina(mesaDeDiscos1);
        zona4.agregarMaquina(arcade2);
        zona4.agregarMaquina(mesaDeDiscos2);
        sala1.setCine(cine1);
        sala2.setCine(cine2);
        sala3.setCine(cine3);

        cine1.agregarFuncion(funcion1, cine1.getLunes());  // Infantil: "Intensamente"
        cine1.agregarFuncion(funcion6, cine1.getLunes());  // Infantil: "Los Minions"
        cine1.agregarFuncion(funcion7, cine1.getLunes());  // Infantil: "Toy Story"
        cine1.agregarFuncion(funcion2, cine1.getLunes());  // Acción: "Spiderman" (a las 8 am)

        cine1.agregarFuncion(funcion4, cine1.getMartes()); // +18: "Deadpool" (a las 8 am)
        cine1.agregarFuncion(funcion5, cine1.getMartes()); // Drama: "Oppenheimer" (a las 10 am)

        cine1.agregarFuncion(funcion3, cine1.getJueves());  // Terror: "Jason Vorhees" (a las 8 am)
        cine1.agregarFuncion(funcion8, cine1.getViernes());  // Terror: "El Conjuro" (a las 8 am)

        // Asignaciones para Cine 2
        cine2.agregarFuncion(funcion10, cine2.getLunes()); // Infantil: "Intensamente" (a las 8 am)
        cine2.agregarFuncion(funcion12, cine2.getLunes()); // Infantil: "Toy Story" (a las 10 am)
        cine2.agregarFuncion(funcion8, cine2.getLunes());  // Terror: "El Conjuro" (a las 12 pm)

        cine2.agregarFuncion(funcion11, cine2.getMartes()); // Terror: "Jason Vorhees" (a las 8 am)

        cine2.agregarFuncion(funcion9, cine2.getJueves());  // Acción: "Inception" (a las 8 am)
        cine2.agregarFuncion(funcion13, cine2.getViernes()); // +18: "Deadpool" (a las 8 am)
        cine2.agregarFuncion(funcion5, cine2.getViernes());  // Drama: "Oppenheimer" (a las 10 am)

        // Asignaciones para Cine 3
        cine3.agregarFuncion(funcion18, cine3.getLunes()); // Infantil: "Los Minions" (a las 8 am)
        cine3.agregarFuncion(funcion19, cine3.getLunes()); // Infantil: "Toy Story" (a las 10 am)

        cine3.agregarFuncion(funcion14, cine3.getMartes()); // Acción: "Spiderman" (a las 8 am)
        cine3.agregarFuncion(funcion15, cine3.getJueves()); // Drama: "Oppenheimer" (a las 8 am)
        cine3.agregarFuncion(funcion17, cine3.getViernes()); // Acción: "Inception" (a las 8 am)
        cine3.agregarFuncion(funcion16, cine3.getSabado()); // Terror: "El Conjuro" (a las 8 am)

        // Asignaciones para Cine 4
        cine4.agregarFuncion(funcion21, cine4.getLunes()); // Infantil: "Los Minions" (a las 8 am)
        cine4.agregarFuncion(funcion22, cine4.getLunes()); // Infantil: "Toy Story" (a las 10 am)

        cine4.agregarFuncion(funcion20, cine4.getMartes()); // Acción: "Spiderman" (a las 8 am)

        cine4.agregarFuncion(funcion23, cine4.getJueves()); // Terror: "Jason Vorhees" (a las 8 am)
        cine4.agregarFuncion(funcion24, cine4.getViernes()); // +18: "Deadpool" (a las 8 am)
        cine4.agregarFuncion(funcion25, cine4.getSabado()); // Drama: "Oppenheimer" (a las 8 am)
        
        

        zona1.agregarMaquina(arcade1);
        zona1.agregarMaquina(danceDance1);
        zona2.agregarMaquina(boxing1);
        zona3.agregarMaquina(basket1);
        zona3.agregarMaquina(mesaDeDiscos1);
        zona4.agregarMaquina(arcade2);
        zona4.agregarMaquina(mesaDeDiscos2);

        usuario.setTarjeta(true);
        usuario.setTipoTarjeta("Oro");
        usuario.setSaldoTarjeta(56000);
        usuario.setPuntosTarjeta(400);
        
        funcion1.getPelicula().setCalificacionPromedio(4.0);
        funcion2.getPelicula().setCalificacionPromedio(3.0);
        funcion3.getPelicula().setCalificacionPromedio(2.0);
        funcion4.getPelicula().setCalificacionPromedio(1.5);
        funcion5.getPelicula().setCalificacionPromedio(4.5);
        funcion6.getPelicula().setCalificacionPromedio(5.0);
        funcion7.getPelicula().setCalificacionPromedio(3.5);
        funcion8.getPelicula().setCalificacionPromedio(2.5);
        funcion9.getPelicula().setCalificacionPromedio(4.0);
        funcion10.getPelicula().setCalificacionPromedio(3.0);
        funcion11.getPelicula().setCalificacionPromedio(2.8);
        funcion12.getPelicula().setCalificacionPromedio(3.9);
        funcion13.getPelicula().setCalificacionPromedio(1.8);
        funcion14.getPelicula().setCalificacionPromedio(3.4);
        funcion15.getPelicula().setCalificacionPromedio(4.2);
        funcion16.getPelicula().setCalificacionPromedio(2.9);
        funcion17.getPelicula().setCalificacionPromedio(4.1);
        funcion18.getPelicula().setCalificacionPromedio(4.3);
        funcion19.getPelicula().setCalificacionPromedio(3.8);
        funcion20.getPelicula().setCalificacionPromedio(3.1);
        funcion21.getPelicula().setCalificacionPromedio(4.4);
        funcion22.getPelicula().setCalificacionPromedio(4.6);
        funcion23.getPelicula().setCalificacionPromedio(2.7);
        funcion24.getPelicula().setCalificacionPromedio(2.6);
        funcion25.getPelicula().setCalificacionPromedio(4.5);
    }

    

    public static void error(){System.out.println("Error");}









public static void gestionarZonaDeJuegos() {
	Scanner entrada = new Scanner(System.in);

	// Simulación de uso de máquinas
	for (int i = 0; i < 3; i++) {
        arcade1.usar();
        
    }
    for (int i = 0; i < 1; i++) {
        danceDance1.usar();
        
    }
    for (int i = 0; i < 2; i++) {
    	mesaDeDiscos1.usar();
        
    }
    for (int i = 0; i <1; i++) {
    	basket1.usar();
        
    }
    
    for (int i = 0; i < 1; i++) {
    	mesaDeDiscos2.usar();
        
    }
    for (int i = 0; i < 1; i++) {
    	arcade2.usar();
        
    }


	// Actualización de dinero recaudado en todas las zonas
	for (ZonaDeJuegos zona : ZonaDeJuegos.zonasDeJuegos) {
	    zona.actualizarDineroRecaudado();
	}

	// Mostrar informe de máquinas dañadas en cada zona
	System.out.println("Informe de máquinas dañadas:");
	for (ZonaDeJuegos zona : ZonaDeJuegos.zonasDeJuegos) {
	    System.out.println(zona.informeMaquinas());
	}

	// Selección de zona y máquina para reparar
	System.out.print("Seleccione el número de la zona de la máquina que desea reparar: ");
	for (int i = 0; i < ZonaDeJuegos.zonasDeJuegos.size(); i++) {
	    System.out.println((i + 1) + ". " + ZonaDeJuegos.zonasDeJuegos.get(i).getNombre());
	}
	int zonaSeleccionada = entrada.nextInt() - 1;

	ZonaDeJuegos zonaActual = ZonaDeJuegos.zonasDeJuegos.get(zonaSeleccionada);
	List<Maquina> maquinasDañadas = zonaActual.getMaquinasDañadas();
	if (maquinasDañadas.isEmpty()) {
	    System.out.println("No hay máquinas dañadas en la zona seleccionada.");
	    return;
	}

	System.out.println("Seleccione el número de la máquina que desea reparar:");
	for (int i = 0; i < maquinasDañadas.size(); i++) {
	    System.out.println((i + 1) + ". " + maquinasDañadas.get(i).getNombre());
	}
	int seleccionMaquina = entrada.nextInt() - 1;

	// Realizar reparación
	System.out.println(bodega.realizarMantenimiento(zonaActual, seleccionMaquina));

	// Recomendación de movimiento
	Maquina maquinaReparada = maquinasDañadas.get(seleccionMaquina);
	System.out.println(zonaActual.recomendarMovimiento(maquinaReparada));

	// Selección de zona de destino para mover la máquina reparada
	System.out.println("Seleccione la zona a la que desea mover la máquina:");
	for (int i = 0; i < ZonaDeJuegos.zonasDeJuegos.size(); i++) {
	    System.out.println((i + 1) + ". " + ZonaDeJuegos.zonasDeJuegos.get(i).getNombre());
	}
	int seleccionZona = entrada.nextInt() - 1;

	ZonaDeJuegos zonaDestino = ZonaDeJuegos.zonasDeJuegos.get(seleccionZona);
	if (zonaActual != zonaDestino) {
	    System.out.println(zonaActual.moverMaquina(zonaDestino, seleccionMaquina));
	} else {
	    System.out.println("La máquina permanecerá en " + zonaActual.getNombre());
	}

	// Aplicar incentivos
	System.out.println("¿Desea aplicar algún incentivo en una zona de juegos?");
	System.out.println("1. Sí");
	System.out.println("2. No");
	int opcionIncentivo = entrada.nextInt();

	if (opcionIncentivo == 1) {
	    System.out.println("Seleccione el tipo de incentivo:");
	    System.out.println("1. Rebajar el precio de una máquina");
	    System.out.println("2. Regalar un bono por el uso de una máquina");
	    int tipoIncentivo = entrada.nextInt();

	    if (tipoIncentivo == 1) {
	        List<Maquina> dosMenosVenden = Maquina.obtenerDosMaquinasMenosVenden();

	        if (dosMenosVenden.isEmpty()) {
	            System.out.println("No hay máquinas disponibles para recomendar.");
	        } else {
	            System.out.println("Recomendación de cambio de precio:");
	            for (Maquina maquina : dosMenosVenden) {
	                System.out.println(maquina);
	            }
	        }

	        System.out.println("Seleccione la zona donde aplicar la rebaja:");
	        for (int i = 0; i < ZonaDeJuegos.zonasDeJuegos.size(); i++) {
	            System.out.println((i + 1) + ". " + ZonaDeJuegos.zonasDeJuegos.get(i).getNombre());
	        }
	        int seleccionZonaRebaja = entrada.nextInt() - 1;

	        ZonaDeJuegos zonaRebaja = ZonaDeJuegos.zonasDeJuegos.get(seleccionZonaRebaja);

	        System.out.println("Seleccione la máquina para rebajar su precio:");
	        List<Maquina> maquinasEnZona = zonaRebaja.getMaquinas();
	        for (int i = 0; i < maquinasEnZona.size(); i++) {
	            System.out.println((i + 1) + ". " + maquinasEnZona.get(i).getNombre());
	        }
	        int seleccionMaquinaRebaja = entrada.nextInt() - 1;

	        Maquina maquinaRebajada = maquinasEnZona.get(seleccionMaquinaRebaja);
	        System.out.println("Introduzca el nuevo precio para la máquina " + maquinaRebajada.getNombre() + ": ");
	        double nuevoPrecio = entrada.nextDouble();
	        maquinaRebajada.setPrecioUso(nuevoPrecio);

	        System.out.println("El precio de la máquina " + maquinaRebajada.getNombre() + " ha sido rebajado a " + nuevoPrecio);

	    } else if (tipoIncentivo == 2) {
	        System.out.println("Seleccione la zona de juegos:");
	        for (int i = 0; i < ZonaDeJuegos.zonasDeJuegos.size(); i++) {
	            System.out.println((i + 1) + ". " + ZonaDeJuegos.zonasDeJuegos.get(i).getNombre());
	        }
	        int zonaSeleccionada1 = entrada.nextInt() - 1;

	        ZonaDeJuegos zona = ZonaDeJuegos.zonasDeJuegos.get(zonaSeleccionada1);

	        System.out.println("Seleccione la máquina a la que desea aplicar el bono:");
	        for (int i = 0; i < zona.getMaquinas().size(); i++) {
	            System.out.println((i + 1) + ". " + zona.getMaquinas().get(i).getNombre());
	        }
	        int maquinaSeleccionada = entrada.nextInt() - 1;

	        Maquina maquina = zona.getMaquinas().get(maquinaSeleccionada);
	        maquina.activarBono();

	        System.out.println("El bono ha sido activado para la máquina " + maquina.getNombre());
	    }
	} else {
	    System.out.println("No se aplicarán incentivos.");
	}

	// Actualización final de dinero recaudado
	for (ZonaDeJuegos zona : ZonaDeJuegos.zonasDeJuegos) {
	    zona.actualizarDineroRecaudado();
	    System.out.println("Dinero recaudado por " + zona.getNombre() + ": " + zona.getDineroRecaudado());
	}

    
}





public static void gestionarPeliculas() {
    Scanner scanner = new Scanner(System.in);

    // Paso 1: Ver las calificaciones
    System.out.println("Calificaciones de las películas en los cines:");
    for (Cine cine : Cine.cines) {
        System.out.println("Cine: " + cine.getNombre());
        List<String> calificaciones = cine.obtenerCalificacionesPeliculas();
        for (String calificacion : calificaciones) {
            System.out.println(calificacion);
        }
    }

    // Paso 2: Selección de cine y película por parte del usuario
    System.out.println("Seleccione el cine de la película que desea intercambiar:");
    for (int i = 0; i < Cine.cines.size(); i++) {
        System.out.println((i + 1) + ". " + Cine.cines.get(i).getNombre());
    }
    int cineSeleccionado = scanner.nextInt() - 1;
    Cine cineOrigen = Cine.cines.get(cineSeleccionado);

    // Mostrar películas en el cine seleccionado
    System.out.println("Seleccione la película que desea intercambiar:");
    List<Pelicula> peliculas = cineOrigen.peliculasActivas();
    for (int i = 0; i < peliculas.size(); i++) {
        System.out.println((i + 1) + ". " + peliculas.get(i).getTitulo());
    }
    int peliculaSeleccionada = scanner.nextInt() - 1;
    Pelicula peliculaAIntercambiar = peliculas.get(peliculaSeleccionada);
    
    // Paso 3: Recomendar una película para intercambio basada en la selección
    System.out.println(Pelicula.recomendarIntercambio(peliculaAIntercambiar));

    // Paso 4: Selección del nuevo cine para el intercambio
    System.out.println("Seleccione el nuevo cine (omitido el cine actual):");
    for (int i = 0; i < Cine.cines.size(); i++) {
        if (i != cineSeleccionado) {
            System.out.println((i + 1) + ". " + Cine.cines.get(i).getNombre());
        }
    }
    int nuevoCineSeleccionado = scanner.nextInt() - 1;
    if (nuevoCineSeleccionado >= cineSeleccionado) {
        nuevoCineSeleccionado++; // Ajustar el índice si el cine seleccionado es mayor
    }
    Cine nuevoCine = Cine.cines.get(nuevoCineSeleccionado);

    // Mostrar películas en el nuevo cine seleccionado
    System.out.println("Seleccione la película con la que desea intercambiar:");
    List<Pelicula> peliculasNuevoCine = nuevoCine.peliculasActivas();
    for (int i = 0; i < peliculasNuevoCine.size(); i++) {
        System.out.println((i + 1) + ". " + peliculasNuevoCine.get(i).getTitulo());
    }
    int peliculaIntercambioSeleccionada = scanner.nextInt() - 1;
    
    // Manejar la opción de no intercambiar
    if (peliculaIntercambioSeleccionada == -1) {
        System.out.println("No se realizará el intercambio.");
        return;
    }
    
    Pelicula peliculaIntercambio = peliculasNuevoCine.get(peliculaIntercambioSeleccionada);
    
    // Confirmar el intercambio
    System.out.println("¿Desea realizar el intercambio entre " + peliculaAIntercambiar.getTitulo() + " y " + peliculaIntercambio.getTitulo() + "? (1. Sí / 2. No)");
    int realizarIntercambio = scanner.nextInt();

    if (realizarIntercambio == 1 && peliculaAIntercambiar != null && peliculaIntercambio != null && !peliculaAIntercambiar.equals(peliculaIntercambio)) {
        String resultadoIntercambio = Funcion.realizarIntercambio(peliculaAIntercambiar, peliculaIntercambio);
        System.out.println(resultadoIntercambio);
    } else {
        System.out.println("No se realizó el intercambio.");
    }

    // Paso 5: Aplicar bonos o descuentos
    System.out.println("¿Desea aplicar algún incentivo para la nueva película?");
    System.out.println("1. Rebajar el precio de la entrada");
    System.out.println("2. Regalar un bono");
    System.out.println("3. No aplicar incentivos");
    int tipoIncentivo = scanner.nextInt();

    if (tipoIncentivo == 1) {
        // Aplicar rebaja en el precio de la entrada
        System.out.println("Seleccione la función para la película a la que desea aplicar el nuevo precio:");
        List<Funcion> funciones = peliculaIntercambio.getFunciones();
        for (int i = 0; i < funciones.size(); i++) {
            System.out.println((i + 1) + ". " + funciones.get(i).toString()); // Suponiendo que toString() de Funcion imprime información relevante
        }
        int funcionSeleccionada = scanner.nextInt() - 1;

        if (funcionSeleccionada >= 0 && funcionSeleccionada < funciones.size()) {
            Funcion funcion = funciones.get(funcionSeleccionada);
            System.out.println("Introduzca el nuevo precio para la entrada:");
            double nuevoPrecio = scanner.nextDouble();
            funcion.setPrecio(nuevoPrecio);
            System.out.println("El precio de entrada ha sido rebajado a " + nuevoPrecio);
        } else {
            System.out.println("Selección de función inválida.");
        }

    } else if (tipoIncentivo == 2) {
        // Aplicar bono
        System.out.println("Seleccione el cine para aplicar el bono:");
        for (int i = 0; i < Cine.cines.size(); i++) {
            System.out.println((i + 1) + ". " + Cine.cines.get(i).getNombre());
        }
        int cineSeleccionado1 = scanner.nextInt() - 1;
        if(cineSeleccionado1 < 0 || cineSeleccionado > Cine.cines.size()) {
            System.out.println("Error");
            return;
             }else if(cineSeleccionado1 > 0 && cineSeleccionado < Cine.cines.size()){
            	 Cine cine = Cine.cines.get(cineSeleccionado1);
             }
        // Seleccionar la película en la que se desea aplicar el bono
        System.out.println("Seleccione la película a la que desea aplicar el bono:");
        List<Pelicula> peliculas1 = cine.peliculasActivas();
        for (int i = 0; i < peliculas1.size(); i++) {
            System.out.println((i + 1) + ". " + peliculas1.get(i).getTitulo());
        }
        int peliculaSeleccionada1 = scanner.nextInt() - 1;
        Pelicula pelicula = peliculas1.get(peliculaSeleccionada1);

        // Activar el bono en la película seleccionada
        pelicula.activarBono();

        System.out.println("El bono ha sido activado para la película " + pelicula.getTitulo());
    } else if (tipoIncentivo == 3) {
        System.out.println("No se aplicarán incentivos.");
    } else {
        System.out.println("Opción no válida.");
    }
}


public static void comprarTarjeta() {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Hola, a continuación vas a proceder con la compra de tu Tarjeta, ingresa su número de identificación: ");
    
    // Identificamos al cliente
    int idCliente = (int) scanner.nextDouble();
    Cliente cliente = Cliente.buscarClientePorId(idCliente);
    
    if (cliente == null) {
        System.out.println("Cliente no encontrado. ¿Desea crear uno nuevo? (1) Sí / (2) No");
        int respuesta = scanner.nextInt();
        switch (respuesta) {
            case 1:
                System.out.println("Ingresa tu nombre: ");
                scanner.nextLine();  
                String nombre = scanner.nextLine();
                System.out.println("Ingresa tu saldo inicial: ");
                double saldoInicial = scanner.nextDouble();
                
                cliente = new Cliente(nombre, saldoInicial, idCliente);
                System.out.println("Cliente creado exitosamente.");
                break;
            case 2:
                return;  // Salir del método si el cliente no desea crear uno nuevo
            default:
                System.out.println("Selección inválida. Por favor, seleccione un número válido.");
                return;  // Salir del método si la selección es inválida
        }
    } else {
        if (!cliente.isTarjeta()) {  // Asumo que el método isTarjeta() verifica si el cliente ya tiene tarjeta
            System.out.println("Seleccione el cine en el que desea comprar la tarjeta: ");
            scanner.nextLine();  
            for (int i = 0; i < Cine.cines.size(); i++) {
                System.out.println((i + 1) + ". " + Cine.cines.get(i).getNombre());
            }
            int cineSeleccionado = scanner.nextInt() - 1;
            
            if (cineSeleccionado < 0 || cineSeleccionado >= Cine.cines.size()) {
                System.out.println("Error: selección inválida.");
            } else {
                Cine cine = Cine.cines.get(cineSeleccionado);
                System.out.println("El cine ha sido seleccionado correctamente... ¿Qué deseas hacer?");
                System.out.println("1) Ver tipos de tarjeta\n2) Ver precios\n3) Comprar");
                scanner.nextLine();  // Captura el salto de línea restante
                int respuesta1 = scanner.nextInt();
                switch (respuesta1) {
                    case 1:
                        scanner.nextLine();  // Captura el salto de línea restante
                        System.out.println("Seleccione qué tipo de tarjeta le interesa para saber más información");
                        System.out.println("1) Tarjeta bronce");
                        System.out.println("2) Tarjeta platino");
                        System.out.println("3) Tarjeta oro");
                        System.out.println("4) Regresar");
                        int respuestaTipo = scanner.nextInt();
                        switch (respuestaTipo) {
                            case 1:
                                System.out.println("La tarjeta bronce es la mejor opción si estás interesado en tener beneficios pero sin sobrepasarte con tus gastos.");
                                break;
                            case 2:
                                System.out.println("La tarjeta platino es la mejor opción si tu estadía en nuestras salas es muy frecuente, con un excelente precio y muchos beneficios.");
                                break;
                            case 3:
                                System.out.println("La tarjeta oro es la mejor opción si te consideras un completo amante del cine, con beneficios que no cuenta ninguna otra tarjeta.");
                                break;
                            case 4:
                                break;  // Regresa al menú anterior
                            default:
                                System.out.println("Solo puedes poner números del 1 al 4.");
                                return;  // Salir del método si la selección es inválida
                        }
                        break;
                    case 2:
                        System.out.println("Tarjeta bronce: 10.000$\nTarjeta platino: 50.000$\nTarjeta oro: 100.000$");
                        break;
                    case 3:
                        scanner.nextLine();  // Captura el salto de línea restante
                        System.out.println("¿Qué tipo de tarjeta deseas comprar?\n1) Tarjeta bronce\n2) Tarjeta platino\n3) Tarjeta oro");
                        int respuestaCompra = scanner.nextInt();
                        switch (respuestaCompra) {
                            case 1:
                                if (cine.getTarjetasVendidasBronce() < Cine.LIMITE_TARJETAS) {  // Asumo que getTarjetasVendidasBronce() devuelve el número de tarjetas bronce vendidas
                                    if (cliente.getSaldo() > Cliente.PRECIO_TARJETA_BRONCE) {  // Asumo que getSaldo() devuelve el saldo del cliente
                                        System.out.println("La compra de la Tarjeta Bronce ha sido exitosa...");
                                        cliente.setTipoTarjeta("Tarjeta Bronce");  // Asumo que setTipoTarjeta() establece el tipo de tarjeta del cliente
                                    } else {
                                        System.out.println("No tienes suficiente dinero para la compra.");
                                    }
                                } else {
                                    System.out.println("Ya no hay tarjetas bronce disponibles en este cine.");
                                }
                                break;
                            case 2:
                                if (cine.getTarjetasVendidasPlatino() < Cine.LIMITE_TARJETAS) {  // Asumo que getTarjetasVendidasPlatino() devuelve el número de tarjetas platino vendidas
                                    if (cliente.getSaldo() > Cliente.PRECIO_TARJETA_PLATINO) {  // Asumo que PRECIO_TARJETA_PLATINO es el precio de la tarjeta platino
                                        System.out.println("La compra de la Tarjeta Platino ha sido exitosa...");
                                        cliente.setTipoTarjeta("Tarjeta Platino");
                                    } else {
                                        System.out.println("No tienes suficiente dinero para la compra.");
                                    }
                                } else {
                                    System.out.println("Ya no hay tarjetas platino disponibles en este cine.");
                                }
                                break;
                            case 3:
                                if (cine.getTarjetasVendidasOro() < Cine.LIMITE_TARJETAS) {  
                                    if (cliente.getSaldo() > Cliente.PRECIO_TARJETA_ORO) {  
                                        System.out.println("La compra de la Tarjeta Oro ha sido exitosa...");
                                        cliente.setTipoTarjeta("Tarjeta Oro");
                                    } else {
                                        System.out.println("No tienes suficiente dinero para la compra.");
                                    }
                                } else {
                                    System.out.println("Ya no hay tarjetas oro disponibles en este cine.");
                                }
                                break;
                            default:
                                System.out.println("Selección inválida. Por favor, seleccione un número válido.");
                        }
                        break;
                    default:
                        System.out.println("Selección inválida. Por favor, seleccione un número válido.");
                }
            }
        }
    }
}






public static void comprarBoletaJuegos() {
    Scanner scanner = new Scanner(System.in);

    // Paso 1: Identificación del cliente
    System.out.print("Ingrese su número de identificación: ");
    int idCliente = (int) scanner.nextDouble();
    Cliente cliente = Cliente.buscarClientePorId(idCliente);

    if (cliente == null) {
        System.out.println("Cliente no encontrado. ¿Desea crear uno nuevo? (1)Si/(2)No");
        int respuesta = scanner.nextInt();
        switch (respuesta) {
            case 1:
                System.out.println("Ingresa tu nombre: ");
                String nombre = scanner.nextLine();  // Lee la línea completa para el nombre
                scanner.nextLine();
                System.out.println("Ingresa tu saldo inicial: ");
                double saldoInicial = scanner.nextDouble();  // Lee el saldo inicial (número)

                // Limpia el buffer de entrada para evitar problemas con nextLine()
                scanner.nextLine();
                cliente = new Cliente(nombre, saldoInicial, idCliente);
                System.out.println("Cliente creado exitosamente.");
                break;
            case 2:
                return;
            default:
                System.out.println("Selección inválida. Por favor, seleccione un número válido.");
                return; // Salir del método si la selección es inválida
        }
    }

    System.out.println("Seleccione el cine:");
    for (int i = 0; i < Cine.cines.size(); i++) {
        System.out.println((i + 1) + ". " + Cine.cines.get(i).getNombre());
    }
    int cineSeleccionadoIndex = scanner.nextInt() - 1;
    Cine cineSeleccionado = Cine.cines.get(cineSeleccionadoIndex);

    // Paso 3: Selección de la máquina
    ZonaDeJuegos zonaDeJuegosSeleccionada = cineSeleccionado.getZonaDeJuegos(); // Obtener la zona de juegos del cine
    List<Maquina> maquinasDisponibles = zonaDeJuegosSeleccionada.getMaquinas();

    System.out.println("Seleccione la máquina para comprar la boleta:");
    for (int i = 0; i < maquinasDisponibles.size(); i++) {
        Maquina maquina = maquinasDisponibles.get(i);
        System.out.println((i + 1) + ". " + maquina.getNombre() + " - Precio: " + maquina.getPrecioUso());
    }
    int maquinaSeleccionadaIndex = scanner.nextInt() - 1;
    Maquina maquinaSeleccionada = maquinasDisponibles.get(maquinaSeleccionadaIndex);

    // Verificar si la máquina requiere mantenimiento
    if (maquinaSeleccionada.necesitaMantenimiento()) {
        System.out.println("La máquina " + maquinaSeleccionada.getNombre() + " no está disponible debido a que requiere mantenimiento.");
        return;
    }

    // Paso 4: Realizar la compra
    if (cliente.getSaldo() >= maquinaSeleccionada.getPrecioUso()) {
        cliente.setSaldo(cliente.getSaldo() - maquinaSeleccionada.getPrecioUso());
        maquinaSeleccionada.usar();
        System.out.println("Compra realizada exitosamente.");

        // Paso 5: Asignar bono si está activo
        System.out.println(maquinaSeleccionada.asignarBono(cliente));

        // Paso 6: Imprimir recibo
        System.out.println("Recibo:");
        System.out.println("Cliente: " + cliente.getIdentificacion());
        System.out.println("Tipo de cliente: " + cliente.getTipo());
        System.out.println("Máquina: " + maquinaSeleccionada.getNombre());
        System.out.println("Precio pagado: " + maquinaSeleccionada.getPrecioUso());
        System.out.println("Saldo restante: " + cliente.getSaldo());
    } else {
        System.out.println("Saldo insuficiente.");
    }
}




public static void creacion() {
    boolean continuar = true;
    Scanner scanner = new Scanner(System.in); 

    while (continuar) {
        System.out.println("Menú de creación de instancias:");
        System.out.println("1. Crear Zona de Juegos");
        System.out.println("2. Crear Bodega");
        System.out.println("3. Crear Máquina");
        System.out.println("4. Crear Cliente");
        System.out.println("5. Crear Cine");
        System.out.println("6. Crear Película");
        System.out.println("7. Crear Sala");
        System.out.println("8. Crear Función");
        System.out.println("9. Salir");
        System.out.print("Selecciona una opción: ");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                System.out.print("Ingresa el nombre de la Zona de Juegos: ");
                String nombreZona = scanner.nextLine();
                System.out.print("Ingresa el horario de la Zona de Juegos: ");
                String horario= scanner.nextLine();
                ZonaDeJuegos zona = new ZonaDeJuegos(nombreZona,horario);
                System.out.println("Zona de Juegos creada: " + zona);
                System.out.println("¿Desea hacer otra creacion? 1.Si|2.No");
                int respuesta=scanner.nextInt();
                if(respuesta==2) {
                	continuar=false;
                }
                else if(respuesta>2&&respuesta<1) {
                	error();
                }
                break;

            case 2:
                System.out.print("Ingresa el nombre de la Bodega: ");
                String nombreBodega = scanner.nextLine();
                System.out.print("Ingrese la cantidad inicial de materiales ");
                int materiales = scanner.nextInt();
                Bodega bodega = new Bodega(nombreBodega,materiales);
                System.out.println("Bodega creada: " + bodega);
                System.out.println("¿Desea hacer otra creacion? 1.Si|2.No");
                int respuesta2=scanner.nextInt();
                if(respuesta2==2) {
                	continuar=false;
                }
                else if(respuesta2>2&&respuesta2<1) {
                	error();
                }
                break;

            case 3:
            	System.out.print("Ingresa el nombre de la Máquina: ");
                String nombre = scanner.nextLine();
            	System.out.println("Ingresa el tipo de la Máquina");
            	System.out.println("1.Arcade");
            	System.out.println("2.Dance Dance");
            	System.out.println("3.Mesa de discos");
            	System.out.println("4.Boxing");
            	System.out.println("5.Basket");
                int tipoMaquina = scanner.nextInt();
                String tipo;
                switch (tipoMaquina) {
                case 1:
                    tipo="Arcade";
                    break;
                case 2:
                	tipo = "Dance Dance";
                    break;
                case 3:
                	tipo="Mesa de discos";
                    break;
                case 4:
                	tipo="Boxing";
                    break;
                case 5:
                	tipo="Basket";
                    break;
                default:
                    error();
                    return; // Salir del método si la selección es inválida
            }
                
                System.out.print("Ingresa la cantidad de materiales necesarios para la Máquina: ");
                int materialesNecesarios = scanner.nextInt();
                System.out.print("Ingresa el precio de la Máquina: ");
                double precioMaquina = scanner.nextDouble();
                Maquina maquina = new Maquina(nombre,tipo,materialesNecesarios, precioMaquina);
                System.out.println("Máquina creada: " + maquina);
                System.out.println("¿Desea hacer otra creacion? 1.Si|2.No");
                int respuesta3=scanner.nextInt();
                if(respuesta3==2) {
                	continuar=false;
                }
                else if(respuesta3>2&&respuesta3<1) {
                	error();
                }
                break;

            case 4:
                System.out.print("Ingresa el nombre del Cliente: ");
                String nombreCliente = scanner.nextLine();
                System.out.print("Ingresa el saldo inicial del Cliente: ");
                double saldo = scanner.nextDouble();
                System.out.print("Ingresa el numero de identificacion del Cliente: ");
                int id = scanner.nextInt();
                Cliente cliente = new Cliente(nombreCliente,saldo,id);
                System.out.println("Cliente creado: " + cliente);
                System.out.println("¿Desea hacer otra creacion? 1.Si|2.No");
                int respuesta4=scanner.nextInt();
                if(respuesta4==2) {
                	continuar=false;
                }
                else if(respuesta4>2&&respuesta4<1) {
                	error();
                }
                break;

            case 5:
                System.out.print("Ingresa el nombre del Cine: ");
                String nombreCine = scanner.nextLine();
                Cine cine = new Cine(nombreCine);
                System.out.print("Cine creado: ");
                System.out.println(cine);
                System.out.println("¿Desea hacer otra creacion? 1.Si|2.No");
                int respuesta5=scanner.nextInt();
                if(respuesta5==2) {
                	continuar=false;
                }
                else if(respuesta5>2&&respuesta5<1) {
                	error();
                }
                break;

            case 6:
            	System.out.print("Ingresa el título de la Película: ");
            	String tituloPelicula = scanner.nextLine();

            	System.out.println("Ingresa el género de la Película: ");
            	System.out.println("1. Acción");
            	System.out.println("2. Infantil");
            	System.out.println("3. Terror");
            	System.out.println("4. +18");
            	System.out.println("5. Drama");
            	int generoPelicula = scanner.nextInt();
            	scanner.nextLine(); // Limpiar el buffer

            	String genero;
            	switch (generoPelicula) {
            	    case 1:
            	        genero = "Acción";
            	        break;
            	    case 2:
            	        genero = "Infantil";
            	        break;
            	    case 3:
            	        genero = "Terror";
            	        break;
            	    case 4:
            	        genero = "+18";
            	        break;
            	    case 5:
            	        genero = "Drama";
            	        break;
            	    default:
            	        error();
            	        return; // Salir del método si la selección es inválida
            	}

            	// Solicitar la duración de la película
            	System.out.print("Ingresa la duración de la Película (en horas y minutos, formato HH:MM): ");
            	String duracionInput = scanner.nextLine();
            	LocalTime duracion;
            	try {
            	    duracion = LocalTime.parse(duracionInput);
            	} catch (DateTimeParseException e) {
            	    System.out.println("Formato de tiempo inválido. Usa el formato HH:MM.");
            	    return; // Salir del método si el formato de la duración es inválido
            	}

            	// Crear la película con el título, género y duración
            	Pelicula nuevaPelicula = new Pelicula(tituloPelicula, genero, duracion);
            	System.out.println("Película creada exitosamente: " + nuevaPelicula.getTitulo() + ", Género: " + nuevaPelicula.getGenero() + ", Duración: " + nuevaPelicula.getDuracion());                    
                System.out.println("¿Desea hacer otra creacion? 1.Si|2.No");
                int respuesta6=scanner.nextInt();
                if(respuesta6==2) {
                	continuar=false;
                }
                else if(respuesta6>2&&respuesta6<1) {
                	error();
                }
                break;

            case 7:
                System.out.print("Ingresa el número de la Sala: ");
                int numeroSala = scanner.nextInt();
                System.out.print("Ingresa el número de filas de la Sala: ");
                int filas = scanner.nextInt();
                System.out.print("Ingresa el número de columnas de la Sala: ");
                int columnas = scanner.nextInt();
                Sala sala = new Sala(numeroSala,filas,columnas);
                System.out.println("Sala creada: " + sala);
                System.out.println("¿Desea hacer otra creacion? 1.Si|2.No");
                int respuesta7=scanner.nextInt();
                if(respuesta7==2) {
                	continuar=false;
                }
                else if(respuesta7>2&&respuesta7<1) {
                	error();
                }
                break;

            case 8:
            	System.out.println("Ingresa el tipo de Función:");
                System.out.println("1. Normal");
                System.out.println("2. VIP");

                int eleccionTipo = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                String tipoFuncion;
                switch (eleccionTipo) {
                    case 1:
                        tipoFuncion = "Normal";
                        break;
                    case 2:
                        tipoFuncion = "VIP";
                        break;
                    default:
                        System.out.println("Selección inválida. Operación cancelada.");
                        return;  // Salir del método si la selección es inválida
                }

                // Crear la función con el tipo seleccionado
                Funcion funcion = new Funcion(tipoFuncion);
                System.out.println("Función creada: " + funcion);

                // Verificar si se desea crear otra función
                System.out.println("¿Desea hacer otra creación? 1. Sí | 2. No");
                int respuesta1 = scanner.nextInt();
                scanner.nextLine();  // Limpiar el buffer

                if (respuesta1 == 2) {
                    System.out.println("Creación finalizada.");
                } else if (respuesta1 < 1 || respuesta1 > 2) {
                    System.out.println("Selección inválida.");
                }
            case 9:
                continuar = false;
                System.out.println("Saliendo del menú de creación.");
                break;

            default:
                error();
                break;
        }
    }
}


public static void asignacion() {
    boolean continuar = true;
    Scanner scanner = new Scanner(System.in);

    while (continuar) {
        System.out.println("Menú de Asignaciones:");
        System.out.println("1. Asignar una zona de juegos a un cine");
        System.out.println("2. Agregar una función a un cine");
        System.out.println("3. Agregar una máquina a una zona de juegos");
        System.out.println("4. Asignar una película a una función");
        System.out.println("5. Asignar una sala a una función");
        System.out.println("6. Salir");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1:
                // Asignar una zona de juegos a un cine
                if (ZonaDeJuegos.zonasDeJuegos.isEmpty()) {
                    System.out.println("No hay zonas de juegos disponibles.");
                    break;
                }
                if (Cine.cines.isEmpty()) {
                    System.out.println("No hay cines disponibles.");
                    break;
                }

                System.out.println("Selecciona la zona de juegos a asignar:");
                for (int i = 0; i < ZonaDeJuegos.zonasDeJuegos.size(); i++) {
                    System.out.println(i + ". " + ZonaDeJuegos.zonasDeJuegos.get(i).getNombre());
                }
                int zonaSeleccionada = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Selecciona el cine al que deseas asignar la zona de juegos:");
                for (int i = 0; i < Cine.cines.size(); i++) {
                    System.out.println(i + ". " + Cine.cines.get(i).getNombre());
                }
                int cineSeleccionado = scanner.nextInt();
                scanner.nextLine();

                Cine.cines.get(cineSeleccionado).setZonaDeJuegos(ZonaDeJuegos.zonasDeJuegos.get(zonaSeleccionada));
                ZonaDeJuegos.zonasDeJuegos.get(zonaSeleccionada).setCine(Cine.cines.get(cineSeleccionado));
                System.out.println("Zona de juegos asignada correctamente al cine " + Cine.cines.get(cineSeleccionado).getNombre());
                break;

            case 2:
                // Reemplazar una función en un cine
                if (Funcion.allFunciones.isEmpty()) {
                    System.out.println("No hay funciones disponibles.");
                    break;
                }
                if (Cine.cines.isEmpty()) {
                    System.out.println("No hay cines disponibles.");
                    break;
                }

                // Seleccionar la función que se desea agregar
                System.out.println("Selecciona la función para reemplazar en un cine:");
                for (int i = 0; i < Funcion.allFunciones.size(); i++) {
                    Funcion funcion = Funcion.allFunciones.get(i);
                    if (funcion.getPelicula() != null) {
                        System.out.println(i + ". " + funcion.getPelicula().getTitulo() + "  " + funcion.getHoraInicio() + "  " + funcion.getTipo());
                    } else {
                        System.out.println(i + ". Función sin película asignada  " + funcion.getHoraInicio() + "  " + funcion.getTipo());
                    }
                }
                int funcionSeleccionada = scanner.nextInt();
                scanner.nextLine();

                // Seleccionar el cine
                System.out.println("Selecciona el cine donde deseas reemplazar la función:");
                for (int i = 0; i < Cine.cines.size(); i++) {
                    System.out.println(i + ". " + Cine.cines.get(i).getNombre());
                }
                int cineSeleccionado1 = scanner.nextInt();
                scanner.nextLine();

                // Seleccionar el día de la semana
                System.out.println("Selecciona el día de la semana para reemplazar la función:");
                System.out.println("1. Lunes");
                System.out.println("2. Martes");
                System.out.println("3. Jueves");
                System.out.println("4. Viernes");
                System.out.println("5. Sábado");
                int diaSeleccionado = scanner.nextInt();
                scanner.nextLine();

                Funcion[] diaSeleccionadoLista = null;
                switch (diaSeleccionado) {
                    case 1:
                        diaSeleccionadoLista = Cine.cines.get(cineSeleccionado1).getLunes();
                        break;
                    case 2:
                        diaSeleccionadoLista = Cine.cines.get(cineSeleccionado1).getMartes();
                        break;
                    case 3:
                        diaSeleccionadoLista = Cine.cines.get(cineSeleccionado1).getJueves();
                        break;
                    case 4:
                        diaSeleccionadoLista = Cine.cines.get(cineSeleccionado1).getViernes();
                        break;
                    case 5:
                        diaSeleccionadoLista = Cine.cines.get(cineSeleccionado1).getSabado();
                        break;
                    default:
                        System.out.println("Día inválido.");
                        break;
                }

                if (diaSeleccionadoLista != null) {
                    // Mostrar las funciones actuales en ese día
                    System.out.println("Selecciona la posición de la función que deseas reemplazar:");
                    for (int i = 0; i < diaSeleccionadoLista.length; i++) {
                        if (diaSeleccionadoLista[i] != null && diaSeleccionadoLista[i].getPelicula() != null) {
                            System.out.println(i + ". " + diaSeleccionadoLista[i].getPelicula().getTitulo() + "  " + diaSeleccionadoLista[i].getHoraInicio());
                        } else {
                            System.out.println(i + ". Función vacía");
                        }
                    }

                    int posicionSeleccionada = scanner.nextInt();
                    scanner.nextLine();

                    // Reemplazar la función en la posición seleccionada
                    if (posicionSeleccionada >= 0 && posicionSeleccionada < diaSeleccionadoLista.length) {
                        diaSeleccionadoLista[posicionSeleccionada] = Funcion.allFunciones.get(funcionSeleccionada);
                        System.out.println("Función reemplazada correctamente en el cine " + Cine.cines.get(cineSeleccionado1).getNombre() + " en el día seleccionado.");
                    } else {
                        System.out.println("Posición inválida.");
                    }
                }
                break;
            case 3:
                // Agregar una máquina a una zona de juegos
                if (Maquina.allMaquinas.isEmpty()) {
                    System.out.println("No hay máquinas disponibles.");
                    break;
                }
                if (ZonaDeJuegos.zonasDeJuegos.isEmpty()) {
                    System.out.println("No hay zonas de juegos disponibles.");
                    break;
                }

                System.out.println("Selecciona la máquina a agregar:");
                for (int i = 0; i < Maquina.allMaquinas.size(); i++) {
                    System.out.println(i + ". " + Maquina.allMaquinas.get(i).getNombre());
                }
                int maquinaSeleccionada = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Selecciona la zona de juegos a la que deseas agregar la máquina:");
                for (int i = 0; i < ZonaDeJuegos.zonasDeJuegos.size(); i++) {
                    System.out.println(i + ". " + ZonaDeJuegos.zonasDeJuegos.get(i).getNombre());
                }
                zonaSeleccionada = scanner.nextInt();
                scanner.nextLine();

                ZonaDeJuegos.zonasDeJuegos.get(zonaSeleccionada).getMaquinas().add(Maquina.allMaquinas.get(maquinaSeleccionada));
                System.out.println("Máquina agregada correctamente a la zona de juegos " + ZonaDeJuegos.zonasDeJuegos.get(zonaSeleccionada).getNombre());
                break;

            case 4:
                // Asignar una película a una función
                if (Pelicula.totalPeliculas.isEmpty()) {
                    System.out.println("No hay películas disponibles.");
                    break;
                }
                if (Funcion.allFunciones.isEmpty()) {
                    System.out.println("No hay funciones disponibles.");
                    break;
                }

                System.out.println("Selecciona la película a asignar:");
                for (int i = 0; i < Pelicula.totalPeliculas.size(); i++) {
                    System.out.println(i + ". " + Pelicula.totalPeliculas.get(i).getTitulo());
                }
                int peliculaSeleccionada = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Selecciona la función a la que deseas asignar la película:");
                for (int i = 0; i < Funcion.allFunciones.size(); i++) {
                    Funcion funcion = Funcion.allFunciones.get(i);
                    if (funcion.getPelicula() != null) {
                        System.out.println(i + ". " + funcion.getPelicula().getTitulo() + "  " + funcion.getHoraInicio() + "  " + funcion.getTipo());
                    } else {
                        System.out.println(i + ". Función sin película asignada  " + funcion.getHoraInicio() + "  " + funcion.getTipo());
                    }
                }
                int funcionSeleccionada1 = scanner.nextInt();
                scanner.nextLine();

                Funcion.allFunciones.get(funcionSeleccionada1).setPelicula(Pelicula.totalPeliculas.get(peliculaSeleccionada));
                System.out.println("Película asignada correctamente a la función.");
                break;

            case 5:
                // Asignar una sala a una función
                if (Sala.allSalas.isEmpty()) {
                    System.out.println("No hay salas disponibles.");
                    break;
                }
                if (Funcion.allFunciones.isEmpty()) {
                    System.out.println("No hay funciones disponibles.");
                    break;
                }

                System.out.println("Selecciona la sala a asignar:");
                for (int i = 0; i < Sala.allSalas.size(); i++) {
                    System.out.println(i + ". " + Sala.allSalas.get(i).getNumero());
                }
                int salaSeleccionada = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Selecciona la función a la que deseas asignar la sala:");
                for (int i = 0; i < Funcion.allFunciones.size(); i++) {
                    Funcion funcion = Funcion.allFunciones.get(i);
                    if (funcion.getSala() != null) {
                        System.out.println(i + ". " + funcion.getSala().getNumero() + "  " + funcion.getHoraInicio() + "  " + funcion.getTipo());
                    } else {
                        System.out.println(i + ". Función sin sala asignada  " + funcion.getHoraInicio() + "  " + funcion.getTipo());
                    }
                }
                int funcionSeleccionada2 = scanner.nextInt();
                scanner.nextLine();

                Funcion.allFunciones.get(funcionSeleccionada2).setSala(Sala.allSalas.get(salaSeleccionada));
                System.out.println("Sala asignada correctamente a la función.");
                break;

            case 6:
                continuar = false;
                System.out.println("Saliendo del menú de asignaciones.");
                break;

            default:
                System.out.println("Opción inválida. Inténtalo de nuevo.");
                break;
        }
    }
}





    
}

    
