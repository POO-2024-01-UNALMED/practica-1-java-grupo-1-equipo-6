package gestorAplicacion;
import java.util.ArrayList;
import java.time.LocalTime; //Para el manejo de los horarios de las funciones


import gestorAplicacion.Cine;

public class Funcion {
	private Pelicula pelicula;
	private String tipo;
	private Sala sala;
	private double precio;
	private String dia;
	private String momentoDelDia;
	private int indexEnDia;
	
	public static ArrayList<Funcion> allFunciones=new ArrayList<>();;
	
	public Funcion(Pelicula pelicula, String tipo, Sala sala, int precio){
		this.pelicula = pelicula;
		this.tipo = tipo;
		this.sala = sala;
		this.precio = precio;
		allFunciones.add(this);
		if(this.pelicula!=null) {
			this.pelicula.getFunciones().add(this);
			}
		
	}
	public Funcion(String tipo) {
		this(null,tipo,null, 0);
		
	}
	
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula nuevaPelicula) {
        if (this.pelicula == nuevaPelicula) {
            // Si la película es la misma, no hacer nada
            return;
        }
        
        // Si hay una película anterior, quitar esta función de la lista de funciones de la película anterior
        if (this.pelicula != null) {
            this.pelicula.getFunciones().remove(this);
        }

        // Establecer la nueva película
        this.pelicula = nuevaPelicula;

        // Añadir esta función a la lista de funciones de la nueva película si no está ya presente
        if (nuevaPelicula != null && !nuevaPelicula.getFunciones().contains(this)) {
            nuevaPelicula.getFunciones().add(this);
        }
    }
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public String getDia(){
		return this.dia;
	}

	public void setDia(String dia){
		this.dia = dia;
	}

	public String getMomentoDelDia(){
		return this.momentoDelDia;
	}

	public void setMomentoDelDia(String momentoDelDia){
		this.momentoDelDia = momentoDelDia;
	}

	public double getPrecio(){return this.precio;}

	public void setPrecio(double precio){
		this.precio = precio;
	}
	
	public static String realizarIntercambio(Pelicula peliculaAIntercambiar, Pelicula peliculaRecomendada) {
	    // Buscar la función que muestra la película recomendada
	    Funcion funcionDestino = null;
	    for (Funcion f : allFunciones) {
	        if (f.getPelicula().equals(peliculaRecomendada)) {
	            funcionDestino = f;
	            break;
	        }
	    }

	    if (funcionDestino == null) {
	        return "No se encontró una función con la película recomendada.";
	    }

	    // Buscar una función que muestre la película a intercambiar
	    Funcion funcionOrigen = null;
	    for (Funcion f : allFunciones) {
	        if (f.getPelicula().equals(peliculaAIntercambiar)) {
	            funcionOrigen = f;
	            break;
	        }
	    }

	    if (funcionOrigen == null) {
	        return "No se encontró una función con la película a intercambiar.";
	    }

	    
	    

	    
	        // Realizar el intercambio de películas
	        funcionOrigen.setPelicula(peliculaRecomendada);
	        funcionDestino.setPelicula(peliculaAIntercambiar);

	        return "Intercambio realizado exitosamente.";
	   
	}
	
	public int getPosicionEnDia() {
		   
	    // Verificar que el índice está dentro de los límites esperados
	    if (this.indexEnDia >= 0 && this.indexEnDia < 7) {
	        return this.indexEnDia;
	    } else {
	        return 0;
	    }	
	}
	
	public static int obtenerIndiceEnDia(Funcion funcionBuscada) {
	    // Recorre todos los cines
	    for (Cine cine : Cine.cines) {
	        // Recorre todos los días de la semana para el cine actual
	        for (int i = 0; i < cine.getLunes().length; i++) {
	            if (cine.getLunes()[i] != null && cine.getLunes()[i].equals(funcionBuscada)) {
	                return i; // Retorna el índice en el día de la semana correspondiente
	            }
	        }
	        for (int i = 0; i < cine.getMartes().length; i++) {
	            if (cine.getMartes()[i] != null && cine.getMartes()[i].equals(funcionBuscada)) {
	                return i; // Retorna el índice en el día de la semana correspondiente
	            }
	        }
	        for (int i = 0; i < cine.getJueves().length; i++) {
	            if (cine.getJueves()[i] != null && cine.getJueves()[i].equals(funcionBuscada)) {
	                return i; // Retorna el índice en el día de la semana correspondiente
	            }
	        }
	        for (int i = 0; i < cine.getViernes().length; i++) {
	            if (cine.getViernes()[i] != null && cine.getViernes()[i].equals(funcionBuscada)) {
	                return i; // Retorna el índice en el día de la semana correspondiente
	            }
	        }
	        for (int i = 0; i < cine.getSabado().length; i++) {
	            if (cine.getSabado()[i] != null && cine.getSabado()[i].equals(funcionBuscada)) {
	                return i; // Retorna el índice en el día de la semana correspondiente
	            }
	        }
	    }
	    // Retorna -1 si no se encontró la función en ninguna lista de días
	    return -1;
	}
	public String getHoraInicio() {
		String respuesta;
		switch (Funcion.obtenerIndiceEnDia(this)) {
        case 0:
            respuesta="08:00";
            break;
        case 1:
        	respuesta="10:00";
            break;
        case 2:
        	respuesta="12:00";
            break;
        case 3:
        	respuesta="14:00";
            break;
        case 4:
        	respuesta="16:00";
            break;
        case 5:
        	respuesta="18:00";
            break;
        case 6:
        	respuesta="18:00";
            break;
        
        default:
            respuesta="";
            break;
	}
		return respuesta;
	}
}
	
	
	

