package gestorAplicacion;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public abstract class Establecimiento implements Serializable  {
    
	private static final long serialVersionUID = 4L;
	
	protected String nombre;
    protected double dineroRecaudado;

    public Establecimiento(String nombre) {
        this.nombre = nombre;
        this.dineroRecaudado = 0;
    }

    public void setDineroRecaudado(double dinero) {
        dineroRecaudado = dinero;
    }

    public double getDineroRecaudado() {
        return dineroRecaudado;
    }

    public String getNombre() {
        return nombre;
    }

    // Método abstracto para aplicar promociones
    public abstract void aplicarPromocion();

    @Override
    public String toString() {
        return "Establecimiento: " + nombre + ", Dinero Recaudado: " + dineroRecaudado;
    }
}

