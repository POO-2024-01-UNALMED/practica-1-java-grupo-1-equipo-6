package gestorAplicacion;

public class Maquina {
    private String nombre;
    private int usos;
    private int materialesNecesarios;
    private boolean disponible;
    private double dineroRecaudado;
    private double precioUso;

    public Maquina(String nombre, int materialesNecesarios, double precioUso) {
        this.nombre = nombre;
        this.materialesNecesarios = materialesNecesarios;
        this.disponible = true;
        this.dineroRecaudado = 0;
        this.precioUso = precioUso;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public boolean necesitaMantenimiento() {
        return usos >= 50;
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
}
