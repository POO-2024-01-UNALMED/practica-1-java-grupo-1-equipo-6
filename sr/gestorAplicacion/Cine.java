package gestorAplicacion;
import java.util.ArrayList;
import java.util.List;

import BaseDatos.Deserializador;
import BaseDatos.Serializador;
import uiMain.Interfaz;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Cine implements Serializable {
	
	 private static final long serialVersionUID = 2L;
	
	private String nombre;
	private Funcion[] lunes = new Funcion[7];
	private Funcion[] martes = new Funcion[7];
	private Funcion[] jueves = new Funcion[7];
	private Funcion[] viernes = new Funcion[7];
	private Funcion[] sabado = new Funcion[7];
	public static ArrayList<Pelicula> peliculas=new ArrayList<>();
	private ZonaDeJuegos zonaDeJuegos;
	public static ArrayList<Cine> cines = new ArrayList<>();
	

	public Cine(String nombre, ZonaDeJuegos zonaDeJuegos){
		this.nombre = nombre;
		this.zonaDeJuegos = zonaDeJuegos;
		if(zonaDeJuegos!=null) {
		this.zonaDeJuegos.setCine(this);
		}
		cines.add(this);
	}
	
	public Cine(String nombre){
		this(nombre,null);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Funcion[] getLunes() {
        return lunes;
    }

    // Setter para lunes
    public void setLunes(Funcion[] lunes) {
        if (lunes.length == 7) {
            this.lunes = lunes;
        } else {
            throw new IllegalArgumentException("El arreglo debe tener exactamente 7 elementos.");
        }
    }

    // Getter para martes
    public Funcion[] getMartes() {
        return martes;
    }

    // Setter para martes
    public void setMartes(Funcion[] martes) {
        if (martes.length == 7) {
            this.martes = martes;
        } else {
            throw new IllegalArgumentException("El arreglo debe tener exactamente 7 elementos.");
        }
    }

    
    public Funcion[] getJueves() {
        return jueves;
    }

   
    public void setJueves(Funcion[] jueves) {
        if (jueves.length == 7) {
            this.jueves = jueves;
        } else {
            throw new IllegalArgumentException("El arreglo debe tener exactamente 7 elementos.");
        }
    }

  
    public Funcion[] getViernes() {
        return viernes;
    }

    
    public void setViernes(Funcion[] viernes) {
        if (viernes.length == 7) {
            this.viernes = viernes;
        } else {
            throw new IllegalArgumentException("El arreglo debe tener exactamente 7 elementos.");
        }
    }

    
    public Funcion[] getSabado() {
        return sabado;
    }

    
    public void setSabado(Funcion[] sabado) {
        if (sabado.length == 7) {
            this.sabado = sabado;
        } else {
            throw new IllegalArgumentException("El arreglo debe tener exactamente 7 elementos.");
        }
    }


	
	
	public boolean hayPelicula(Pelicula pelicula) {		
		for (Funcion funcionLunes: this.lunes){
			if (funcionLunes != null){
				if(funcionLunes.getPelicula() != null){
					if (funcionLunes.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
						return true;
					}
				}
			}
		}
		for (Funcion funcionMartes: this.martes){
			if (funcionMartes != null){
				if(funcionMartes.getPelicula() != null){
					if (funcionMartes.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
						return true;
					}
				}
			}
		}
			
		for (Funcion funcionJueves: this.jueves){
			if(funcionJueves != null){
				if(funcionJueves.getPelicula() != null){
					if (funcionJueves.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
						return true;
					}
				}
			}
		}
		for (Funcion funcionViernes: this.viernes){
			if (funcionViernes != null) {
				if(funcionViernes.getPelicula() != null){
					if (funcionViernes.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
						return true;
					}
				}
			}
		}
		for (Funcion funcionSabado: this.sabado){
			if (funcionSabado != null){
				if(funcionSabado.getPelicula() != null){
					if (funcionSabado.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
						return true;
					}
				}
			}
		}
		return false;
	}

	public String enseñarFunciones() {
	    String lunes = "Lunes: \n", martes = "Martes:\n", jueves = "Jueves\n", viernes = "Viernes:\n", sabado = "Sábado:\n";
	    ArrayList<Pelicula> peliculasMostradas = new ArrayList<>();

	    // Procesar funciones del lunes
	    for (Funcion funcionLunes : this.lunes) {
	        if (funcionLunes != null && funcionLunes.getPelicula() != null) {
	            Pelicula pelicula = funcionLunes.getPelicula();
	            if (!peliculasMostradas.contains(pelicula)) {
	                lunes = lunes.concat(pelicula.getTitulo() + "\n");
	                peliculasMostradas.add(pelicula);
	            }
	        }
	    }
			if(peliculasMostradas.size() == 0){
				lunes += "No hay películas\n";
			} else{
				lunes += "\n";
				peliculasMostradas.clear();
			}
	  
	    // Procesar funciones del martes
	    for (Funcion funcionMartes : this.martes) {
	        if (funcionMartes != null && funcionMartes.getPelicula() != null) {
	            Pelicula pelicula = funcionMartes.getPelicula();
	            if (!peliculasMostradas.contains(pelicula)) {
	                martes = martes.concat(pelicula.getTitulo() + "\n");
	                peliculasMostradas.add(pelicula);
	            }
	        }
	    }
		if(peliculasMostradas.size() == 0){
			martes += "No hay películas\n";
		} else{
			martes += "\n";
			peliculasMostradas.clear();
		}

	    // Procesar funciones del jueves
	    for (Funcion funcionJueves : this.jueves) {
	        if (funcionJueves != null && funcionJueves.getPelicula() != null) {
	            Pelicula pelicula = funcionJueves.getPelicula();
	            if (!peliculasMostradas.contains(pelicula)) {
	                jueves = jueves.concat(pelicula.getTitulo() + "\n");
	                peliculasMostradas.add(pelicula);
	            }
	        }
	    }
		if(peliculasMostradas.size() == 0){
			jueves += "No hay películas\n";
		} else{
			jueves += "\n";
			peliculasMostradas.clear();
		}

	    // Procesar funciones del viernes
	    for (Funcion funcionViernes : this.viernes) {
	        if (funcionViernes != null && funcionViernes.getPelicula() != null) {
	            Pelicula pelicula = funcionViernes.getPelicula();
	            if (!peliculasMostradas.contains(pelicula)) {
	                viernes = viernes.concat(pelicula.getTitulo() + "\n");
	                peliculasMostradas.add(pelicula);
	            }
	        }
	    }
		if(peliculasMostradas.size() == 0){
			viernes += "No hay películas\n";
		} else{
			viernes += "\n";
			peliculasMostradas.clear();
		}

	    // Procesar funciones del sábado
	    for (Funcion funcionSabado : this.sabado) {
	        if (funcionSabado != null && funcionSabado.getPelicula() != null) {
	            Pelicula pelicula = funcionSabado.getPelicula();
	            if (!peliculasMostradas.contains(pelicula)) {
	                sabado = sabado.concat(pelicula.getTitulo() + "\n");
	                peliculasMostradas.add(pelicula);
	            }
	        }
	    }
		if(peliculasMostradas.size() == 0){
			sabado += "No hay películas\n";
		} else{
			sabado += "\n";
			peliculasMostradas.clear();
		}

	    return lunes + martes + jueves + viernes + sabado;
	}

	public ArrayList<Pelicula> peliculasActivas() {
	    ArrayList<Pelicula> peliculas = new ArrayList<>();

	    // Procesar funciones del lunes
	    for (Funcion funcionLunes : this.lunes) {
	        if (funcionLunes != null) {
	            Pelicula pelicula = funcionLunes.getPelicula();
	            if (pelicula != null && !peliculas.contains(pelicula)) {
	                peliculas.add(pelicula);
	            }
	        }
	    }

	    // Procesar funciones del martes
	    for (Funcion funcionMartes : this.martes) {
	        if (funcionMartes != null) {
	            Pelicula pelicula = funcionMartes.getPelicula();
	            if (pelicula != null && !peliculas.contains(pelicula)) {
	                peliculas.add(pelicula);
	            }
	        }
	    }

	    // Procesar funciones del jueves
	    for (Funcion funcionJueves : this.jueves) {
	        if (funcionJueves != null) {
	            Pelicula pelicula = funcionJueves.getPelicula();
	            if (pelicula != null && !peliculas.contains(pelicula)) {
	                peliculas.add(pelicula);
	            }
	        }
	    }

	    // Procesar funciones del viernes
	    for (Funcion funcionViernes : this.viernes) {
	        if (funcionViernes != null) {
	            Pelicula pelicula = funcionViernes.getPelicula();
	            if (pelicula != null && !peliculas.contains(pelicula)) {
	                peliculas.add(pelicula);
	            }
	        }
	    }

	    // Procesar funciones del sábado
	    for (Funcion funcionSabado : this.sabado) {
	        if (funcionSabado != null) {
	            Pelicula pelicula = funcionSabado.getPelicula();
	            if (pelicula != null && !peliculas.contains(pelicula)) {
	                peliculas.add(pelicula);
	            }
	        }
	    }

	    return peliculas;
	}


	public ArrayList<Funcion> obtenerFunciones(Pelicula pelicula){
		ArrayList<Funcion> posibilidades = new ArrayList<Funcion>();
		for( Funcion funcionLunes: this.lunes){
			if(funcionLunes != null){
				if(funcionLunes.getPelicula()!= null){
					if (funcionLunes.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionLunes.getSala().hayAsientosLibres()){
						posibilidades.add(funcionLunes);
					}
				}
			}
		}
		for( Funcion funcionMartes: this.martes){
			if (funcionMartes != null){
				if(funcionMartes.getPelicula() != null){
					if (funcionMartes.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionMartes.getSala().hayAsientosLibres()){
						posibilidades.add(funcionMartes);
					}
				}
			}
		}
		for( Funcion funcionJueves: this.jueves){
			if (funcionJueves != null){
				if(funcionJueves.getPelicula() != null){
					if (funcionJueves.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionJueves.getSala().hayAsientosLibres()){
						posibilidades.add(funcionJueves);
					}
				}		
			}
		}
		for( Funcion funcionViernes: this.viernes){
			if(funcionViernes != null){
				if(funcionViernes.getPelicula() != null){
					if (funcionViernes.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionViernes.getSala().hayAsientosLibres()){
						posibilidades.add(funcionViernes);
					}
				}
			}
		}	
		for( Funcion funcionSabado: this.sabado){
			if (funcionSabado != null){
				if(funcionSabado.getPelicula() != null){
					if (funcionSabado.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionSabado.getSala().hayAsientosLibres()){
						posibilidades.add(funcionSabado);
					}
				}
			}
		}
		return posibilidades;
	}
 	
	public void ajustarFunciones() {
		for (Funcion funcion: this.lunes){
			if (funcion != null){
				funcion.setDia("Lunes");
				funcion.definirMomentoDelDia();
			}
		}
		for (Funcion funcionMartes: this.martes){
			if (funcionMartes != null){
				funcionMartes.setDia("Martes");
				funcionMartes.definirMomentoDelDia();
			}
		}
			for (Funcion funcionJueves: this.jueves){
				if (funcionJueves != null){
					funcionJueves.setDia("Jueves");
					funcionJueves.definirMomentoDelDia();
				}
			}
				for (Funcion funcionViernes: this.viernes){
					if (funcionViernes != null){
						funcionViernes.setDia("Viernes");
						funcionViernes.definirMomentoDelDia();
					}
				}
				for (Funcion funcionSabado: this.sabado){
					if(funcionSabado != null){
						funcionSabado.setDia("Sábado");
						funcionSabado.definirMomentoDelDia();
					}
				}
	}
	
	
	
	public List<String> obtenerCalificacionesPeliculas() {
	    List<String> calificaciones = new ArrayList<>();

	    // Procesar funciones del lunes
	    for (Funcion funcion : lunes) {
	        if (funcion != null) {
	            Pelicula pelicula = funcion.getPelicula();
	            if (pelicula != null) {
	                calificaciones.add("Película: " + pelicula.getTitulo() +
	                                   " - Calificación: " + pelicula.getCalificacionPromedio() +
	                                   " - Día: Lunes");
	            }
	        }
	    }

	    // Procesar funciones del martes
	    for (Funcion funcion : martes) {
	        if (funcion != null) {
	            Pelicula pelicula = funcion.getPelicula();
	            if (pelicula != null) {
	                calificaciones.add("Película: " + pelicula.getTitulo() +
	                                   " - Calificación: " + pelicula.getCalificacionPromedio() +
	                                   " - Día: Martes");
	            }
	        }
	    }

	    // Procesar funciones del jueves
	    for (Funcion funcion : jueves) {
	        if (funcion != null) {
	            Pelicula pelicula = funcion.getPelicula();
	            if (pelicula != null) {
	                calificaciones.add("Película: " + pelicula.getTitulo() +
	                                   " - Calificación: " + pelicula.getCalificacionPromedio() +
	                                   " - Día: Jueves");
	            }
	        }
	    }

	    // Procesar funciones del viernes
	    for (Funcion funcion : viernes) {
	        if (funcion != null) {
	            Pelicula pelicula = funcion.getPelicula();
	            if (pelicula != null) {
	                calificaciones.add("Película: " + pelicula.getTitulo() +
	                                   " - Calificación: " + pelicula.getCalificacionPromedio() +
	                                   " - Día: Viernes");
	            }
	        }
	    }

	    // Procesar funciones del sábado
	    for (Funcion funcion : sabado) {
	        if (funcion != null) {
	            Pelicula pelicula = funcion.getPelicula();
	            if (pelicula != null) {
	                calificaciones.add("Película: " + pelicula.getTitulo() +
	                                   " - Calificación: " + pelicula.getCalificacionPromedio() +
	                                   " - Día: Sábado");
	            }
	        }
	    }

	    return calificaciones;
	}
		
	
	
	public ZonaDeJuegos getZonaDeJuegos() {
		return zonaDeJuegos;
	}


	public void setZonaDeJuegos(ZonaDeJuegos zonaDeJuegos) {
		this.zonaDeJuegos = zonaDeJuegos;
	}
	
	public void agregarFuncion(Funcion nuevaFuncion, Funcion[] funciones) {
	    Pelicula nuevaPelicula = nuevaFuncion.getPelicula();
	    int posicionApropiada = encontrarPosicionApropiada(nuevaPelicula, funciones);

	    if (posicionApropiada == -1) {
	        // No hay posiciones adecuadas disponibles
	        Interfaz.error();
	        return;
	    }

	    // Verificar si hay una función ya ocupando la posición
	    if (funciones[posicionApropiada] != null) {
	        // Reorganizar las funciones para hacer espacio
	        if (!reorganizarFunciones(funciones, posicionApropiada)) {
	            // Si no es posible reorganizar las funciones, no se puede agregar la nueva
	            Interfaz.error();
	            return;
	        }
	    }

	    // Agregar la nueva función a la posición adecuada
	    funciones[posicionApropiada] = nuevaFuncion;
	}

	private int encontrarPosicionApropiada(Pelicula pelicula, Funcion[] funciones) {
	    // Buscar una posición apropiada según el género de la película
	    for (int i = 0; i < funciones.length; i++) {
	        if (Pelicula.cumpleCriteriosHorario(pelicula, i) && funciones[i] == null) {
	            return i;
	        }
	    }
	    return -1; // No hay posiciones adecuadas disponibles
	}

	private boolean reorganizarFunciones(Funcion[] funciones, int posicionDeseada) {
	    // Intentar reorganizar las funciones para liberar la posición deseada
	    for (int i = 0; i < funciones.length; i++) {
	        Funcion funcionActual = funciones[i];
	        if (funcionActual == null || Pelicula.cumpleCriteriosHorario(funcionActual.getPelicula(), i)) {
	            continue; // La función está en una posición adecuada o está vacía
	        }

	        // Intentar mover la función actual a otra posición adecuada
	        for (int j = 0; j < funciones.length; j++) {
	            if (Pelicula.cumpleCriteriosHorario(funcionActual.getPelicula(), j) && funciones[j] == null) {
	                // Mover la función a la nueva posición
	                funciones[j] = funcionActual;
	                funciones[i] = null; // Liberar la posición original
	                break;
	            }
	        }
	    }

	    // Verificar si la posición deseada está libre
	    return funciones[posicionDeseada] == null;
	}
	
	public static void cargarCines() {
        // Utiliza el Deserializador para cargar la lista de cines desde el archivo
        ArrayList<Cine> listaCines = Deserializador.deserializarCines();

        if (listaCines != null) {
            // Reemplaza la lista estática de cines con la lista deserializada
            cines = listaCines;
           
        } else {
        	Interfaz.error();
        }
    }

    public static void guardarCines() {
        Serializador.serializarCine(cines);
    }
	      
    
    
	
	 

	
	public String toString() {
        return "Cine: " + nombre + ", Funciones: " +( lunes.length + martes.length + jueves.length + viernes.length) + sabado.length + " Zona de juegos: " + zonaDeJuegos;
    }
}

