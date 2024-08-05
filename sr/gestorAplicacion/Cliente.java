package gestorAplicacion;
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
		
	}
	public void calificarPelicula(Pelicula pelicula, double calificacion) {
		
	}
	public List<Pelicula> getRecomendaciones(){
		
	}
	public void utilizarCupon(Producto producto) {
		
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

		if (usarPuntos){
			int puntosTarjeta = this.tarjeta.getPuntos();
			if (puntosTarjeta >= monto){
				this.tarjeta.comprarConPuntos(monto);
				return true
			}
		} else{
			double saldoTarjeta = this.tarjeta.getSaldo();
			if(saldoTarjeta >= monto){
				this.tarjeta.comprarConSaldo();
				this.agregarPuntos();
			}
			return false;
		}
		
	}
	public void pagarConSaldo(double monto) {

		if (this.saldo >= monto){
			this.saldo -= monto;
		}
		
	}
	
	
	
}
