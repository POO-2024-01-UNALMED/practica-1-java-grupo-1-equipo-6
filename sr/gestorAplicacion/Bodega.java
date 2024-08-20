package gestorAplicacion;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import BaseDatos.Deserializador;
import BaseDatos.Serializador;
import uiMain.Interfaz;

public class Bodega extends Establecimiento implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
	 public static ArrayList<Bodega> allBodegas = new ArrayList<>();
	
	private int materialesDisponibles;

    public Bodega(String nombre, int materialesDisponibles) {
        super(nombre);
        this.materialesDisponibles = materialesDisponibles;
        allBodegas.add(this);
    }

    public boolean tieneMaterialesSuficientes(int cantidadNecesaria) {
        return materialesDisponibles >= cantidadNecesaria;
    }

    public void usarMateriales(int cantidad) {
        if (tieneMaterialesSuficientes(cantidad)) {
            materialesDisponibles -= cantidad;
        }
    }

    public void recargarMateriales(int cantidad, int costo) {
        materialesDisponibles += cantidad;
        setDineroRecaudado(getDineroRecaudado() - costo);
    }

    public String realizarMantenimiento(ZonaDeJuegos zona, int indiceMaquina) {
        Maquina maquinaSeleccionada = zona.getMaquinas().get(indiceMaquina);

        if (tieneMaterialesSuficientes(maquinaSeleccionada.getMaterialesNecesarios())) {
            usarMateriales(maquinaSeleccionada.getMaterialesNecesarios());
            maquinaSeleccionada.reparar();
            return "La máquina " + maquinaSeleccionada.getNombre() + " ha sido reparada.";
        } else {
            return "No hay suficientes materiales para reparar la máquina " + maquinaSeleccionada.getNombre();
        }
    }

    @Override
    public void aplicarPromocion() {
        // Implementación específica de la Bodega si es necesario
        System.out.println("Aplicando promoción en la bodega " + getNombre() + ".");
    }

    @Override
    public String toString() {
        return "Bodega: " + nombre + ", Materiales disponibles " + materialesDisponibles;
    }
    
    
}
