package modelo;

import java.util.Date;

/**
 * Clase para representar los datos de la 
 * tabla en la programación 
 * @author luiscobian
 */
public class Empleado {
    private int idEmpleado; 
    private String nombre; 
    private String puesto; 
    private Date fecha;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
