package practica2.sebastiancardonahenao.iesseveroochoa.practica4.model;
import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class TareasAdapter extends ArrayAdapter<Tarea> {

    ArrayList<Tarea> alLista;

    public TareasAdapter(Context context, int resource, ArrayList<Tarea> elementos) {
        super(context, resource, elementos);
        alLista = elementos;
    }

    public ArrayList<Tarea> getAlLista() {        return alLista;    }

    public void addElemento(Tarea elemento) {
        alLista.add(elemento);
        //Avisa al adaptador que ha cambiado el origen de datos
        this.notifyDataSetChanged();
    }

    /**
     * Nos permite eliminar elementos de la lista. Por sencillez del
     * ejemplo eliminamos el primer elemento.
     */
    public void delElemento() {
        alLista.remove(0);
        this.notifyDataSetChanged();
    }

}
