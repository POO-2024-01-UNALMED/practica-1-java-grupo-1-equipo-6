package gestorAplicacion;
import uiMain.Admin;
import java.util.ArrayList;


public class Cliente {
	private String nombre;
	private double saldo;
	private String tipo;

	public Cliente(String nombre, double saldo,String tipo){
		this.nombre = nombre;
		this.saldo = saldo;
	}
	public Cliente(String nombre, double saldo){
		this(nombre,saldo,"Generico");
	}
	
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void calificarPelicula(Pelicula pelicula, double calificacion) {
		if (calificacion>5 && calificacion<0) {
			Admin.error();
		}
		pelicula.actualizarCalificacion(calificacion);
		

	}
	
	public double utilizarCupon(int precio,int descuento) {
		if (descuento>100 && descuento<0) {
			Admin.error();
		}
		double a=precio;
		double newPrecio=a-((a/100)*descuento);
		
		return newPrecio;
		
	}
	public boolean comprarBoleta(Cine cine, Pelicula pelicula) {
		boolean booleano = cine.hayPelicula(pelicula);
		if (booleano){
			return true;
		}else{
			return false;
		}
	}

	public void pagarConSaldo(double monto) {

		if (this.saldo >= monto){
			this.saldo -= monto;
		}
		else {
			Admin.error();
		}
		
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
}
