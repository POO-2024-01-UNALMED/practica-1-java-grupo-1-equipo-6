package gestorAplicacion;
import java.util.ArrayList;

import gestorAplicacion.Cine;

public class Funcion {
	private Pelicula pelicula;
	private String horario;
	private String tipo;
	private Sala sala;
	public static ArrayList<Funcion> allFunciones=new ArrayList<>();;
	
	public Funcion(Pelicula pelicula, String horario, String tipo, Sala sala){
		this.pelicula = pelicula;
		this.horario = horario;
		this.tipo = tipo;
		this.sala = sala;
		allFunciones.add(this);
		
	}
	public Funcion(String horario,String tipo) {
		this(null,horario,tipo,null);
		
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	public String toString() {
		
        return "Funcion: " + pelicula + ", Sala: " + sala + ", Horario: " + horario;
		
    }
	
	
	
	
	
	

}
