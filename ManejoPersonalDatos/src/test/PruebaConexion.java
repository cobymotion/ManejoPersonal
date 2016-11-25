package test;

import dao.OperacionesEmpleado;
import java.util.List;
import modelo.Empleado;

public class PruebaConexion {
    
    public static void main(String[] args) {
       
        List<Empleado> datos = 
                new OperacionesEmpleado()
                        .getEmpleados();
        for (Empleado dato : datos) {
            System.out.println(dato.getNombre());
            System.out.println("-------");
        }
        
    }
    
}
