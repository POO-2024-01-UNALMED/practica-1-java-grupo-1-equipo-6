package gestorAplicacion;
import uiMain.Admin;
import java.util.ArrayList;

public class Cliente {
	private String nombre;
	private int identificacion;
	private double saldo;
	private String tipo;
	public static ArrayList<Cliente> allClientes=new ArrayList<>();;

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
	
	public void calificarPelicula(Pelicula pelicula, double calificacion) {
		if (calificacion>5 && calificacion<0) {
			Admin.error();
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
	public int getIdentificacion() {
		return identificacion;
	}
	
	public String toString() {
        return "Cliente: " + nombre + ", Saldo: " + saldo + ", Tipo: " + tipo;
    }
	
	
	
}
