package practica2.sebastiancardonahenao.iesseveroochoa.practica4;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.DialogInterface;
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
    private Tarea tareaEnviar=null;

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

        tareasAdapter.setOnClickBorrarListener(new TareasAdapter.OnItemClickBorrarListener() {
            @Override
            public void onItemClickBorrar(Tarea tarea) {
                //mostramos un dialogo para preguntar si borramos y
                //llamamos al ViewModel para que actualice la lista
                borrarTarea(tarea);
            }
        });

        tareasAdapter.setOnClickTareaListener(new TareasAdapter.OnItemClickTareaListener() {
            @Override
            public void onItemClickTarea(Tarea tarea) {
                verTarea(tarea);
            }
        });

        tareasAdapter.setOnClickEditarLister(new TareasAdapter.OnIntemEditarListener() {
            @Override
            public void onItemEditar(Tarea tarea) {
                editarTarea(tarea);
            }
        });
    }

    private void editarTarea(Tarea tarea) {
        Intent i = new Intent(this, AnyadirTarea.class);
        i.putExtra("Datos",tarea);
        mStartForResultTarea2.launch(i);

    }

    public void accionBotones(View v) {
        Intent i = new Intent(this, AnyadirTarea.class);
        i.putExtra("Datos",tareaEnviar);
        mStartForResultTarea.launch(i);
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
                tareaViewModel.addNota(new Tarea("Abierta","Otros","Alta","Sebastián","DatoNuevo","Descripcion Nueva"));

                return true;
            case R.id.action_del:
                tareaViewModel.delNota();
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

    ActivityResultLauncher<Intent> mStartForResultTarea= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //si el usuario pulsa OK en la Activity que hemos llamado
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //recuperamos los dados
                        Intent intent = result.getData();
                        Tarea tarea = intent.getExtras().getParcelable("Datos");
                        tareaViewModel.addNota(tarea);
                    }
                }
            });

    ActivityResultLauncher<Intent> mStartForResultTarea2= registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    //si el usuario pulsa OK en la Activity que hemos llamado
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        //recuperamos los dados
                        Intent intent = result.getData();
                        Tarea tarea = intent.getExtras().getParcelable("Datos");
                        tareasAdapter.notify();

                        ///AGGGGGGGGGGGGGGGGGG ESTO ES IMPOSIBLEE
                    }
                }
            });



    private void borrarTarea(final Tarea tarea) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle("Aviso");// titulo y mensaje

        dialogo.setMessage("Está seguro que desea eliminar la tarea con id "+tarea.getId());
// agregamos botón Ok y su evento
        dialogo.setPositiveButton(android.R.string.yes
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Qué hacemos en caso ok
                        tareaViewModel.delNota(tarea);                    }
                });
        dialogo.setNegativeButton(android.R.string.no
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Qué hacemos en caso cancel
                    }
                });
        dialogo.show();
    }

    private void verTarea(Tarea tarea) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(MainActivity.this);
        dialogo.setTitle(tarea.getTecnico());// titulo y mensaje

        dialogo.setMessage(tarea.getDesc());
// agregamos botón Ok y su evento
        dialogo.setPositiveButton(android.R.string.ok
                , new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Qué hacemos en caso ok
                    }
                });
        dialogo.show();
    }

}