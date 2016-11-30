
package ws;

import dao.OperacionesEmpleado;
import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import modelo.Empleado;

/**
 *
 * @author luiscobian
 */
@Stateless
@Path("/ws")
public class Servicios {
    
    @GET
    @Produces("application/json")
    public List<Empleado> getDatos() {
        OperacionesEmpleado ope = new 
        OperacionesEmpleado();
        List<Empleado> datos = ope.getEmpleados(); 
        return datos;
    }
    
    
}
