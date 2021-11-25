package practica2.sebastiancardonahenao.iesseveroochoa.practica4.viewmodel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import practica2.sebastiancardonahenao.iesseveroochoa.practica4.R;
import practica2.sebastiancardonahenao.iesseveroochoa.practica4.model.Tarea;

public class TareaVModelAdapter extends ArrayAdapter<Tarea> {

    List<Tarea> alLista;

    public TareaVModelAdapter(Context context, int resource, ArrayList<Tarea> lista){
        super(context,resource,lista);
        alLista=lista;
    }

    public void setLista(List<Tarea> alLista){
        this.alLista=alLista;
        notifyDataSetChanged(); //Actualiza el listview
    }

    public View getView(int posicion, View convertView, ViewGroup parent){
        View item = convertView;
        //Comprobamos si ya hay un layout y si no creamos uno
        if (item == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.item_tarea, null);
        }
        Tarea tarea = alLista.get(posicion);
        //Usamos el ViewHolder (Patrón)
        TextView tv_v1 = (TextView) item.findViewById(R.id.tituloTarea);
        tv_v1.setText(tarea.getCategoria());
        TextView tv_v2 = (TextView) item.findViewById(R.id.breveDescripcion);
        tv_v2.setText(tarea.getResumen());
        return item;
    }
}
