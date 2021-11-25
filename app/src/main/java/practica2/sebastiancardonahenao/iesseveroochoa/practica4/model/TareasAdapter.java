package practica2.sebastiancardonahenao.iesseveroochoa.practica4.model;
import android.content.Context;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class TareasAdapter extends ArrayAdapter<Tarea> {

    ArrayList<Tarea> listaTareas;

    private OnItemClickBorrarListener listenerBorrar;
    private OnItemClickElementoListener listenerClickElemento;

    public TareasAdapter(Context context, int resource, ArrayList<Tarea> elementos) {
        super(context, resource, elementos);
        listaTareas = elementos;
    }

    public ArrayList<Tarea> getListaTareas() {        return listaTareas;    }

    public void addElemento(Tarea elemento) {
        listaTareas.add(elemento);
        //Avisa al adaptador que ha cambiado el origen de datos
        this.notifyDataSetChanged();
    }

    /**
     * Nos permite eliminar elementos de la lista. Por sencillez del
     * ejemplo eliminamos el primer elemento.
     */
    public void delElemento() {
        listaTareas.remove(0);
        this.notifyDataSetChanged();
    }

    public interface OnItemClickBorrarListener{
        void onItemCLickBorrar(Tarea tarea);
    }
    public interface OnItemClickElementoListener{
        void onItemClickElementoListener(Tarea tarea);
    }

    public void setOnClickBorrarListener(OnItemClickBorrarListener listener) {
        this.listenerBorrar = listener;
    }
    public void setOnClickElementoListener(OnItemClickElementoListener listener) {
        this.listenerClickElemento = listener;
    }

}
