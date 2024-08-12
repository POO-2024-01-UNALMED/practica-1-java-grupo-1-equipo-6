package gestorAplicacion;


public class Establecimiento {
    protected String nombre;
    protected double dineroRecaudado;

    public Establecimiento(String nombre) {
        this.nombre = nombre;
        this.dineroRecaudado = 0;
    }

   public void setDineroRecaudado(double dinero) {
	   dineroRecaudado=dinero;
   }

    public double getDineroRecaudado() {
        return dineroRecaudado;
    }

    public String getNombre() {
        return nombre;
    }

    public void aplicarPromocion() {
        // Método genérico para aplicar promociones, puede ser sobrescrito en las clases hijas.
        System.out.println("Se ha aplicado una promoción en el establecimiento " + nombre + ".");
    }
}
