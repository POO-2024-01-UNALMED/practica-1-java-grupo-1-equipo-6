package gestorAplicacion;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private String genero;
	private double calificacionPromedio;
	private int numeroCalificaciones;
	public static ArrayList<Pelicula> totalPeliculas=new ArrayList<>();;
	private LocalTime duracion;
	private Funcion funcion;

	public Pelicula(String titulo, String genero,LocalTime duracion){
		this.titulo = titulo;
		this.genero = genero;
		this.duracion=duracion;
		Pelicula.totalPeliculas.add(this);
		Cine.peliculas.add(this);
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

	public Funcion getFuncion() {
		return funcion;
	}

	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}
	
	public static String recomendarIntercambio(Pelicula peliculaBajaCalificacion) {
        // Obtener el horario y duración de la película actual
        LocalTime inicioActual = Funcion.allFunciones.get(0).getHorario();
        LocalTime finActual = inicioActual.plusHours(peliculaBajaCalificacion.getDuracion().getHour())
                                         .plusMinutes(peliculaBajaCalificacion.getDuracion().getMinute());

        // Lista para almacenar películas posibles para el intercambio
        List<Pelicula> peliculasPosibles = new ArrayList<>();

        // Iterar sobre todas las películas
        for (Pelicula p : Pelicula.totalPeliculas) {
            // Verificar que no sea del mismo género
            if (!p.getGenero().equals(peliculaBajaCalificacion.getGenero())) {
                // Iterar sobre las funciones posibles de intercambio
                for (Funcion f : Funcion.allFunciones) {
                    LocalTime inicioIntercambio = f.getHorario();
                    LocalTime finIntercambio = inicioIntercambio.plusHours(p.getDuracion().getHour())
                                                                 .plusMinutes(p.getDuracion().getMinute());

                    // Verificar que la nueva película encaje en el horario
                    if (inicioIntercambio.isBefore(finActual) && finIntercambio.isAfter(inicioActual) 
                        && p.getDuracion().equals(peliculaBajaCalificacion.getDuracion())) {

                        // Añadir a la lista de posibles opciones
                        peliculasPosibles.add(p);
                        break;
                    }
                }
            }
        }

        // Buscar la película con la mejor calificación
        if (peliculasPosibles.isEmpty()) {
            return "No se encontró una película adecuada para el intercambio.";
        }

        Pelicula mejorOpcion = null;
        double mejorCalificacion = -1;

        for (Pelicula p : peliculasPosibles) {
            if (p.getCalificacionPromedio() > mejorCalificacion) {
                mejorCalificacion = p.getCalificacionPromedio();
                mejorOpcion = p;
            }
        }

        return "Recomendación de intercambio: " + (mejorOpcion != null ? mejorOpcion.toString() : "No hay opción adecuada.");
    }
	
	
	

}
