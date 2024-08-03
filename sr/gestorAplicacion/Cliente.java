package gestorAplicacion;
import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private ArrayList<Boleta> boletas;
	private double saldo;
	private Tarjeta tarjeta;
	
	
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
	public ArrayList<Boleta> getBoletas() {
		return boletas;
	}
	public void setBoletas(ArrayList<Boleta> boletas) {
		this.boletas = boletas;
	}
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	
	
	
	public boolean haVistoPelicula(Pelicula pelicula) {
		
	}
	public void calificarPelicula(Pelicula pelicula, double calificacion) {
		
	}
	public List<Pelicula> getRecomendaciones(){
		
	}
	public void utilizarCupon(Producto producto) {
		
	}
	public void comprarBoleta(Cine cine, Pelicula pelicula) {
		
	}
	private void pagarConTarjeta(double monto, boolean usarPuntos) {
		
	}
	private void pagarConSaldo(double monto) {
		
	}
	
	
	


}
