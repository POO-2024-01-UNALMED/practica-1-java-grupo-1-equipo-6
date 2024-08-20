package gestorAplicacion;
import uiMain.Interfaz;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import BaseDatos.Deserializador;
import BaseDatos.Serializador;

public class Cliente implements Serializable{
	 private static final long serialVersionUID = 3L;
			 
	private String nombre;
	private int identificacion;
	private double saldo;
	private String tipo;
	private boolean tarjeta;
	private int puntosTarjeta;
	private int saldoTarjeta;
	private String tipoTarjeta;
	public static ArrayList<Cliente> allClientes=new ArrayList<>();

	public Cliente(String nombre, double saldo,String tipo,int identificacion){
		this.nombre = nombre;
		this.saldo = saldo;
		this.tipo=tipo;
		this.identificacion= identificacion;
		Cliente.allClientes.add(this);
	}
	public Cliente(String nombre, double saldo,int identificacion){
		this(nombre,saldo,"Generico",identificacion);
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

	public boolean getTarjeta(){
		return this.tarjeta;
	}

	public void setTarjeta(boolean tarjeta){
		this.tarjeta = tarjeta;
	}

	public int getPuntosTarjeta(){
		return this.puntosTarjeta;
	}
	public void setPuntosTarjeta(int puntos){
		this.puntosTarjeta = puntos;
	}

	public int getSaldoTarjeta(){
		return this.saldoTarjeta;
	}

	public void setSaldoTarjeta(int saldo){
		this.saldoTarjeta = saldo;
	}

	public String getTipoTarjeta(){
		return this.tipoTarjeta;
	}

	public void setTipoTarjeta(String tarjeta){
		this.tipoTarjeta = tarjeta;
	}
	
	public void calificarPelicula(Pelicula pelicula, double calificacion) {
		if (calificacion>5 && calificacion<0) {
			Interfaz.error();
		}
		pelicula.actualizarCalificacion(calificacion);
		

	}
	public static Cliente buscarClientePorId(int id) {
        for (Cliente cliente : allClientes) {
            if ((cliente.getIdentificacion())==id) {
                return cliente;
            }
        }
        return null; // Si no existe
    }
	
	public double utilizarCupon(int precio,int descuento) {
		if (descuento>100 && descuento<0) {
			Interfaz.error();
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

	public boolean pagarConSaldo(double monto) {

		if (this.saldo >= monto){
			this.saldo -= monto;
			return true;
		}
		return false;
	}

	public boolean pagarSaldoTarjeta(double costo){
		if (this.saldoTarjeta >= costo){
			this.saldoTarjeta -= costo;
			return true;
		}
		return false;
	}

	public boolean pagarPuntosTarjeta(double costo){
		int costoPuntos = (int)costo/100;
		if (this.puntosTarjeta >= costoPuntos){
			this.puntosTarjeta -= costoPuntos;
			return true;
		}
		return false;
	}


	public int agregarPuntos(){
		int aumento = 0;
		if (this.tipoTarjeta.equalsIgnoreCase("Platino")){
			aumento = 200;
			this.puntosTarjeta += aumento;
		}else if (this.tipoTarjeta.equalsIgnoreCase("Oro")){
			aumento = 150;
			this.puntosTarjeta += aumento;
		} else if(this.tipoTarjeta.equalsIgnoreCase("Bronce")){
			aumento = 100;
			this.puntosTarjeta += aumento;
		}
		return aumento;
	}

	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getIdentificacion() {
		return identificacion;
	}
	
	public static void cargarClientes() {
        // Utiliza el Deserializador para cargar la lista de cines desde el archivo
        ArrayList<Cliente> listaCliente = Deserializador.deserializarClientes();

        if (listaCliente != null) {
            // Reemplaza la lista estática de cines con la lista deserializada
            allClientes = listaCliente;
         
        } else {
        	Interfaz.error();
        }
    }

    public static void guardarClientes() {
        Serializador.serializarCliente(allClientes);
    }
	
	public String toString() {
        return "Cliente: " + nombre + ", Saldo: " + saldo + ", Tipo: " + tipo;
    }

}
