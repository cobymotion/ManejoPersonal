package mx.edu.itstequila.empleados.empleadosapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityAddEmpleado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_empleado);
    }


    public void guardarDatos(View cv){
        TextView txt = (TextView) findViewById(R.id.editText);
        Empleado em = new Empleado();
        em.setId(0);
        em.setNombre(txt.getText().toString());
        ConsumoWebService com = new ConsumoWebService();
        boolean res = com.addEmpleado(em);
        Log.e("datos",em.toString());
        if(res)
        {
            Toast.makeText(this,"Se grabo",Toast.LENGTH_LONG).show();
        }
    }
}
