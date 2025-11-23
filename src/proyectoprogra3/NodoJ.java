package proyectoprogra3;

public class NodoJ {
    private String nombre, tiempo, descripcion;
    private int participaciones;
    private NodoJ sig, ant;
    
    public NodoJ(){
        sig=ant=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getParticipaciones() {
        return participaciones;
    }

    public void setParticipaciones(int participaciones) {
        this.participaciones = participaciones;
    }

    public NodoJ getSig() {
        return sig;
    }

    public void setSig(NodoJ sig) {
        this.sig = sig;
    }

    public NodoJ getAnt() {
        return ant;
    }

    public void setAnt(NodoJ ant) {
        this.ant = ant;
    }
    
    
}
