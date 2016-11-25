package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Clase para obtener la conexión 
 * @author luiscobian
 */
public class Conexion {
    
    private static final String url = 
    "jdbc:mysql://localhost:3306/dbempleados";
    private static final String usuario = "root"; 
    private static final String pass = "root"; 
    private static Connection  con = null; 
    
    private Conexion() {} 
    
    public static Connection getConexion(){
        try {
           if(con == null )
           {    
               Runtime.getRuntime()
                       .addShutdownHook(
                               new Cerrar());
               Class.forName
                  ("com.mysql.jdbc.Driver");
               con = DriverManager
                       .getConnection
                        (url,usuario,pass);
               System.out.println("Conecto");
           }
           return con;
        } catch (Exception e) {
            System.out.println
            ("Error al conectar");
            e.printStackTrace();
            return null; 
        }
    }

    static class Cerrar extends Thread {
    
    @Override 
    public void run () {
        try {
            Connection con = Conexion
                    .getConexion();
            con.close();
        } catch (Exception e) {
            System.out.println("Error al cerrar");
        }
    }
}

    
}

