package gestorAplicacion;
import uiMain.Admin;
import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private ArrayList<Boleta> boletas;
	private double saldo;
	private Tarjeta tarjeta;

	public Cliente(String nombre, double saldo){
		this.nombre = nombre;
		this.saldo = saldo;
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
	public void agregarBoleta(Boleta boleta){
		this.boletas.add(boleta);
	}
	
	
	public boolean haVistoPelicula(Pelicula pelicula) {
		for (int i=0; i<this.boletas.size();i++){
			if(pelicula != null && this.boletas.get(i).getPelicula().equals(pelicula)) {
				return true;
			}
			
		}
		return false;
	}
	public void calificarPelicula(Pelicula pelicula, double calificacion) {
		if (calificacion>5 && calificacion<0) {
			Admin.error();
		}
		pelicula.actualizarCalificacion(calificacion);
		

	}
	public List<Pelicula> getRecomendaciones(){
		
	}
	public void utilizarCupon(Boleta boleta,int descuento) {
		if (descuento>100 && descuento<0) {
			Admin.error();
		}
		double a=boleta.getPrecio();
		double newPrecio=a-((a/100)*descuento);
		boleta.setPrecio(newPrecio);
	}
	public boolean comprarBoleta(Cine cine, Pelicula pelicula) {
		boolean booleano = cine.hayPelicula(pelicula);
		if (booleano){
			return true;
		}else{
			return false;
		}
	}

	public boolean pagarConTarjeta(double monto, boolean usarPuntos) {
		double saldoTarjeta = this.tarjeta.getSaldo();
		if (usarPuntos){
			int puntosTarjeta = this.tarjeta.getPuntos();
			if (puntosTarjeta >= monto){
				this.tarjeta.comprarConPuntos(monto);
				return true;
			}
			else {
				return false;
			}
		
		
		} 
		else if(saldoTarjeta >= monto){
			this.tarjeta.comprarConSaldo(monto);
			return true;
			}
		else {
			Admin.error();
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
	
	
	
}
