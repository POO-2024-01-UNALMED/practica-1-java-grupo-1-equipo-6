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

     static Sala sala1 = new Sala(1,6,5);
     static Sala sala2 = new Sala(2,6,5);
     static Sala sala3 = new Sala(3,6, 5);

     static Funcion funcion1 = new Funcion(pelicula1, LocalTime.of(16, 0), "Normal", sala1,200);
     static Funcion funcion2 = new Funcion(pelicula2, LocalTime.of(18, 0), "Normal", sala2,250);
     static Funcion funcion3 = new Funcion(pelicula3, LocalTime.of(20, 0), "Normal", sala3,300);
     static Funcion funcion4 = new Funcion(pelicula4, LocalTime.of(20, 0), "Normal", sala3,400);
     static Funcion funcion5 = new Funcion(pelicula5, LocalTime.of(19, 0), "Normal", sala3,500);
     static Funcion funcion6 = new Funcion(pelicula6, LocalTime.of(14, 0), "Normal", sala3,120);


     // Crear listas de funciones para cada cine
     static ArrayList<Funcion> lunes1 = new ArrayList<>();
     static ArrayList<Funcion> martes1 = new ArrayList<>();
     static ArrayList<Funcion> jueves1 = new ArrayList<>();
     static ArrayList<Funcion> viernes1 = new ArrayList<>();
     static ArrayList<Funcion> sabado1 = new ArrayList<>();

     static ArrayList<Funcion> lunes2 = new ArrayList<>();
     static ArrayList<Funcion> martes2 = new ArrayList<>();
     static ArrayList<Funcion> jueves2 = new ArrayList<>();
     static ArrayList<Funcion> viernes2 = new ArrayList<>();
     static ArrayList<Funcion> sabado2 = new ArrayList<>();

     static ArrayList<Funcion> lunes3 = new ArrayList<>();
     static ArrayList<Funcion> martes3 = new ArrayList<>();
     static ArrayList<Funcion> jueves3 = new ArrayList<>();
     static ArrayList<Funcion> viernes3 = new ArrayList<>();
     static ArrayList<Funcion> sabado3 = new ArrayList<>();

     static ArrayList<Funcion> lunes4 = new ArrayList<>();
     static ArrayList<Funcion> martes4 = new ArrayList<>();
     static ArrayList<Funcion> jueves4 = new ArrayList<>();
     static ArrayList<Funcion> viernes4 = new ArrayList<>();
     static ArrayList<Funcion> sabado4 = new ArrayList<>();
     
     static Cine cine1 = new Cine("Cine A", lunes1, martes1, jueves1, viernes1, sabado1, zona1);
     static Cine cine2 = new Cine("Cine B", lunes2, martes2, jueves2, viernes2, sabado2, zona2);
     static Cine cine3 = new Cine("Cine C", lunes3, martes3, jueves3, viernes3, sabado3, zona3);
     static Cine cine4 = new Cine("Cine D", lunes4, martes4, jueves4, viernes4, sabado4, zona4);
    

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
       
     // Cine 1
        lunes1.add(funcion1);
        martes1.add(funcion2);
        jueves1.add(funcion3);
        viernes1.add(funcion4);
        sabado1.add(funcion5);

        // Cine 2
        lunes2.add(funcion2);
        martes2.add(funcion3);
        jueves2.add(funcion4);
        viernes2.add(funcion5);
        sabado2.add(funcion6);

        // Cine 3
        lunes3.add(funcion3);
        martes3.add(funcion4);
        jueves3.add(funcion5);
        viernes3.add(funcion6);
        sabado3.add(funcion1);

        // Cine 4
        lunes4.add(funcion4);
        martes4.add(funcion5);
        jueves4.add(funcion6);
        viernes4.add(funcion1);
        sabado4.add(funcion2);
        
        
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
    
 // Paso 2: Selección de película para intercambio
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

    // Obtener la mejor opción de intercambio
    String peliculaRecomendada = Pelicula.recomendarIntercambio(peliculaAIntercambiar);

    // Paso 3: Realizar el intercambio
    Funcion.realizarIntercambio(peliculaAIntercambiar, peliculaRecomendada);
    System.out.println("Intercambio realizado exitosamente.");

    // Paso 4: Aplicar bonos
    System.out.println("¿Desea aplicar algún incentivo para la nueva película?");
    System.out.println("1. Rebajar el precio de la entrada");
    System.out.println("2. Regalar un bono");
    int tipoIncentivo = scanner.nextInt();

    if (tipoIncentivo == 1) {
        // Aplicar rebaja en el precio de la entrada
        System.out.println("Introduzca el nuevo precio para la entrada:");
        double nuevoPrecio = scanner.nextDouble();
        nuevaPelicula.setPrecioEntrada(nuevoPrecio);
        System.out.println("El precio de entrada ha sido rebajado a " + nuevoPrecio);
    } else if (tipoIncentivo == 2) {
        // Regalar un bono
        System.out.println("Seleccione el tipo de bono:");
        System.out.println("1. Bono para clientes Genéricos");
        System.out.println("2. Bono para clientes Preferenciales");
        System.out.println("3. Bono para clientes VIP");
        int tipoBono = scanner.nextInt();

        // Aplicar bono basado en el tipo de cliente
        nuevaPelicula.activarBono(tipoBono);
        System.out.println("El bono ha sido activado para la película " + nuevaPelicula.getTitulo());
    } else {
        System.out.println("No se aplicarán incentivos.");
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
            	 LocalTime horarioFuncion = null;
            	    boolean horarioValido = false;
            	    
            	    while (!horarioValido) {
            	        System.out.print("Ingresa la hora de la Función (formato HH:mm): ");
            	        String horarioFuncionStr = scanner.nextLine();
            	        
            	        try {
            	            horarioFuncion = LocalTime.parse(horarioFuncionStr); // Convertir a LocalTime
            	            horarioValido = true;
            	        } catch (DateTimeParseException e) {
            	            System.out.println("Formato de horario inválido. Por favor, ingrese el horario en formato HH:mm.");
            	        }
            	    }

            	    // Solicitar el tipo de función
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

            	    // Crear la función con el horario y tipo seleccionados
            	    Funcion funcion = new Funcion(horarioFuncion, tipoFuncion);
            	    System.out.println("Función creada: " + funcion);

            	    // Verificar si se desea crear otra función
            	    System.out.println("¿Desea hacer otra creación? 1. Sí | 2. No");
            	    int respuesta8 = scanner.nextInt();
            	    
            	    if (respuesta8 == 2) {
            	        System.out.println("Creación finalizada.");
            	    } else if (respuesta8 < 1 || respuesta8 > 2) {
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
                // Agregar una función a un cine
                if (Funcion.allFunciones.isEmpty()) {
                    System.out.println("No hay funciones disponibles.");
                    break;
                }
                if (Cine.cines.isEmpty()) {
                    System.out.println("No hay cines disponibles.");
                    break;
                }

                System.out.println("Selecciona la función a agregar:");
                for (int i = 0; i < Funcion.allFunciones.size(); i++) {
                    Funcion funcion = Funcion.allFunciones.get(i);
                    if (funcion.getPelicula() != null) {
                        System.out.println(i + ". " + funcion.getPelicula().getTitulo() + "  " + funcion.getHorario() + "  " + funcion.getTipo());
                    } else {
                        System.out.println(i + ". Función sin película asignada  " + funcion.getHorario() + "  " + funcion.getTipo());
                    }
                }
                int funcionSeleccionada = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Selecciona el cine al que deseas agregar la función:");
                for (int i = 0; i < Cine.cines.size(); i++) {
                    System.out.println(i + ". " + Cine.cines.get(i).getNombre());
                }
                cineSeleccionado = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Selecciona el día de la semana para agregar la función:");
                System.out.println("1. Lunes");
                System.out.println("2. Martes");
                System.out.println("3. Jueves");
                System.out.println("4. Viernes");
                System.out.println("5. Sábado");
                int diaSeleccionado = scanner.nextInt();
                scanner.nextLine();

                ArrayList<Funcion> diaSeleccionadoLista = null;
                switch (diaSeleccionado) {
                    case 1:
                        diaSeleccionadoLista = Cine.cines.get(cineSeleccionado).getLunes();
                        break;
                    case 2:
                        diaSeleccionadoLista = Cine.cines.get(cineSeleccionado).getMartes();
                        break;
                    case 3:
                        diaSeleccionadoLista = Cine.cines.get(cineSeleccionado).getJueves();
                        break;
                    case 4:
                        diaSeleccionadoLista = Cine.cines.get(cineSeleccionado).getViernes();
                        break;
                    case 5:
                        diaSeleccionadoLista = Cine.cines.get(cineSeleccionado).getSabado();
                        break;
                    default:
                        System.out.println("Día inválido.");
                        break;
                }

                if (diaSeleccionadoLista != null) {
                    diaSeleccionadoLista.add(Funcion.allFunciones.get(funcionSeleccionada));
                    System.out.println("Función agregada correctamente al cine " + Cine.cines.get(cineSeleccionado).getNombre() + " en el día seleccionado.");
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
                        System.out.println(i + ". " + funcion.getPelicula().getTitulo() + "  " + funcion.getHorario() + "  " + funcion.getTipo());
                    } else {
                        System.out.println(i + ". Función sin película asignada  " + funcion.getHorario() + "  " + funcion.getTipo());
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
                    System.out.println(i + ". Sala número: " + Sala.allSalas.get(i).getNumero());
                }
                int salaSeleccionada = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Selecciona la función a la que deseas asignar la sala:");
                for (int i = 0; i < Funcion.allFunciones.size(); i++) {
                    Funcion funcion = Funcion.allFunciones.get(i);
                    if (funcion.getPelicula() != null) {
                        System.out.println(i + ". " + funcion.getPelicula().getTitulo() + "  " + funcion.getHorario() + "  " + funcion.getTipo());
                    } else {
                        System.out.println(i + ". Función sin película asignada  " + funcion.getHorario() + "  " + funcion.getTipo());
                    }
                }
                funcionSeleccionada1 = scanner.nextInt();
                scanner.nextLine();

                Funcion.allFunciones.get(funcionSeleccionada1).setSala(Sala.allSalas.get(salaSeleccionada));
                System.out.println("Sala asignada correctamente a la función.");
                break;

            case 6:
                continuar = false;
                System.out.println("Saliendo del menú de asignaciones.");
                return;

            default:
                System.out.println("Opción inválida. Por favor, selecciona una opción válida.");
                break;
        }

        // Pregunta si el usuario desea hacer otra asignación
        if (continuar) {
            System.out.println("¿Desea hacer otra asignación? 1. Sí | 2. No");
            int respuesta = scanner.nextInt();
            if (respuesta == 2) {
                continuar = false;
            } else if (respuesta < 1 || respuesta > 2) {
                System.out.println("Opción inválida. Regresando al menú de asignaciones.");
            }
        }
    }
}
}
    
