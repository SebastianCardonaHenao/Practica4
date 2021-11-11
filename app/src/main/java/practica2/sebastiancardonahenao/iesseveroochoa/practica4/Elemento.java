package practica2.sebastiancardonahenao.iesseveroochoa.practica4;

import android.os.Parcel;
import android.os.Parcelable;

public class Elemento implements Parcelable {

    static int contador=1;
    private int id;
    private String estado;
    private String categoria;
    private String prioridad;
    private String tecnico;
    private String resumen;
    private String desc;

    public Elemento(int id, String estado, String categoria, String prioridad, String tecnico, String resumen, String desc) {
        this.id = id;
        this.estado = estado;
        this.categoria = categoria;
        this.prioridad = prioridad;
        this.tecnico = tecnico;
        this.resumen = resumen;
        this.desc = desc;
    }

    public Elemento(String estado, String categoria, String prioridad, String tecnico, String resumen, String desc) {
        this.estado = estado;
        this.categoria = categoria;
        this.prioridad = prioridad;
        this.tecnico = tecnico;
        this.resumen = resumen;
        this.desc = desc;
    }

    public int getId() {        return id;    }

    public void setId(int id) {        this.id = id;    }

    public String getEstado() {        return estado;    }

    public void setEstado(String estado) {        this.estado = estado;    }

    public String getCategoria() {        return categoria;    }

    public void setCategoria(String categoria) {        this.categoria = categoria;    }

    public String getPrioridad() {        return prioridad;    }

    public void setPrioridad(String prioridad) {        this.prioridad = prioridad;    }

    public String getTecnico() {        return tecnico;    }

    public void setTecnico(String tecnico) {        this.tecnico = tecnico;    }

    public String getResumen() {        return resumen;    }

    public void setResumen(String resumen) {        this.resumen = resumen;    }

    public String getDesc() {        return desc;    }

    public void setDesc(String desc) {        this.desc = desc;    }




////Parcelable//////

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.estado);
        dest.writeString(this.categoria);
        dest.writeString(this.prioridad);
        dest.writeString(this.tecnico);
        dest.writeString(this.resumen);
        dest.writeString(this.desc);
    }

    public void readFromParcel(Parcel source) {
        this.id = source.readInt();
        this.estado = source.readString();
        this.categoria = source.readString();
        this.prioridad = source.readString();
        this.tecnico = source.readString();
        this.resumen = source.readString();
        this.desc = source.readString();
    }

    protected Elemento(Parcel in) {
        this.id = in.readInt();
        this.estado = in.readString();
        this.categoria = in.readString();
        this.prioridad = in.readString();
        this.tecnico = in.readString();
        this.resumen = in.readString();
        this.desc = in.readString();
    }

    public static final Creator<Elemento> CREATOR = new Creator<Elemento>() {
        @Override
        public Elemento createFromParcel(Parcel source) {
            return new Elemento(source);
        }

        @Override
        public Elemento[] newArray(int size) {
            return new Elemento[size];
        }
    };
}
