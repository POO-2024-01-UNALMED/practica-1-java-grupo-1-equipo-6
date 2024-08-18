package gestorAplicacion;
import java.util.ArrayList;
import java.time.LocalTime; 
import gestorAplicacion.Cine;

public class Funcion {
	private Pelicula pelicula;
	private LocalTime horario;
	private String tipo;
	private Sala sala;
	public static ArrayList<Funcion> allFunciones=new ArrayList<>();;
	
	public Funcion(Pelicula pelicula, LocalTime horario, String tipo, Sala sala){
		this.pelicula = pelicula;
		this.horario = horario;
		this.tipo = tipo;
		this.sala = sala;
		allFunciones.add(this);
		pelicula.setFuncion(this);
		
	}
	public Funcion(LocalTime horario,String tipo) {
		this(null,horario,tipo,null);
		
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public LocalTime getHorario() {
		return horario;
	}
	public void setHorario(LocalTime horario) {
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
		
        return "Funcion: "+tipo +" Pelicula: "+ pelicula + ", Sala: " + sala + ", Hora: " + horario;
		
    }
	
	
	
	
	
	

}
