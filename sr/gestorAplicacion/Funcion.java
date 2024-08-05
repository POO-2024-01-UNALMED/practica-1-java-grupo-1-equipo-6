package gestorAplicacion;

public class Funcion {
	private Pelicula pelicula;
	private String Horario;
	private int tipo;
	private Sala sala;
	private Boleta boleta;
	
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
		return Horario;
	}
	public void setHorario(String horario) {
		Horario = horario;
	}
	public int getTipo() {
		return tipo;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta
	}
	public Boleta getBoleta() {
		return boleta;
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
