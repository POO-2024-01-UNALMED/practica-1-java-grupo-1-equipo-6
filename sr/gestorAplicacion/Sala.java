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
	   
	    if (fila >= 0 && fila < sillas.length && columna >= 0 && columna < sillas[fila].length) {
	       if (sillas[fila][columna]) {
	            sillas[fila][columna] = false;
	            return true; 
	        } else {
	            return false; 
	        }
	    } else {
	        return false; 
	    }
	}
	
	public boolean estaDisponible(int fila, int columna) {
	    
		if (fila >= 0 && fila < sillas.length && columna >= 0 && columna < sillas[fila].length) {
			return sillas[fila][columna];
	    } else {
	        return false; 
	    }
	}
	

}
