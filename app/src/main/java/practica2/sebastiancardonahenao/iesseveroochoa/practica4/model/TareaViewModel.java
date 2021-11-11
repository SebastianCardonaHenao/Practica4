package practica2.sebastiancardonahenao.iesseveroochoa.practica4.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TareaViewModel {
    //si queremos que la actividad reciba un aviso cuando se modifican los datos, tenemos que crear
    //un LiveData(https://developer.android.com/topic/libraries/architecture/livedata)
    //
    private MutableLiveData<List<Tarea>> listaTareasLiveData;

    private List<Tarea> listaTareas;

    public TareaViewModel(@NonNull Application application) {
        super(application);
        //el liveData nos permitirá recibir notificaciones  en la actividad cuando se modifique la lista
        listaTareasLiveData=new MutableLiveData<List<Tarea>>();
        //creamos unos datos de ejemplo
        crearDatos();
        //avisamos de la modificación con el LiveData
        listaTareasLiveData.setValue(listaTareas);
    }
    public void addNota(Tarea tarea){
        //añadimos una Nota a la lista, si existe(mismo id), la sustituimos
        int i=listaTareas.indexOf(tarea);
        if(i<0)
            listaTareas.add(tarea);
        else{
            listaTareas.remove(i);
            listaTareas.add(i,tarea);
        }
        //avisamos al LiveData para que active el Observer y la actividad muestre los cambios
        listaTareasLiveData.setValue(listaTareas);
    }
    /*
    Eliminamos la nota por id
     */
    public void delNota(Tarea nota){
        if(listaTareas.size()>0){
            listaTareas.remove(nota);
            //avisamos al LiveData para que active el Observer
            listaTareasLiveData.setValue(listaTareas);
        }
    }

    private void crearDatos() {

        listaTareas=new ArrayList<Tarea>();
        Tarea tarea=new Tarea("Alta","Mantenimiento","Abierta","Juan Perez","Actualización de antivirus","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris laoreet aliquam sapien, quis mattis diam pretium vel. Integer nec tincidunt turpis. Vestibulum interdum accumsan massa, sed blandit ex fringilla at. Vivamus non sem vitae nisl viverra pharetra. Pellentesque pulvinar vestibulum risus sit amet tempor. Sed blandit arcu sed risus interdum fermentum. Integer ornare lorem urna, eget consequat ante lacinia et. Phasellus ut diam et diam euismod convallis");
                listaTareas.add(tarea);
        tarea=new Tarea("Media","Mantenimiento","Terminada","Maria Perez","Actualización de S.O.Linux","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris laoreet aliquam sapien, quis mattis diam pretium vel. Integer nec tincidunt turpis. Vestibulum interdum accumsan massa, sed blandit ex fringilla at. Vivamus non sem vitae nisl viverra pharetra. Pellentesque pulvinar vestibulum risus sit amet tempor. Sed blandit arcu sed risus interdum fermentum. Integer ornare lorem urna, eget consequat ante lacinia et. Phasellus ut diam et diam euismod convallis");
                listaTareas.add(tarea);
        tarea=new Tarea("Baja","Reparación","En curso","Maria Lopez","Sustitución de ratones","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris laoreet aliquam sapien, quis mattis diam pretium vel. Integer nec tincidunt turpis. Vestibulum interdum accumsan massa, sed blandit ex fringilla at. Vivamus non sem vitae nisl viverra pharetra. Pellentesque pulvinar vestibulum risus sit amet tempor. Sed blandit arcu sed risus interdum fermentum. Integer ornare lorem urna, eget consequat ante lacinia et. Phasellus ut diam et diam euismod convallis");
                listaTareas.add(tarea);
        tarea=new Tarea("Media","Comercial","Abierta","Fele Martinez","Presentar presupuesto Web","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris laoreet aliquam sapien, quis mattis diam pretium vel. Integer nec tincidunt turpis. Vestibulum interdum 9accumsan massa, sed blandit ex fringilla at. Vivamus non sem vitae nisl viverra pharetra. Pellentesque pulvinar vestibulum risus sit amet tempor.Sed blandit arcu sed risus interdum fermentum. Integer ornare lorem urna, eget consequat ante lacinia et. Phasellus ut diam et diam euismod convallis");
                listaTareas.add(tarea);
        tarea=new Tarea("Media","Comercial","Abierta","Fele Martinez","Presentar presupuesto Web","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris laoreet aliquam sapien, quis mattis diam pretium vel. Integer nec tincidunt turpis. Vestibulum interdum accumsan massa, sed blandit ex fringilla at. Vivamus non sem vitae nisl viverra pharetra. Pellentesque pulvinar vestibulum risus sit amet tempor.Sed blandit arcu sed risus interdum fermentum. Integer ornare lorem urna, eget consequat ante lacinia et. Phasellus ut diam et diam euismod convallis");
                listaTareas.add(tarea);
    }

}