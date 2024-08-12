package gestorAplicacion;

public class Bodega extends Establecimiento {
    private int materialesDisponibles;

    public Bodega(String nombre, int materialesDisponibles) {
        super(nombre);
        this.materialesDisponibles = materialesDisponibles;
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
}
