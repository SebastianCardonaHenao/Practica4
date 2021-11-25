package practica2.sebastiancardonahenao.iesseveroochoa.practica4.viewmodel;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import practica2.sebastiancardonahenao.iesseveroochoa.practica4.R;
import practica2.sebastiancardonahenao.iesseveroochoa.practica4.model.Tarea;

public class ListView extends AppCompatActivity {

    private int n = 1;
    private RecyclerView lvLista;
    private TareaVModelAdapter adapter;
    private LiveDataTareaViewModel liveDataTareaViewModel;

    @Override
    protected void onCreate(Bundle savedInstaceState) {
        super.onCreate(savedInstaceState);
        setContentView(R.layout.lista_view_model);
        lvLista = (ListView) findViewById(R.id.lv_Lista);
        liveDataTareaViewModel = new ViewModelProvider(this).get(LiveDataTareaViewModel.class);
        liveDataTareaViewModel.getUserList().observe(this, new Observer<List<Tarea>>() {
            @Override
            public void onChanged(List<Tarea> tareas) {
                if (adapter == null){
                    adapter=new TareaVModelAdapter(ListView.this,R.layout.item_tarea,(ArrayList<Tarea>) tareas);
                    lvLista.setAdapter(adapter);
                }else
                    adapter.setLista(tareas);
            }
        });

    }

}
