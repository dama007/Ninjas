/*
 * Tortuga ninja
 */
package superninjas;

/**
 *
 * @author mfontana
 */
public class Tortuga {
    
    private String nombre;
    private double realizacion;
    private boolean registrado;

    public Tortuga(String nombre) {
        this.nombre = nombre;
        realizacion = 0;
        registrado = false;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public double getRealizacion() {
        return realizacion;
    }

    public void setRealizacion(double realizacion) {
        this.realizacion = realizacion;
    }


    public String getNombre() {
        return nombre;
    }

    
}
