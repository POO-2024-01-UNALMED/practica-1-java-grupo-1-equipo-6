package gestorAplicacion;
import java.util.ArrayList;
import java.util.Comparator;


public class Maquina {
    private String nombre;
    private int usos;
    private int materialesNecesarios;
    private boolean disponible;
    private double dineroRecaudado;
    private double precioUso;
    private String tipo;
    private ZonaDeJuegos zonaDeJuegos;
    
    public Maquina(String nombre,String tipo, int materialesNecesarios, double precioUso) {
        this.nombre = nombre;
        this.materialesNecesarios = materialesNecesarios;
        this.disponible = true;
        this.dineroRecaudado = 0;
        this.precioUso = precioUso;
        this.setTipo(tipo);
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public boolean necesitaMantenimiento() {
        return usos >= 12;
    }

    public void usar() {
        if (disponible) {
            usos++;
            dineroRecaudado += precioUso;
            if (necesitaMantenimiento()) {
                disponible = false;
            }
        }
    }
    public void setPrecioUso(double precio) {
    	precioUso=precio;
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
        return "Maquina: " + nombre + ", Zona: " + zonaDeJuegos.getNombre() + ", Recaudado: " + dineroRecaudado;
    }

	public ZonaDeJuegos getZonaDeJuegos() {
		return zonaDeJuegos;
	}

	public void setZonaDeJuegos(ZonaDeJuegos zonaDeJuegos) {
		this.zonaDeJuegos = zonaDeJuegos;
	}
}

