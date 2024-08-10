package gestorAplicacion;
import java.util.ArrayList;

public class Cine {
	private String nombre;
	private ArrayList<Funcion> funciones;
	private ArrayList<Pelicula> peliculas;

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
			if (funcion.getPelicula().getTitulo().toLowerCase().equals(pelicula.getTitulo().toLowerCase())  && this.obtenerFunciones(pelicula).size()> 0 ){
				return true;
			}
		}
		return false;
	}

	public ArrayList<Pelicula> buscarPeliculaPorNombre(String pelicula){
		ArrayList<String> palabrasClave = new ArrayList<String>();
		pelicula = pelicula.toLowerCase();
		if (pelicula.indexOf(" ") == -1){
			palabrasClave.add(pelicula);
		} 
		else{
			int j = 0;
			for(int i= 0; i<pelicula.length(); i++){
				String palabraHallada;
				if (String.valueOf(pelicula.charAt(i)) == " " || i == pelicula.length() - 1){
					palabraHallada = pelicula.substring(j, i-1);
					if(palabraHallada.length()>2){
						palabrasClave.add(palabraHallada);
						if(i != pelicula.length() -1){j= i +1;}
					}
				}
			}
		}
		ArrayList<Pelicula> peliculasCoincidentes = new ArrayList<Pelicula>();
		for (int j=0; j<peliculas.size(); j++){
			for(int y=0; y<palabrasClave.size();y++){
				if(peliculas.get(j).getTitulo().contains(palabrasClave.get(y))){
					peliculasCoincidentes.add(peliculas.get(j));	
				}
			}
		}
		return peliculasCoincidentes;
	}

	
	public ArrayList<Funcion> obtenerFunciones(Pelicula pelicula){
		ArrayList<Funcion> posibilidades = new ArrayList<Funcion>();
		for( Funcion funcion: this.funciones){
			if (funcion.getPelicula().getTitulo().toLowerCase().equals(pelicula.getTitulo().toLowerCase())){
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

