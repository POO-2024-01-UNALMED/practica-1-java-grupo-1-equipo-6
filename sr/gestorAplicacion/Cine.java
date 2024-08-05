package gestorAplicacion;
import java.util.ArrayList;

public class Cine {
	private String nombre;
	private ArrayList<Funcion> funciones;

	public Cine(String nombre, ArrayList<Funcion> funciones){
		this.nombre = nombre;
		this.funciones = funciones;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public ArrayList<Funcion> getFunciones() {
		return funciones;
	}
	public void setFunciones(ArrayList<Funcion> funciones) {
		this.funciones = funciones;
	}
	
	
	public boolean hayPelicula(Pelicula pelicula) {		
		for (Funcion funcion: this.funciones){
			if (funcion.getPelicula().getTitulo().equals(pelicula.getTitulo())){
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Funcion> obtenerFunciones(Pelicula pelicula){
		ArrayList<Funcion> posibilidades = new ArrayList<Funcion>();
		for( Funcion funcion: this.funciones){
			if (funcion.getPelicula().getTitulo(),equals(pelicula.getTitulo())){
				boolean[][] lugares = funcion.getSala().getSillas();
				for (int i = 0; i<lugares.length; i++){
					for(int j = 0; j<lugares[0].length; i++){
						if(lugares[i][j]){
							posibilidades.add(funcion);
						}
					}
				}
			}
		}
		return posibilidades;
	}
	
	public void ajustarFunciones() {
		
	}
	

}
