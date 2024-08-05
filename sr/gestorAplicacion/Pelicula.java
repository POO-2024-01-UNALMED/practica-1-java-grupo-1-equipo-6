package gestorAplicacion;

import java.util.List;

public class Pelicula {
	private String titulo;
	private String genero;
	private double calificacionPromedio;
	private int numeroCalificaciones;
	

	public pelicula(String titulo, String genero){
		this.titulo = titulo;
		this.genero = genero;
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
		
	}
	
	public static List<Pelicula> getListado(){
		
	}
	
	
	

}
