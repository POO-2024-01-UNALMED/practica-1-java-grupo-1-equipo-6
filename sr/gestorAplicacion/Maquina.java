package gestorAplicacion;
import java.util.ArrayList;
import java.util.Comparator;

import BaseDatos.Deserializador;
import BaseDatos.Serializador;
import uiMain.Interfaz;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Maquina implements Serializable {
	
	private static final long serialVersionUID = 6L;
	
    private String nombre;
    private int usos;
    private int materialesNecesarios;
    private boolean disponible;
    private double dineroRecaudado;
    private double precioUso;
    private String tipo;
    private ZonaDeJuegos zonaDeJuegos;
    private boolean bonoActivo;
    public static ArrayList<Maquina> allMaquinas=new ArrayList<>();;
    public Maquina(String nombre,String tipo, int materialesNecesarios, double precioUso) {
        this.nombre = nombre;
        this.materialesNecesarios = materialesNecesarios;
        this.disponible = true;
        this.dineroRecaudado = 0;
        this.precioUso = precioUso;
        this.setTipo(tipo);
        this.bonoActivo=false;
        if (!allMaquinas.contains(this)) {
		    allMaquinas.add(this);
		}
    }
    
    public int getUsos() {
    	return this.usos;
    }
    
    public void setUsos(int usos) {
    	this.usos=usos;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaDisponible() {
        if (necesitaMantenimiento()==true) {
        	return false;
        }
        else {
        	return true;
        }
    }

    public boolean necesitaMantenimiento() {
        if( usos >= 12) {
        	disponible=false;
        	return true;
        }
        else {
        	disponible=true;
        	return false;
        }
    }

    public void usar() {
        if (disponible) {
            usos+=1;
            dineroRecaudado += precioUso;
        }
        else if (necesitaMantenimiento()) {
                disponible = false;
            }
        }
    
    public void setPrecioUso(double precio) {
    	precioUso=precio;
    }
    public double getPrecioUso() {
    	return precioUso;
    }

    public void reparar() {
        usos = 0;
        disponible = true;
    }

    public double getDineroRecaudado() {
        return dineroRecaudado;
    }

    public int getMaterialesNecesarios() {
        return materialesNecesarios;
    }

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public static ArrayList<Maquina> obtenerDosMaquinasMenosVenden() {
        
		ArrayList<Maquina> todasLasMaquinas=new ArrayList<>();
		
		for (ZonaDeJuegos zona : ZonaDeJuegos.zonasDeJuegos) {
            todasLasMaquinas.addAll(zona.getMaquinas());
        }

        // Ordenar las máquinas por dinero recaudado en orden ascendente
        todasLasMaquinas.sort(Comparator.comparingDouble(Maquina::getDineroRecaudado));

        // Obtener las dos máquinas que menos venden
        ArrayList<Maquina> dosMenosVenden = new ArrayList<>();
        if (todasLasMaquinas.size() > 0) {
            dosMenosVenden.add(todasLasMaquinas.get(0)); // La que menos vende
        }
        if (todasLasMaquinas.size() > 1) {
            dosMenosVenden.add(todasLasMaquinas.get(1)); // La segunda que menos vende
        }

        return dosMenosVenden;
    }

    // Otros métodos de la clase Maquina...

    @Override
    public String toString() {
    	
        return "Maquina: " + nombre + " Tipo: "+tipo+", Recaudado: " + dineroRecaudado;
    	
    }

	public ZonaDeJuegos getZonaDeJuegos() {
		return zonaDeJuegos;
	}

	public void setZonaDeJuegos(ZonaDeJuegos zonaDeJuegos) {
		this.zonaDeJuegos = zonaDeJuegos;
	}
	
	public void activarBono() {
        this.bonoActivo = true;
	}
	
	public String asignarBono(Cliente cliente) {
        if (bonoActivo) {
            switch (cliente.getTipo()) {
                case "Generico":
                    cliente.setSaldo(cliente.getSaldo()+5); // Ejemplo de bono para cliente genérico
                    break;
                case "Preferencial":
                    cliente.setSaldo(cliente.getSaldo()+12); // Ejemplo de bono preferencial
                    break;
                case "VIP":
                    cliente.setSaldo(cliente.getSaldo()+20); // Ejemplo de bono VIP
                    break;
            }
            
        }
        return "Bono "+ cliente.getTipo()+ " asignado a " + cliente.getNombre();
    }
	
	public static void cargarMaquinas() {
        // Utiliza el Deserializador para cargar la lista de cines desde el archivo
        ArrayList<Maquina> listaMaquinas = Deserializador.deserializarMaquinas();

        if (listaMaquinas != null) {
            // Reemplaza la lista estática de cines con la lista deserializada
            allMaquinas = listaMaquinas;
            
        } else {
        	Interfaz.error();
        }
    }

    public static void guardarMaquinas() {
        Serializador.serializarMaquina(allMaquinas);
    }
}


