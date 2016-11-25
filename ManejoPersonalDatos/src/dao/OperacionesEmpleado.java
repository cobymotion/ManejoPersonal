package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.Empleado;

/**
 * Clase para acceder a los datos 
 * @author luiscobian
 */
public class OperacionesEmpleado {
    
    public void addEmpleado(Empleado empleado)
    {
        Connection con = Conexion.getConexion(); 
        PreparedStatement ps = null ; 
        try {
            String sql = "INSERT INTO empleados "
                    + "VALUES(0,?,?,now())";
            ps = con.prepareCall(sql); 
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getPuesto());
            ps.executeUpdate();
            System.out.println("Se grabo");
        } catch (Exception e) {
            System.out.println("Error al guardar");
        }
    }
    public List<Empleado> getEmpleados() {
        Connection con = Conexion.getConexion(); 
        List<Empleado> lista = 
                new ArrayList<>();
        PreparedStatement ps=null; 
        try {
            String sql = "SELECT * FROM empleados";
            ps = con.prepareCall(sql);
            ResultSet datos = ps.executeQuery();
            while(datos.next()){
                Empleado em = new Empleado(); 
                em.setIdEmpleado(datos.getInt(1));
                em.setNombre(datos.getString(2));
                em.setPuesto(datos.getString(3));
                em.setFecha(datos.getDate(4));
                lista.add(em);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar");
        }
        
        return lista;
    }
    
}
