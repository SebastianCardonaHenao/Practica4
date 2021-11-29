package practica2.sebastiancardonahenao.iesseveroochoa.practica4.adapters;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

import practica2.sebastiancardonahenao.iesseveroochoa.practica4.R;
import practica2.sebastiancardonahenao.iesseveroochoa.practica4.model.Tarea;

public class TareasAdapter extends RecyclerView.Adapter<TareasAdapter.TareaViewHolder> {

    private List<Tarea> listaTareas;
    private OnItemClickBorrarListener listenerBorrar;
    private OnItemClickTareaListener listenerClickTarea;

    @NonNull
    @Override
    public TareasAdapter.TareaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tarea,parent,false);
        return new TareaViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TareaViewHolder holder, int position) {
        if (listaTareas != null) {
            //recuperamos la nota a mostrar
            final Tarea tarea = listaTareas.get(position);
            //mostramos los datos;
            holder.tvResumen.setText(tarea.getId()+"-"+tarea.getResumen());
            holder.tvTecnico.setText(tarea.getTecnico());
            //en función del tipo de nota, mostramos un icono u otro
            switch (tarea.getEstado()) {
                case "Abierta":
                    holder.ivEstado.setImageResource(R.drawable.abierto);
                    break;
                case "En curso":
                    holder.ivEstado.setImageResource(R.drawable.en_curso);
                    break;
                case "Terminada":
                    holder.ivEstado.setImageResource(R.drawable.hecho);
            }
            /**switch (tarea.getPrioridad()) {
                case "Alta":
                    holder.lytItem.setBackgroundResource(R.color.Alta);
                    break;
                case "Media":
                    holder.lytItem.setBackgroundResource(R.color.Media);
                    break;
                case "Baja":
                    holder.lytItem.setBackgroundResource(R.color.Baja);
                    break;
            }*/
        }
    }

    public void setListaTareas(List<Tarea> tareas){
        listaTareas = tareas;
        notifyDataSetChanged(); //Notifica el cambio para recargar la lista
    }

    public interface OnItemClickBorrarListener {
        void onItemClickBorrar(Tarea tarea);
    }
    public interface OnItemClickTareaListener{
        void onItemClickTarea(Tarea tarea);
    }


    public void setOnClickBorrarListener(OnItemClickBorrarListener listener) {
        this.listenerBorrar = listener;
    }
    public void setOnClickTareaListener(OnItemClickTareaListener listener) {
        this.listenerClickTarea = listener;
    }

    @Override
    public int getItemCount(){
        if(listaTareas != null)
            return listaTareas.size();
        else return 0;
    }

    public class TareaViewHolder extends RecyclerView.ViewHolder{
        private TextView tvResumen;
        private TextView tvTecnico;
        private ImageView ivEstado;
        private ImageView ivBorrar;
        private ImageView ivEditar;
        private ConstraintLayout lytItem;

        public TareaViewHolder(@NonNull View itemView){
            super(itemView);
            tvResumen = itemView.findViewById(R.id.resumen);
            tvTecnico = itemView.findViewById(R.id.tecnico);
            ivEstado = itemView.findViewById(R.id.imagenTarea);
            //lytItem = itemView.findViewById(R.id.lyt_Item);
            ivBorrar = itemView.findViewById(R.id.borrar);
            ivEditar = itemView.findViewById(R.id.editar);

            ivBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listenerBorrar!=null)
                        listenerBorrar.onItemClickBorrar(listaTareas.get(TareaViewHolder.this.getAbsoluteAdapterPosition()));
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (listenerClickTarea !=null)
                        listenerClickTarea.onItemClickTarea(listaTareas.get(TareaViewHolder.this.getAbsoluteAdapterPosition()));
                }
            });
        }
    }



}
