package mx.edu.itstequila.empleados.empleadosapp;

/**
 * Created by luiscobian on 12/7/16.
 */

public class Empleado {

    private int id;
    private String nombre;

    @Override
    public String toString() {
        return " Datitos -> Empleado{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
