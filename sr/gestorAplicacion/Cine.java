package gestorAplicacion;
import java.util.ArrayList;

public class Cine {
	private String nombre;
	private ArrayList<Funcion> funciones=new ArrayList<>();;
	public static ArrayList<Pelicula> peliculas=new ArrayList<>();;
	private ZonaDeJuegos zonaDeJuegos;
	

	public Cine(String nombre, ArrayList<Funcion> funciones,ZonaDeJuegos zonaDeJuegos){
		this.nombre = nombre;
		this.funciones = funciones;
		this.zonaDeJuegos = zonaDeJuegos;
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

	public String enseñarFunciones(){
		String mensaje = "Funciones:\n"; int posicion =1;
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		for (Funcion funcion:funciones){
			if (!peliculas.contains(funcion.getPelicula())){
				mensaje += posicion + " "+ funcion.getPelicula().getTitulo() + "\n";
				peliculas.add(funcion.getPelicula());
				posicion++;
			}
		}
		return mensaje;
	}

	public ArrayList<Pelicula> peliculasActivas(){
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		for (Funcion funcion:funciones){
			if (!peliculas.contains(funcion.getPelicula())){
				peliculas.add(funcion.getPelicula());
			}
		}
		return peliculas;
	}	

	public ArrayList<Pelicula> buscarPeliculaPorNombre(String nombrePelicula) {
        ArrayList<String> palabrasClave = new ArrayList<>();
        nombrePelicula = nombrePelicula.toLowerCase();  // Convertir a minúsculas

        // Extraer palabras clave del nombre de la película
        String[] palabras = nombrePelicula.split("\\s+");  // Dividir por espacios

        if (palabras.length == 1){
				palabrasClave.add(palabras[0]);
		} else{
				for (String palabra : palabras) {
						if (palabra.length() > 2) {
								palabrasClave.add(palabra);
						}
				}
			}

        ArrayList<Pelicula> peliculasCoincidentes = new ArrayList<>();

        // Buscar coincidencias en la lista de películas
        for (Pelicula pelicula : peliculas) {
            String titulo = pelicula.getTitulo().toLowerCase();
            for (String palabraClave : palabrasClave) {
                if (titulo.contains(palabraClave)) {
                    peliculasCoincidentes.add(pelicula);
                    break;  // Si ya encontramos una coincidencia, no es necesario seguir buscando en esta película
                }
            }
        }

        return peliculasCoincidentes;
    }
	
	public ArrayList<Funcion> obtenerFunciones(Pelicula pelicula){
		ArrayList<Funcion> posibilidades = new ArrayList<Funcion>();
		for( Funcion funcion: this.funciones){
			if (funcion.getPelicula().getTitulo().toLowerCase().equals(pelicula.getTitulo().toLowerCase())){
				posibilidades.add(funcion);
			}
		}
		return posibilidades;
	}
	
	public void ajustarFunciones() {
		
	}
	public void agregarPeliculas() {		
		for (Funcion funcion: this.funciones){
			this.peliculas.add(funcion.getPelicula());
				
			
		}
		
	}


	public ZonaDeJuegos getZonaDeJuegos() {
		return zonaDeJuegos;
	}


	public void setZonaDeJuegos(ZonaDeJuegos zonaDeJuegos) {
		this.zonaDeJuegos = zonaDeJuegos;
	}
	

}

