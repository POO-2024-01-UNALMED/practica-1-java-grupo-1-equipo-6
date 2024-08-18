package gestorAplicacion;
import java.util.ArrayList;

public class Cine {
	private String nombre;
	private ArrayList<Funcion> lunes =new ArrayList<>();
	private ArrayList<Funcion> martes =new ArrayList<>();
	private ArrayList<Funcion> jueves =new ArrayList<>();
	private ArrayList<Funcion> viernes =new ArrayList<>();
	private ArrayList<Funcion> sabado =new ArrayList<>();
	public static ArrayList<Pelicula> peliculas=new ArrayList<>();
	private ZonaDeJuegos zonaDeJuegos;
	public static ArrayList<Cine> cines = new ArrayList<>();
	

	public Cine(String nombre, ArrayList<Funcion> lunes, ArrayList<Funcion> martes, ArrayList<Funcion> jueves, ArrayList<Funcion> viernes,ArrayList<Funcion> sabado, ZonaDeJuegos zonaDeJuegos){
		this.nombre = nombre;
		this.lunes = lunes;
		this.martes = martes;
		this.jueves = jueves;
		this.viernes = viernes;
		this.sabado = sabado;
		this.zonaDeJuegos = zonaDeJuegos;
		if(zonaDeJuegos!=null) {
		this.zonaDeJuegos.setCine(this);
		}
		cines.add(this);
	}
	
	public Cine(String nombre){
		this(nombre,null,null, null, null, null, null);
	}
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Funcion> getLunes(){
		return this.lunes;
	}

	public void setLunes(ArrayList<Funcion> lunes){
		this.lunes = lunes;
	}

	public ArrayList<Funcion> getMartes(){
		return this.martes;
	}

	public void setMartes(ArrayList<Funcion> martes){
		this.martes = martes;
	}

	public ArrayList<Funcion> getJueves(){
		return this.jueves;
	}

	public void setJueves(ArrayList<Funcion> jueves){
		this.jueves = jueves;
	}
	
	public ArrayList<Funcion> getViernes(){
		return this.viernes;
	}

	public void setViernes(ArrayList<Funcion> viernes){
		this.viernes = viernes;
	}

	public ArrayList<Funcion> getSabado(){
		return this.sabado;
	}

	public void setSabado(ArrayList<Funcion> sabado){
		this.sabado = sabado;
	}
	
	public boolean hayPelicula(Pelicula pelicula) {		
		for (Funcion funcionLunes: this.lunes){
			if (funcionLunes.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
				return true;
			}
		}
		for (Funcion funcionMartes: this.martes){
			if (funcionMartes.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
				return true;
			}
		}
		for (Funcion funcionJueves: this.jueves){
			if (funcionJueves.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
				return true;
			}
		}
		for (Funcion funcionViernes: this.viernes){
			if (funcionViernes.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
				return true;
			}
		}
		for (Funcion funcionSabado: this.sabado){
			if (funcionSabado.getPelicula().getTitulo().equals(pelicula.getTitulo()) && this.obtenerFunciones(pelicula).size() > 0){
				return true;
			}
		}
		return false;
	}

	public String enseñarFunciones(){
		String lunes = "Lunes: \n", martes = "Martes:\n", jueves = "Jueves\n", viernes = "Viernes:\n", sabado = "Sábado:\n";
		ArrayList<Pelicula> peliculasMostradas = new ArrayList<Pelicula>();
		for (Funcion funcionLunes: this.lunes){
			if (!peliculasMostradas.contains(funcionLunes.getPelicula())){
				lunes = lunes.concat(funcionLunes.getPelicula().getTitulo() + "\n");
				peliculasMostradas.add(funcionLunes.getPelicula());
			}
		}
		lunes += "\n"; peliculasMostradas.clear();
		for (Funcion funcionMartes: this.martes){
			if (!peliculasMostradas.contains(funcionMartes.getPelicula())){
				martes = martes.concat(funcionMartes.getPelicula().getTitulo() + "\n");
				peliculasMostradas.add(funcionMartes.getPelicula());
			}
		}
		martes += "\n"; peliculasMostradas.clear();
		for (Funcion funcionJueves: this.jueves){
			if (!peliculasMostradas.contains(funcionJueves.getPelicula())){
				jueves = jueves.concat(funcionJueves.getPelicula().getTitulo() + "\n");
				peliculasMostradas.add(funcionJueves.getPelicula());
			}
		}
		jueves += "\n"; peliculasMostradas.clear();
		for (Funcion funcionViernes: this.viernes){
			if (!peliculasMostradas.contains(funcionViernes.getPelicula())){
				viernes = viernes.concat(funcionViernes.getPelicula().getTitulo() + "\n");
				peliculasMostradas.add(funcionViernes.getPelicula());
			}
		}
		viernes += "\n"; peliculasMostradas.clear();
		for (Funcion funcionSabado: this.sabado){
			if (!peliculasMostradas.contains(funcionSabado.getPelicula())){
				sabado = sabado.concat(funcionSabado.getPelicula().getTitulo() + "\n");
				peliculasMostradas.add(funcionSabado.getPelicula());
			}
		}
		return lunes + martes + jueves + viernes + sabado;
	}

