package gestorAplicacion;
import java.util.ArrayList;
import java.util.List;

import BaseDatos.Deserializador;
import BaseDatos.Serializador;
import uiMain.Interfaz;

import java.util.ArrayList;
import java.util.List;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
public class ZonaDeJuegos extends Establecimiento implements Serializable{
	
	private static final long serialVersionUID = 9L;
	
    private String horario;
    private List<Maquina> maquinas;
    private Cine cine;
    public static ArrayList<ZonaDeJuegos> zonasDeJuegos = new ArrayList<>();

    public ZonaDeJuegos(String nombre, String horario) {
        super(nombre);
        this.horario = horario;
        this.maquinas = new ArrayList<>();
        ZonaDeJuegos.zonasDeJuegos.add(this);
    }

    public void agregarMaquina(Maquina maquina) {
        maquinas.add(maquina);
        maquina.setZonaDeJuegos(this);
        actualizarDineroRecaudado();
    }

    public void actualizarDineroRecaudado() {
        double totalRecaudado = 0;
        for (Maquina maquina : maquinas) {
            totalRecaudado += maquina.getDineroRecaudado();
        }
        setDineroRecaudado(totalRecaudado);
    }

    public List<Maquina> getMaquinas() {
        return maquinas;
    }

    public List<Maquina> getMaquinasDañadas() {
        List<Maquina> maquinasDañadas = new ArrayList<>();
        for (Maquina maquina : maquinas) {
            if (maquina.necesitaMantenimiento()) {
                maquinasDañadas.add(maquina);
            }
        }
        return maquinasDañadas;
    }

    public String informeMaquinas() {
        StringBuilder informe = new StringBuilder();
        informe.append("Informe de la Zona de Juegos: ").append(getNombre()).append(" ").append(getCine().getNombre()).append("\n");
        informe.append("Horario: ").append(horario).append("\n");

        for (Maquina maquina : maquinas) {
            informe.append(maquina.getNombre()).append(" - ").append(maquina.estaDisponible() ? "Disponible" : "No Disponible").append("\n");
        }

        return informe.toString();
    }

    public String moverMaquina(ZonaDeJuegos zonaDestino, int indiceMaquina) {
        Maquina maquina = maquinas.remove(indiceMaquina);
        zonaDestino.agregarMaquina(maquina);
        return "La máquina " + maquina.getNombre() + " ha sido movida a " + zonaDestino.getNombre();
    }

    public String recomendarMovimiento(Maquina maquinaReparada) {
        double porcentajeDependencia = (maquinaReparada.getDineroRecaudado() / this.getDineroRecaudado()) * 100;

        // Verificar si la máquina es crucial para la zona actual
        if (porcentajeDependencia >= 70) {
            return "No se recomienda mover la máquina " + maquinaReparada.getNombre() +
                   " ya que representa el " + String.format("%.2f", porcentajeDependencia) + "% de los ingresos de la zona actual.";
        }

        // Buscar zonas candidatas
        List<ZonaDeJuegos> zonasCandidatas = new ArrayList<>();
        for (ZonaDeJuegos zona : zonasDeJuegos) {
            if (this != zona && zona.getDineroRecaudado() < this.getDineroRecaudado() &&
                !zona.tieneMaquinaDelTipo(maquinaReparada.getTipo())) {
                zonasCandidatas.add(zona);
            }
        }

        // Elegir la mejor zona candidata (la que menos ha recaudado)
        if (!zonasCandidatas.isEmpty()) {
            ZonaDeJuegos mejorZonaDestino = zonasCandidatas.get(0);
            for (ZonaDeJuegos zona : zonasCandidatas) {
                if (zona.getDineroRecaudado() < mejorZonaDestino.getDineroRecaudado()) {
                    mejorZonaDestino = zona;
                }
            }
            return "Se recomienda mover la máquina " + maquinaReparada.getNombre() +
                   " a la zona " + mejorZonaDestino.getNombre() +
                   " ya que tiene menores ingresos y no cuenta con una máquina del tipo " +
                   maquinaReparada.getTipo() + ".";
        } else {
            return "No se recomienda mover la máquina " + maquinaReparada.getNombre() +
                   ". La zona actual tiene mejores ingresos o todas las otras zonas ya tienen una máquina del mismo tipo.";
        }
    }

    // Método auxiliar para verificar si una zona tiene una máquina del mismo tipo
    private boolean tieneMaquinaDelTipo(String tipo) {
        for (Maquina maquina : this.getMaquinas()) {
            if (maquina.getTipo().equals(tipo)) {
                return true;
            }
        }
        return false;
    }

    // Método auxiliar para obtener el promedio de ingresos de las máquinas en la zona actual
    private double obtenerPromedioIngresosMaquinas() {
        double totalDineroRecaudado = 0;
        int numeroDeMaquinas = this.getMaquinas().size();

        for (Maquina maquina : this.getMaquinas()) {
            totalDineroRecaudado += maquina.getDineroRecaudado();
        }

        return numeroDeMaquinas > 0 ? totalDineroRecaudado / numeroDeMaquinas : 0;
    }

    public boolean tieneMaquina(String tipoMaquina) {
        for (Maquina maquina : this.maquinas) {
            if (maquina.getTipo().equals(tipoMaquina)) {
                return true;
            }
        }
        return false;
    }

    public Cine getCine() {
        return cine;
    }

    public void setCine(Cine cine) {
        this.cine = cine;
    }

    @Override
    public void aplicarPromocion() {
        // Implementación específica de la ZonaDeJuegos si es necesario
        System.out.println("Aplicando promoción en la zona de juegos " + getNombre() + ".");
    }

    @Override
    public String toString() {
        return "ZonaDeJuegos: " + nombre + ", Horario: " + horario + ", Máquinas: " + maquinas.size();
    }
    
    public static void cargarZonasDeJuegos() {
        // Utiliza el Deserializador para cargar la lista de cines desde el archivo
        ArrayList<ZonaDeJuegos> listaZonas = Deserializador.deserializarZonasDeJuegos();

        if (listaZonas != null) {
            // Reemplaza la lista estática de cines con la lista deserializada
            zonasDeJuegos = listaZonas;
            
        } else {
            Interfaz.error();
        }
    }

    public static void guardarZonasDeJuegos() {
        Serializador.serializarZonaDeJuegos(zonasDeJuegos);
    }
}



