package ws.manual;

import dao.OperacionesEmpleado;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empleado;

@WebServlet(name = "ServletService", urlPatterns = {"/ws/servicio"})
public class ServletService extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        OperacionesEmpleado ope = new OperacionesEmpleado(); 
        List<Empleado> datos = ope.getEmpleados(); 
        
        response.setContentType("text/html");
       
        try {
            PrintWriter out = response.getWriter(); 
            out.println("[");
            boolean ban = false; 
            for(Empleado emp: datos) {
                if(ban)
                    out.println(",");
            out.println("{");
            out.println("\"id\":\"" + emp.getIdEmpleado() 
                    + "\",");
            out.println("\"nombre\":\" " + emp.getNombre()
                    + "\",");
            out.println("\"puesto\":\"" + emp.getPuesto()
                    + "\",");
            out.println("\"id\":\"" + emp.getFecha()
                    + "\"");
            out.println("}");
            ban = true;
            }
            out.println("]");
        } catch (Exception e) {
            System.out.println("Error al escrrbir");
        }
       
                
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
