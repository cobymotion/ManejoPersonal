package mx.edu.itstequila.empleados.empleadosapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by luiscobian on 12/7/16.
 */

public class ConsumoWebService {


    private List<Empleado> procesaJSON(String res)
    {
        JSONArray jsonArray = null;
        List<Empleado> datos = new ArrayList<>();
        try{
            jsonArray = new JSONArray(res);
        }catch(JSONException e){
            Log.e("Error JSON","Esta mal formado");
        }
        try {
            for (int i = 0; i < jsonArray.length();i++)
            {
                JSONObject obj = jsonArray.getJSONObject(i);
                Empleado em = new Empleado();
                em.setId(Integer.parseInt(obj.getString("id")));
                em.setNombre(obj.getString("nombre"));
                datos.add(em);
            }
        }catch(Exception ee){}
        return datos;
    }

    //operaciones con el ws

    public List<Empleado> getDatos() {
        try{
            URL url = new URL
                    ("http://10.100.30.67:8080/empleados/ws/servicio");
            HttpURLConnection con = (HttpURLConnection) url
                    .openConnection();
            BufferedReader br = new BufferedReader(
                       new InputStreamReader
                               (con.getInputStream()));
            String linea = "", resultado ="";
            while((linea = br.readLine())!=null)
                resultado += linea;
            Log.e("Leido", resultado);
            List<Empleado> datos = procesaJSON(resultado);
            con.disconnect();
            return datos;
        }catch(Exception e){
            Log.e("Error",e.toString());
        }
        return null;
    }

    public boolean addEmpleado(Empleado empleado)
    {
        try {
            URL url =
                    new URL("http://10.100.30.67:8080/empleados/ws/servicio");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");

            String input = "{\"id\":\"0\",\"nombre\":\"" + empleado.getNombre() + "\",\"puesto\":\"" + "INFORMATICA" + "\"}";

            Log.e("JSON", input);
            OutputStream os = conn.getOutputStream();
            os.write(input.getBytes());
            os.flush();

            //Este codigo es por si ustedes quieren revisar alguna respuesta

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            Log.w("Output Server","Revisando salida");
            while ((output = br.readLine()) != null) {
                Log.w("Salida",output);
            }

            conn.disconnect();



            return true;
        }catch(Exception e)
        {
            Log.e("Eroror","Hay un error");
            return false;
        }

    }

}
