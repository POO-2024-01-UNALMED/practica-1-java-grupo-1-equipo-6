package gestorAplicacion;

public class Boleta {
	private Funcion funcion;
	private Cliente cliente;
	private Sala sala;
	private Pelicula pelicula;
	private double precio;
	

	public Boleta(Funcion funcion, Cliente cliente, Sala sala,Pelicula pelicula){
		this.funcion = funcion;
		this.cliente = cliente;
		this.sala = sala;
		this.setPelicula(pelicula);

	}
	
	
	
	
	public Funcion getFuncion() {
		return funcion;
	}
	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}




	public Pelicula getPelicula() {
		return pelicula;
	}




	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	
	
	
	
	

}
