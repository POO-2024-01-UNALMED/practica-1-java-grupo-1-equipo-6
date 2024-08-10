package gestorAplicacion;

public class Tarjeta {
	private Cliente dueño;
	private String plan;
	private int puntos;
	private double saldo;
	
	
	
	
	public Cliente getDueño() {
		return dueño;
	}
	public void setDueño(Cliente dueño) {
		this.dueño = dueño;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	

	public void comprarConPuntos(double monto){
		this.puntos -= monto;
	}
	
	
	public void comprarConSaldo(double monto) {
		this.saldo -= monto;
		
	}
	public void agregarPuntos() {

		if (this.plan.equals("platino")){
			this.setPuntos(this.getPuntos() + 10000);
		} else if(this.plan.equals("oro")){
			this.setPuntos(this.getPuntos() + 5000);
		}else{
			this.setPuntos(this.getPuntos() + 2500);
		}
	}
	
	
	

}
