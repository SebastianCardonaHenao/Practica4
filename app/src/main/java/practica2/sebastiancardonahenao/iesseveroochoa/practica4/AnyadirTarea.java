package practica2.sebastiancardonahenao.iesseveroochoa.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AnyadirTarea extends AppCompatActivity {

    Spinner categorias,estados,prioridad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anyadir_tarea);

        categorias = (Spinner)findViewById(R.id.spCat);
        ArrayAdapter<CharSequence> adapterCat = ArrayAdapter.createFromResource(this,
                R.array.categoria, android.R.layout.simple_spinner_item);
        categorias.setAdapter(adapterCat);

        estados = (Spinner) findViewById(R.id.spEstado);
        ArrayAdapter<CharSequence> adapterEst = ArrayAdapter.createFromResource(this,
                R.array.estado, android.R.layout.simple_spinner_item);
        estados.setAdapter(adapterEst);

        prioridad = (Spinner) findViewById(R.id.spPrio);
        ArrayAdapter<CharSequence> adapterPrio = ArrayAdapter.createFromResource(this,
                R.array.prioridad, android.R.layout.simple_spinner_item);
        prioridad.setAdapter(adapterPrio);
        prioridad.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent,
                                               android.view.View v, int position, long id) {
                        String ele=(String) parent.getItemAtPosition(position);
                        Toast.makeText(getApplicationContext(),getString(R.string.msg_seleccion)+ ele,Toast.LENGTH_LONG).show();
                    }

                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
    }


}