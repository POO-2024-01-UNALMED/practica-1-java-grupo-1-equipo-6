package gestorAplicacion;
import java.util.ArrayList;
import java.time.LocalTime; //Para el manejo de los horarios de las funciones


import gestorAplicacion.Cine;

public class Funcion {
	private Pelicula pelicula;
	private LocalTime horario;
	private String tipo;
	private Sala sala;
	private int precio;
	private String dia;
	private String momentoDelDia;
	
	public static ArrayList<Funcion> allFunciones=new ArrayList<>();;
	
	public Funcion(Pelicula pelicula, LocalTime horario, String tipo, Sala sala, int precio){
		this.pelicula = pelicula;
		this.horario = horario;
		this.tipo = tipo;
		this.sala = sala;
		this.precio = precio;
		allFunciones.add(this);
		
	}
	public Funcion(LocalTime horario,String tipo) {
		this(null,horario,tipo,null, 0);
		
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
	public String getDia(){
		return this.dia;
	}

	public void setDia(String dia){
		this.dia = dia;
	}

	public String getMomentoDelDia(){
		return this.momentoDelDia;
	}

	public void setMomentoDelDia(String momentoDelDia){
		this.momentoDelDia = momentoDelDia;
	}

	public int getPrecio(){return this.precio;}

	public void setPrecio(int precio){
		this.precio = precio;
	}
	
	public String toString() {
        return "Funcion: "+tipo +" Pelicula: "+ pelicula + ", Sala: " + sala + ", Horario: " + horario;
    }
}
