package mx.edu.itstequila.empleados.empleadosapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // permiso para uso de la red de datos
        StrictMode.setThreadPolicy(
                new StrictMode.ThreadPolicy.Builder()
                        .permitNetwork().build());
    }

    public void traerDatos(View v){
        ConsumoWebService consumo =
                new ConsumoWebService();
        List<Empleado> datos = consumo.getDatos();
        TextView texto = (TextView) findViewById(R.id.textView);
        texto.setText(datos.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.create_new:
                Intent i = new Intent(this,ActivityAddEmpleado.class);
                startActivity(i);
        }
        return true;
    }
}
