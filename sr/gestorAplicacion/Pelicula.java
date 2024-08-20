package gestorAplicacion;
import java.time.LocalTime;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import BaseDatos.Deserializador;
import BaseDatos.Serializador;
import uiMain.Interfaz;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class Pelicula implements Serializable{
	
	 private static final long serialVersionUID = 7L;
	
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
		if (!totalPeliculas.contains(this)) {
		    totalPeliculas.add(this);
		}
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
		    List<Funcion> funcionesPosibles = new ArrayList<>();
		    
		    // Obtener la lista de funciones de la película seleccionada
		    List<Funcion> funcionesSeleccionadas = peliculaSeleccionada.getFunciones();

		    for (Funcion funcionSeleccionada : funcionesSeleccionadas) {
		        // Obtener la posición de la función seleccionada en el día
		        int posicionSeleccionadaEnDia = Funcion.obtenerIndiceEnDia(funcionSeleccionada);
		        
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
		            int posicionIntercambioEnDia = Funcion.obtenerIndiceEnDia(funcionIntercambio);

		            // Verificar que las posiciones no sean iguales (no puede intercambiarse con sí misma)
		            if (posicionSeleccionadaEnDia == posicionIntercambioEnDia) {
		                continue;
		            }

		            // Verificar los criterios de horario según el género en la función de intercambio
		            boolean cumpleCriteriosHorario = cumpleCriteriosHorario(peliculaIntercambio, posicionIntercambioEnDia);
		            if (!cumpleCriteriosHorario) {
		                continue;
		            }

		            // Verificar los criterios de horario para la película de intercambio en la función de destino
		            boolean cumpleCriteriosHorarioDestino = cumpleCriteriosHorario(peliculaIntercambio, posicionSeleccionadaEnDia);
		            if (!cumpleCriteriosHorarioDestino) {
		                continue; // Descartar si no es adecuado para el nuevo horario
		            }

		            // Si cumple ambos criterios de horario, agregar la función a las posibles
		            funcionesPosibles.add(funcionIntercambio);
		        }
		    }

		    if (funcionesPosibles.isEmpty()) {
		        return "No se encontró ninguna película adecuada para el intercambio. Razones posibles:\n" +
		               "- Todas las películas disponibles son del mismo género que la película seleccionada.\n" +
		               "- No hay funciones en horarios compatibles para la película seleccionada o para el destino de intercambio.\n" +
		               "- Las posiciones de las funciones para el intercambio no cumplen con los criterios.";
		    }

		    // Encontrar la mejor opción basándose en la calificación de la película
		    Funcion mejorFuncion = null;
		    double mejorCalificacion = -1;

		    for (Funcion f : funcionesPosibles) {
		        Pelicula p = f.getPelicula();
		        if (p.getCalificacionPromedio() > mejorCalificacion) {
		            mejorCalificacion = p.getCalificacionPromedio();
		            mejorFuncion = f;
		        }
		    }

		    // Obtener información detallada sobre la función recomendada
		    Pelicula mejorPelicula = mejorFuncion.getPelicula();
		    Cine cine = Funcion.encontrarCine(mejorFuncion);
		    String dia = Funcion.encontrarDia(mejorFuncion,cine);
		    String horario = mejorFuncion.getHoraInicio();

		    return "Se recomienda intercambiar la película seleccionada con: " + mejorPelicula.getTitulo() +
		           " (Calificación: " + mejorPelicula.getCalificacionPromedio() + ").\n" +
		           "Esta película se proyecta en el cine: " + cine.getNombre() + ", el día: " + dia +
		           " a las: " + horario + ".";
		}

		// Método auxiliar para verificar los criterios de horario
		public static boolean cumpleCriteriosHorario(Pelicula pelicula, int posicionEnDia) {
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
	
	public static void cargarPeliculas() {
        // Utiliza el Deserializador para cargar la lista de cines desde el archivo
        ArrayList<Pelicula> listaPeliculas = Deserializador.deserializarPeliculas();

        if (listaPeliculas != null) {
            // Reemplaza la lista estática de cines con la lista deserializada
            totalPeliculas = listaPeliculas;
            
        } else {
        	Interfaz.error();
        }
    }

    public static void guardarPeliculas() {
        Serializador.serializarPelicula(totalPeliculas);
    }

}
	
	
	



