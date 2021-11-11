package practica2.sebastiancardonahenao.iesseveroochoa.practica4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import practica2.sebastiancardonahenao.iesseveroochoa.practica4.model.*;

public class MainActivity extends AppCompatActivity {

    TareasAdapter adaptadorLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                adaptadorLista.addElemento(new Tarea("sin hacer","Prueba","Máxima","Sebastián","DatoNuevo","Descripcion Nueva"));

                return true;
            case R.id.action_del:
                adaptadorLista.delElemento();
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