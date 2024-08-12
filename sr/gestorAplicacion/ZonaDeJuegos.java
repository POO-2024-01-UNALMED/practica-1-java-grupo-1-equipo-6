package gestorAplicacion;
import java.util.ArrayList;
import java.util.List;


import java.util.ArrayList;
import java.util.List;

public class ZonaDeJuegos extends Establecimiento {
    private String horario;
    private List<Maquina> maquinas;

    public ZonaDeJuegos(String nombre, String horario) {
        super(nombre);
        this.horario = horario;
        this.maquinas = new ArrayList<>();
    }

    public void agregarMaquina(Maquina maquina) {
        maquinas.add(maquina);
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
        informe.append("Informe de la Zona de Juegos: ").append(getNombre()).append("\n");
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

    public String recomendarMovimiento(ZonaDeJuegos zonaDestino, Maquina maquinaReparada) {
        if (this.getDineroRecaudado() > zonaDestino.getDineroRecaudado() && !zonaDestino.tieneMaquina(maquinaReparada.getNombre())) {
            return "Se recomienda mover la máquina " + maquinaReparada.getNombre() + " a la zona " + zonaDestino.getNombre() + " ya que tiene menores ingresos y no cuenta con esta máquina.";
        } else {
            return "No se recomienda mover la máquina " + maquinaReparada.getNombre() + ", la zona actual tiene mejores ingresos o la zona destino ya tiene esta máquina.";
        }
    }

    public boolean tieneMaquina(String nombreMaquina) {
        for (Maquina maquina : maquinas) {
            if (maquina.getNombre().equals(nombreMaquina)) {
                return true;
            }
        }
        return false;
    }
}

