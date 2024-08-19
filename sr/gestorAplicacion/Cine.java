package gestorAplicacion;
import java.util.ArrayList;
import java.util.List;

public class Cine {
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
			if (funcionLunes.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
				return true;
			}
		}
		for (Funcion funcionMartes: this.martes){
			if (funcionMartes.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
				return true;
			}
		}
		for (Funcion funcionJueves: this.jueves){
			if (funcionJueves.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
				return true;
			}
		}
		for (Funcion funcionViernes: this.viernes){
			if (funcionViernes.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
				return true;
			}
		}
		for (Funcion funcionSabado: this.sabado){
			if (funcionSabado.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
				return true;
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
	    lunes += "\n";
	    peliculasMostradas.clear();

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
	    martes += "\n";
	    peliculasMostradas.clear();

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
	    jueves += "\n";
	    peliculasMostradas.clear();

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
	    viernes += "\n";
	    peliculasMostradas.clear();

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
			if (funcionLunes.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionLunes.getSala().hayAsientosLibres()){
				posibilidades.add(funcionLunes);
			}
		}
		for( Funcion funcionMartes: this.martes){
			if (funcionMartes.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionMartes.getSala().hayAsientosLibres()){
				posibilidades.add(funcionMartes);
			}
		}
		for( Funcion funcionJueves: this.jueves){
			if (funcionJueves.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionJueves.getSala().hayAsientosLibres()){
				posibilidades.add(funcionJueves);
			}
		}
		for( Funcion funcionViernes: this.viernes){
			if (funcionViernes.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionViernes.getSala().hayAsientosLibres()){
				posibilidades.add(funcionViernes);
			}
		}
		for( Funcion funcionSabado: this.sabado){
			if (funcionSabado.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionSabado.getSala().hayAsientosLibres()){
				posibilidades.add(funcionSabado);
			}
		}
		return posibilidades;
	}
 	
	public void ajustarFunciones() {
		for (Funcion funcion: this.lunes){
			funcion.setDia("Lunes");
			if (funcion.getPelicula().getGenero().equalsIgnoreCase("Terror") || funcion.getPelicula().getGenero().equalsIgnoreCase("+18")){
				funcion.setMomentoDelDia("pm");
			} else if (funcion.getPelicula().getGenero().equalsIgnoreCase("Infantil")){
				funcion.setMomentoDelDia("am");
			}
			else{
				funcion.setMomentoDelDia("pm");
			}
		}
		for (Funcion funcionMartes: this.martes){
			funcionMartes.setDia("Martes");
			if (funcionMartes.getPelicula().getGenero().equalsIgnoreCase("Terror") || funcionMartes.getPelicula().getGenero().equalsIgnoreCase("+18")){
				funcionMartes.setMomentoDelDia("pm");
			} else if (funcionMartes.getPelicula().getGenero().equalsIgnoreCase("Infantil")){
				funcionMartes.setMomentoDelDia("am");
			}
			else{
				funcionMartes.setMomentoDelDia("pm");
			}
		}
			for (Funcion funcionJueves: this.jueves){
				funcionJueves.setDia("Jueves");
				if (funcionJueves.getPelicula().getGenero().equalsIgnoreCase("Terror") || funcionJueves.getPelicula().getGenero().equalsIgnoreCase("+18")){
					funcionJueves.setMomentoDelDia("pm");
				} else if (funcionJueves.getPelicula().getGenero().equalsIgnoreCase("Infantil")){
					funcionJueves.setMomentoDelDia("am");
				}
				else{
					funcionJueves.setMomentoDelDia("pm");
				}
			}
				for (Funcion funcionViernes: this.viernes){
					funcionViernes.setDia("Viernes");
					if (funcionViernes.getPelicula().getGenero().equalsIgnoreCase("Terror") || funcionViernes.getPelicula().getGenero().equalsIgnoreCase("+18")){
						funcionViernes.setMomentoDelDia("pm");
					} else if (funcionViernes.getPelicula().getGenero().equalsIgnoreCase("Infantil")){
						funcionViernes.setMomentoDelDia("am");
					}
					else{
						funcionViernes.setMomentoDelDia("pm");
					}
				}
				for (Funcion funcionSabado: this.sabado){
					funcionSabado.setDia("Sabado");
					if (funcionSabado.getPelicula().getGenero().equalsIgnoreCase("Terror") || funcionSabado.getPelicula().getGenero().equalsIgnoreCase("+18")){
						funcionSabado.setMomentoDelDia("pm");
					} else if (funcionSabado.getPelicula().getGenero().equalsIgnoreCase("Infantil")){
						funcionSabado.setMomentoDelDia("am");
					}
					else{
						funcionSabado.setMomentoDelDia("pm");
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
	
	public String toString() {
        return "Cine: " + nombre + ", Funciones: " +( lunes.length + martes.length + jueves.length + viernes.length) + sabado.length + " Zona de juegos: " + zonaDeJuegos;
    }
}

