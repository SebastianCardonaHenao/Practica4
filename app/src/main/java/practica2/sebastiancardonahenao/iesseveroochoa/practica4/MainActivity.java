package practica2.sebastiancardonahenao.iesseveroochoa.practica4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

import practica2.sebastiancardonahenao.iesseveroochoa.practica4.adapters.TareasAdapter;
import practica2.sebastiancardonahenao.iesseveroochoa.practica4.model.*;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvLista;
    private TareaViewModel tareaViewModel;
    private TareasAdapter tareasAdapter;
    private int cuentaTreas =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvLista = findViewById(R.id.tareaRV);

        tareasAdapter = new TareasAdapter();
        rvLista.setLayoutManager(new LinearLayoutManager(this));
        rvLista.setAdapter(tareasAdapter);

        tareaViewModel = new ViewModelProvider(this).get(TareaViewModel.class);
        tareaViewModel.getUserList().observe(this, new Observer<List<Tarea>>() {
            @Override
            public void onChanged(List<Tarea> tareas) {
                tareasAdapter.setListaTareas(tareas);
            }
        });
    }

    public void accionBotones(View v) {
        Class claseActivity = null;
        switch (v.getId()) {
            case R.id.fab:
                claseActivity = AnyadirTarea.class;
                break;
        }
        Intent intent;
        intent = new Intent(this, claseActivity);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
                getMenuInflater().inflate(R.menu.menumain, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                tareaViewModel.addNota(new Tarea("Alguno","Otro","alta","Sebastián","DatoNuevo","Descripcion Nueva"));

                return true;
            case R.id.action_del:
                //tareaViewModel.delNota();
                return true;
            case R.id.action_acercade:
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoAlerta dialogo = new DialogoAlerta();
                dialogo.show(fragmentManager, "tagAlerta");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}