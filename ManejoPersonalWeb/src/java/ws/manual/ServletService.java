package ws.manual;

import dao.OperacionesEmpleado;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
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
            for (Empleado emp : datos) {
                if (ban) {
                    out.println(",");
                }
                out.println("{");
                out.println("\"id\":\"" + emp.getIdEmpleado()
                        + "\",");
                out.println("\"nombre\":\" " + emp.getNombre()
                        + "\",");
                out.println("\"puesto\":\"" + emp.getPuesto()
                        + "\",");
                out.println("\"fecha\":\"" + emp.getFecha()
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

        System.out.println("Se hizo una peticion POST");
        /// 
        String json = ""; 
        try {
            BufferedReader br = new BufferedReader
                          (new InputStreamReader
                          (request.getInputStream()));
            if(br!=null)
                json = br.readLine(); 
        } catch (Exception e) {
            System.out.println("Ocurrio un error al leer");
        }
        System.out.println("json:" + json);
        
        JsonReader reader  = Json.createReader
                      (new StringReader(json)); 
        JsonObject obj = reader.readObject();
        reader.close();
        Empleado em = new Empleado(); 
        em.setIdEmpleado(Integer.parseInt(
                 obj.getString("id")));
        em.setNombre(obj.getString("nombre"));
        em.setPuesto(obj.getString("puesto")); 
        new OperacionesEmpleado().addEmpleado(em);
        System.out.println("Termino el proceso");
    }
}