	public ArrayList<Pelicula> peliculasActivas(){
		ArrayList<Pelicula> peliculas = new ArrayList<Pelicula>();
		for (Funcion funcionLunes:this.lunes){
			if (!peliculas.contains(funcionLunes.getPelicula())){
				peliculas.add(funcionLunes.getPelicula());
			}
		}
		for (Funcion funcionMartes:this.martes){
			if (!peliculas.contains(funcionMartes.getPelicula())){
				peliculas.add(funcionMartes.getPelicula());
			}
		}
		for (Funcion funcionJueves:this.jueves){
			if (!peliculas.contains(funcionJueves.getPelicula())){
				peliculas.add(funcionJueves.getPelicula());
			}
		}
		for (Funcion funcionViernes:this.viernes){
			if (!peliculas.contains(funcionViernes.getPelicula())){
				peliculas.add(funcionViernes.getPelicula());
			}
		}
		for (Funcion funcionSabado:this.sabado){
			if (!peliculas.contains(funcionSabado.getPelicula())){
				peliculas.add(funcionSabado.getPelicula());
			}
		}
		return peliculas;
	}	

	public ArrayList<Funcion> obtenerFunciones(Pelicula pelicula){
		ArrayList<Funcion> posibilidades = new ArrayList<Funcion>();
		for( Funcion funcionLunes: this.lunes){
			if (funcionLunes.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionLunes.getSala().hayAsientosLibres()){
				posibilidades.add(funcionLunes);
			}
		}
		for( Funcion funcionMartes: this.martes){
			if (funcionMartes.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionMartes.getSala().hayAsientosLibres()){
				posibilidades.add(funcionMartes);
			}
		}
		for( Funcion funcionJueves: this.jueves){
			if (funcionJueves.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionJueves.getSala().hayAsientosLibres()){
				posibilidades.add(funcionJueves);
			}
		}
		for( Funcion funcionViernes: this.viernes){
			if (funcionViernes.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionViernes.getSala().hayAsientosLibres()){
				posibilidades.add(funcionViernes);
			}
		}
		for( Funcion funcionSabado: this.sabado){
			if (funcionSabado.getPelicula().getTitulo().equalsIgnoreCase(pelicula.getTitulo()) && funcionSabado.getSala().hayAsientosLibres()){
				posibilidades.add(funcionSabado);
			}
		}
		return posibilidades;
	}
 	
	public void ajustarFunciones() {
		for (Funcion funcion: this.lunes){
			funcion.setDia("Lunes");
			if (funcion.getPelicula().getGenero().equalsIgnoreCase("Terror") || funcion.getPelicula().getGenero().equalsIgnoreCase("+18")){
				funcion.setMomentoDelDia("pm");
			} else if (funcion.getPelicula().getGenero().equalsIgnoreCase("Infantil")){
				funcion.setMomentoDelDia("am");
			}
			else{
				funcion.setMomentoDelDia("pm");
			}
		}
		for (Funcion funcionMartes: this.martes){
			funcionMartes.setDia("Martes");
			if (funcionMartes.getPelicula().getGenero().equalsIgnoreCase("Terror") || funcionMartes.getPelicula().getGenero().equalsIgnoreCase("+18")){
				funcionMartes.setMomentoDelDia("pm");
			} else if (funcionMartes.getPelicula().getGenero().equalsIgnoreCase("Infantil")){
				funcionMartes.setMomentoDelDia("am");
			}
			else{
				funcionMartes.setMomentoDelDia("pm");
			}
		}
			for (Funcion funcionJueves: this.jueves){
				funcionJueves.setDia("Jueves");
				if (funcionJueves.getPelicula().getGenero().equalsIgnoreCase("Terror") || funcionJueves.getPelicula().getGenero().equalsIgnoreCase("+18")){
					funcionJueves.setMomentoDelDia("pm");
				} else if (funcionJueves.getPelicula().getGenero().equalsIgnoreCase("Infantil")){
					funcionJueves.setMomentoDelDia("am");
				}
				else{
					funcionJueves.setMomentoDelDia("pm");
				}
			}
				for (Funcion funcionViernes: this.viernes){
					funcionViernes.setDia("Viernes");
					if (funcionViernes.getPelicula().getGenero().equalsIgnoreCase("Terror") || funcionViernes.getPelicula().getGenero().equalsIgnoreCase("+18")){
						funcionViernes.setMomentoDelDia("pm");
					} else if (funcionViernes.getPelicula().getGenero().equalsIgnoreCase("Infantil")){
						funcionViernes.setMomentoDelDia("am");
					}
					else{
						funcionViernes.setMomentoDelDia("pm");
					}
				}
				for (Funcion funcionSabado: this.sabado){
					funcionSabado.setDia("Sabado");
					if (funcionSabado.getPelicula().getGenero().equalsIgnoreCase("Terror") || funcionSabado.getPelicula().getGenero().equalsIgnoreCase("+18")){
						funcionSabado.setMomentoDelDia("pm");
					} else if (funcionSabado.getPelicula().getGenero().equalsIgnoreCase("Infantil")){
						funcionSabado.setMomentoDelDia("am");
					}
					else{
						funcionSabado.setMomentoDelDia("pm");
					}
				}
	}
		
	
	
	public ZonaDeJuegos getZonaDeJuegos() {
		return zonaDeJuegos;
	}


	public void setZonaDeJuegos(ZonaDeJuegos zonaDeJuegos) {
		this.zonaDeJuegos = zonaDeJuegos;
	}
	
	public String toString() {
        return "Cine: " + nombre + ", Funciones: " + (lunes.size() + martes.size() + jueves.size() + viernes.size() + sabado.size()) + " Zona de juegos: " + zonaDeJuegos;
    }
}

