package gestorAplicacion;
import gestorAplicacion.Cine;

public class Funcion {
	private Pelicula pelicula;
	private String horario;
	private int tipo;
	private Sala sala;
	
	
	public Funcion(Pelicula pelicula, String horario, int tipo, Sala sala){
		this.pelicula = pelicula;
		this.horario = horario;
		this.tipo = tipo;
		this.sala = sala;
		
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
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
	
	
	
	
	
	

}
