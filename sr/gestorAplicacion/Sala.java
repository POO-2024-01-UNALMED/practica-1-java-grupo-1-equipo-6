package gestorAplicacion;


public class Sala {
	private String nombre;
	private boolean[][] sillas;
	
	public Sala(int filas, int columnas) {
        this.sillas = new boolean[filas][columnas];
    }
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean[][] getSillas() {
		return sillas;
	}
	public void setSillas(boolean[][] sillas) {
		this.sillas = sillas;
	}
	
	
	
	public boolean reservarSilla(int fila, int columna) {
		
	}
	
	public boolean estaDisponible(int fila, int columna) {
		
	}
	
	
	
	

}
