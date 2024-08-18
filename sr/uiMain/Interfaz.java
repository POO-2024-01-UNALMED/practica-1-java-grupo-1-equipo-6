package uiMain;
import gestorAplicacion.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.time.LocalTime;

public class Admin{
    static Cine[] cines=new Cine[4];
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

     static Pelicula pelicula1 = new Pelicula("Intensamente","Infantil");
     static Pelicula pelicula2 = new Pelicula("Spiderman","Acción");
     static Pelicula pelicula3 = new Pelicula("Jason Vorhees","Terror");
     static Pelicula pelicula4 = new Pelicula("Deadpool","+18");
     static Pelicula pelicula5 = new Pelicula("Oppenheimer","Drama");
     static Pelicula pelicula6 = new Pelicula("Los Minions","Infantil");
     static Pelicula pelicula7 = new Pelicula("Barbie","Adolescentes");

     static Sala sala1 = new Sala(1,6,5);
     static Sala sala2 = new Sala(2,6,5);
     static Sala sala3 = new Sala(3,6, 5);

    static LocalTime hora1 = LocalTime.of(4, 0);
    static LocalTime hora2 = LocalTime.of(8, 0);
    static LocalTime hora3 = LocalTime.of(6, 0);
    static LocalTime hora4 = LocalTime.of(2, 0);



    static Funcion funcion1 = new Funcion(pelicula1, hora4, "Normal", sala1, 40000);
    static Funcion funcion2 = new Funcion(pelicula2, hora3, "Normal", sala2, 30000);
    static Funcion funcion3 = new Funcion(pelicula3, hora2, "Normal", sala3, 25000);
    static Funcion funcion4 = new Funcion(pelicula4, hora2,"Normal" , sala3, 50000);
    static Funcion funcion5 = new Funcion(pelicula5, hora3, "Normal", sala3, 35000);
    static Funcion funcion6 = new Funcion(pelicula6, hora1, "Normal", sala3, 20000);

    static ArrayList<Funcion> funcionesCine1 = new ArrayList<Funcion>();
    static ArrayList<Funcion> funcionesCine2 = new ArrayList<Funcion>();
    static ArrayList<Funcion> funcionesCine3 = new ArrayList<Funcion>();
    static ArrayList<Funcion> funcionesCine4 = new ArrayList<Funcion>();

    static Cine cine1 = new Cine("Cinetica Medellín",funcionesCine1,funcionesCine1,funcionesCine1, funcionesCine1, funcionesCine1, zona1);
    static Cine cine2 = new Cine("Cinetica Bogota", funcionesCine2,funcionesCine1, funcionesCine3, funcionesCine4, funcionesCine2, zona2);
    static Cine cine3 = new Cine("Cinetica Cali", funcionesCine3,funcionesCine2, funcionesCine3, funcionesCine2, funcionesCine1,zona3);
    static Cine cine4 = new Cine("Cinetica Pereira", funcionesCine4,funcionesCine2, funcionesCine1, funcionesCine2, funcionesCine2,zona4);

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
              cineEscogido = Admin.cambioCine(cineEscogido, peliculaElegida);
              continue; //Con el nuevo cine, volvemos a ejecutar el bucle.
            } else if(cambio == 2){
              peliculaElegida = Admin.cambioPelicula(peliculaElegida, cineEscogido);
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


        funcionesCine3.add(funcion4);
        funcionesCine3.add(funcion5);
        funcionesCine3.add(funcion6);
        funcionesCine1.add(funcion1);
        funcionesCine2.add(funcion2);
        funcionesCine3.add(funcion3);
        funcionesCine4.add(funcion3);
        funcionesCine4.add(funcion6);

        cines[0] = cine1;
        cines[1] = cine2;
        cines[2] = cine3;
        cines[3] = cine4;
        cine1.ajustarFunciones();
        cine2.ajustarFunciones();
        cine3.ajustarFunciones();
        cine4.ajustarFunciones();

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
    }

    public static void limpiarConsola(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    public static void error(){System.out.println("Error");}


}