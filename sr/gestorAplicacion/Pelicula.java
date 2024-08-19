package gestorAplicacion;
import java.time.LocalTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import uiMain.Interfaz;

public class Pelicula {
	private String titulo;
	private String genero;
	private double calificacionPromedio;
	private int numeroCalificaciones;
	public static ArrayList<Pelicula> totalPeliculas=new ArrayList<>();;
	private LocalTime duracion;
	public ArrayList<Funcion> funciones=new ArrayList<>();;
	private boolean bonoActivo;
	

	public Pelicula(String titulo, String genero,LocalTime duracion){
		this.titulo = titulo;
		this.genero = genero;
		this.duracion=duracion;
		Pelicula.totalPeliculas.add(this);
		Cine.peliculas.add(this);
		this.bonoActivo=false;
	}
	
	public LocalTime getDuracion() {
	    return duracion;
	}

	public void setDuracion(LocalTime duracion) {
	    this.duracion = duracion;
	}
	
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public double getCalificacionPromedio() {
		return calificacionPromedio;
	}
	
	public void setCalificacionPromedio(double calificacionPromedio) {
		this.calificacionPromedio = calificacionPromedio;
	}
	public int getNumeroCalificaciones() {
		return numeroCalificaciones;
	}
	public void setNumeroCalificaciones(int numeroCalificaciones) {
		this.numeroCalificaciones = numeroCalificaciones;
	}
	
	
	
	public void actualizarCalificacion(double nuevaCalificacion) {
		double a=this.getCalificacionPromedio();
		int b=this.getNumeroCalificaciones();
		this.setCalificacionPromedio((a+nuevaCalificacion)/(b+1));
		this.setNumeroCalificaciones(b+1);
		
	}
	
	public static List<Pelicula> getListado(){
		return Pelicula.totalPeliculas;
		}
	
	 public String toString() {
	        return "Pelicula: " + titulo + ", Género: " + genero + ", Calificacion: " + calificacionPromedio;
	    }

	
	
	 public static String recomendarIntercambio(Pelicula peliculaSeleccionada) {
		    List<Pelicula> peliculasPosibles = new ArrayList<>();
		    
		    // Obtener la lista de funciones de la película seleccionada
		    List<Funcion> funcionesSeleccionadas = peliculaSeleccionada.getFunciones();

		    for (Funcion funcionSeleccionada : funcionesSeleccionadas) {
		        // Obtener la posición de la función seleccionada en el día
		        int posicionSeleccionadaEnDia = funcionSeleccionada.getPosicionEnDia();
		        
		        for (Funcion funcionIntercambio : Funcion.allFunciones) {
		            Pelicula peliculaIntercambio = funcionIntercambio.getPelicula();
		            if (peliculaIntercambio == null) {
		                continue; // Si no hay película asociada, ignorar la función
		            }

		            // Verificar que la película no sea del mismo género
		            if (peliculaIntercambio.getGenero().equals(peliculaSeleccionada.getGenero())) {
		                continue;
		            }

		            // Obtener la posición de la función de intercambio en el día
		            int posicionIntercambioEnDia = funcionIntercambio.getPosicionEnDia();

		            // Verificar que las posiciones no sean iguales (no puede intercambiarse con sí misma)
		            if (posicionSeleccionadaEnDia == posicionIntercambioEnDia) {
		                continue;
		            }

		            // Verificar los criterios de horario según el género
		            boolean cumpleCriteriosHorario = cumpleCriteriosHorario(peliculaIntercambio, posicionIntercambioEnDia);
		            if (!cumpleCriteriosHorario) {
		                continue;
		            }

		            // No es necesario verificar solapamiento de horarios ya que las funciones están en días y cines diferentes
		            boolean horariosNoSolapados = true; // Simplificación para diferentes días/cines

		            // La compatibilidad de duración no es necesaria ya que todas las funciones duran 2 horas
		            boolean duracionCompatible = true;

		            if (horariosNoSolapados && duracionCompatible) {
		                peliculasPosibles.add(peliculaIntercambio);
		            }
		        }
		    }

		    if (peliculasPosibles.isEmpty()) {
		        return "No se encontró ninguna película adecuada para el intercambio. Razones posibles:\n" +
		               "- Todas las películas disponibles son del mismo género que la película seleccionada.\n" +
		               "- No hay funciones en horarios compatibles para la película seleccionada.\n" +
		               "- Las posiciones de las funciones para el intercambio no cumplen con los criterios.";
		    }

		    // Encontrar la mejor opción basándose en la calificación
		    Pelicula mejorOpcion = null;
		    double mejorCalificacion = -1;

		    for (Pelicula p : peliculasPosibles) {
		        if (p.getCalificacionPromedio() > mejorCalificacion) {
		            mejorCalificacion = p.getCalificacionPromedio();
		            mejorOpcion = p;
		        }
		    }

		    return "Se recomienda intercambiar la película seleccionada con: " + mejorOpcion.getTitulo() + 
		           " (Calificación: " + mejorOpcion.getCalificacionPromedio() + ")";
		}


		// Método auxiliar para verificar los criterios de horario
		private static boolean cumpleCriteriosHorario(Pelicula pelicula, int posicionEnDia) {
		    switch (pelicula.getGenero()) {
		        case "Infantil":
		            return posicionEnDia <= 3; // No puede estar en las últimas 3 posiciones
		        case "Terror":
		            return posicionEnDia >= 4; // Debe estar entre las 3 últimas posiciones
		        case "Acción":
		        case "Drama":
		            return true; // Puede estar en cualquier hora
		        case "+18":
		            return posicionEnDia >= 3; // Solo puede estar en las últimas 4 posiciones
		        default:
		            return false; // No se especifica para otros géneros
		    }
		}
		
	   

	       
	public boolean isBonoActivo() {
		return bonoActivo;
	}

	public void activarBono() {
        this.bonoActivo = true;
	}
	
	public  ArrayList<Funcion> getFunciones() {
        return funciones;
    }

    // Setter para el atributo estático
    public  void setFunciones(ArrayList<Funcion> nuevasFunciones) {
        funciones = nuevasFunciones;
    }
	
	public String asignarBono(Cliente cliente) {
        if (bonoActivo) {
            switch (cliente.getTipo()) {
                case "Generico":
                    cliente.setSaldo(cliente.getSaldo()+5); // Ejemplo de bono para cliente genérico
                    break;
                case "Preferencial":
                    cliente.setSaldo(cliente.getSaldo()+12); // Ejemplo de bono preferencial
                    break;
                case "VIP":
                    cliente.setSaldo(cliente.getSaldo()+20); // Ejemplo de bono VIP
                    break;
            }
            
        }
        return "Bono "+ cliente.getTipo()+ " asignado a " + cliente.getNombre();
    }
	
	
	

}
