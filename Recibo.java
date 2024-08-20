
public class Recibo {
	private String planSeleccionado;
	private double costo;
	private int puntosOtorgados;
	
	public void Recibo(String planSeleccionado, double costo, int puntosOtorgados) {
		this.planSeleccionado = planSeleccionado;
		this.costo = costo;
		this.puntosOtorgados = puntosOtorgados;
	}
	
	public void setPlanSeleccionado(String planSeleccionado) {
		this.planSeleccionado = planSeleccionado;
		
	}
	public String getPlanSeleccionado() {
		return planSeleccionado;
		
	}
public void setCosto(double costo) {
	this.costo = costo;
		
	}
	public double getCosto() {
		return costo;
	}
public void setPuntosOtorgados(int puntosOtorgados) {
	this.puntosOtorgados = puntosOtorgados;
		
	}
	public int getPuntosOtorgados() {
		return puntosOtorgados;
	}

}
