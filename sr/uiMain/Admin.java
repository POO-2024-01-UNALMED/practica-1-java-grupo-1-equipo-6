package uiMain;
import gestorAplicacion.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class Admin{
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
    
    static Sala sala1 = new Sala(1,6,5);
    static Sala sala2 = new Sala(2,6,5);
    static Sala sala3 = new Sala(3,6, 5);
    
    static Funcion funcion1 = new Funcion(pelicula1, "4:00pm", "Normal", sala1);
    static Funcion funcion2 = new Funcion(pelicula2, "6:00pm", "Normal", sala2);
    static Funcion funcion3 = new Funcion(pelicula3, "8:00pm", "Normal", sala3);
    static Funcion funcion4 = new Funcion(pelicula4, "8:00pm","Normal" , sala3);
    static Funcion funcion5 = new Funcion(pelicula5, "7:00pm", "Normal", sala3);
    static Funcion funcion6 = new Funcion(pelicula6, "2:00pm", "Normal", sala3);

    static ArrayList<Funcion> funcionesCine1 = new ArrayList<Funcion>();
    static ArrayList<Funcion> funcionesCine2 = new ArrayList<Funcion>();
    static ArrayList<Funcion> funcionesCine3 = new ArrayList<Funcion>();
    static ArrayList<Funcion> funcionesCine4 = new ArrayList<Funcion>();
    
    static Cine cine1 = new Cine("Cinetica Medellín",funcionesCine1,zona1);
    static Cine cine2 = new Cine("Cinetica Bogota", funcionesCine2,zona2);
    static Cine cine3 = new Cine("Cinetica Cali", funcionesCine3,zona3);
    static Cine cine4 = new Cine("Cinetica Pereira", funcionesCine4,zona4);
    
   


    public static void main(String[] args){ 
        
    	 Scanner entrada = new Scanner(System.in);
    	
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
        
      

        cine1.agregarPeliculas();
        cine2.agregarPeliculas();
        cine3.agregarPeliculas();
        cine4.agregarPeliculas();
        
        zona1.agregarMaquina(arcade1);
        zona1.agregarMaquina(danceDance1);
        zona2.agregarMaquina(boxing1);
        zona3.agregarMaquina(basket1);
        zona3.agregarMaquina(mesaDeDiscos1);
        zona4.agregarMaquina(arcade2);
        zona4.agregarMaquina(mesaDeDiscos2);

        int opcion;
        boolean finalizar=false;

        while(!finalizar){
            System.out.println("-------Sistema para la compra de boletos de cine-----------");
            System.out.println("1.- Comprar boletos para un cine");
            System.out.println("2.- Gestionar Zona de Juegos");
            System.out.println("3.- Tercera operación");
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
                   primeraOperacion();
                    break;
                case 2:
                    gestionarZonaDeJuegos();
                    break;
                case 6:
                    comprarBoletaJuegos();
                    break;
                case 7:
                    creacion();
                    break;
                case 8:
                	asignacion();
                	break;

                default:
                    System.out.println("El número ingresado debe estar entre 1 y 8");

                case 9:
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

    public static void primeraOperacion() {
        limpiarConsola();
       
    }

    
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
                    System.out.println("1.Accion");
                    System.out.println("2.Infantil");
                    System.out.println("3.Terror");
                    System.out.println("4.+18");
                    System.out.println("5.Drama");
                    int generoPelicula = scanner.nextInt();
                    
                    String genero;
                    switch (generoPelicula) {
                    case 1:
                        genero="Accion";
                        break;
                    case 2:
                    	genero="Infantil";
                        break;
                    case 3:
                    	genero="Terror";
                        break;
                    case 4:
                    	genero="+18";
                        break;
                    case 5:
                    	genero="Drama";
                        break;
                    default:
                        error();
                        return; // Salir del método si la selección es inválida
                }
                    
                    Pelicula pelicula = new Pelicula(tituloPelicula, genero);
                    System.out.println("Película creada: " + pelicula);
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
                    System.out.print("Ingresa el horario de la Función: ");
                    String horarioFuncion = scanner.nextLine();
                    System.out.println("Ingresa el tipo de Función:");
                    System.out.println("1.Normal");
                    System.out.println("2.VIP");
                    int eleccionTipo = scanner.nextInt();
                    
                    String tipoFuncion;
                    switch (eleccionTipo) {
                    case 1:
                    	tipoFuncion="Normal";
                        break;
                    case 2:
                    	tipoFuncion="VIP";
                        break;
                    
                    default:
                        error();
                        return; // Salir del método si la selección es inválida
                }
                    
                    Funcion funcion = new Funcion(horarioFuncion,tipoFuncion);
                    System.out.println("Función creada: " + funcion);
                    System.out.println("¿Desea hacer otra creacion? 1.Si|2.No");
                    int respuesta8=scanner.nextInt();
                    if(respuesta8==2) {
                    	continuar=false;
                    }
                    else if(respuesta8>2&&respuesta8<1) {
                    	error();
                    }
                    break;

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

                    Cine.cines.get(cineSeleccionado).getFunciones().add(Funcion.allFunciones.get(funcionSeleccionada));
                    System.out.println("Función agregada correctamente al cine " + Cine.cines.get(cineSeleccionado).getNombre());
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
                    funcionSeleccionada = scanner.nextInt();
                    scanner.nextLine();

                    Funcion.allFunciones.get(funcionSeleccionada).setPelicula(Pelicula.totalPeliculas.get(peliculaSeleccionada));
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
                    funcionSeleccionada = scanner.nextInt();
                    scanner.nextLine();

                    Funcion.allFunciones.get(funcionSeleccionada).setSala(Sala.allSalas.get(salaSeleccionada));
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

