package gestorAplicacion;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private String genero;
	private double calificacionPromedio;
	private int numeroCalificaciones;
	public static ArrayList<Pelicula> totalPeliculas=new ArrayList<>();;

	public Pelicula(String titulo, String genero){
		this.titulo = titulo;
		this.genero = genero;
		Pelicula.totalPeliculas.add(this);
		Cine.peliculas.add(this);
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
	
	
	

}
