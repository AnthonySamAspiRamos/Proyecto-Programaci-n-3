package proyectoprogra3;

public class NodoPR {
    private int id_recreacionista;
    private String Horario;
    private int NroPuesto,id_feria;
    private NodoPR sig;
    
    public NodoPR(){
        sig=null;
    }

    public int getId_recreacionista() {
        return id_recreacionista;
    }

    public void setId_recreacionista(int id_recreacionista) {
        this.id_recreacionista = id_recreacionista;
    }

    public int getNroPuesto() {
        return NroPuesto;
    }

    public void setNroPuesto(int NroPuesto) {
        this.NroPuesto = NroPuesto;
    }

    public int getId_feria() {
        return id_feria;
    }

    public void setId_feria(int id_feria) {
        this.id_feria = id_feria;
    }

    

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
    }

   

    public NodoPR getSig() {
        return sig;
    }

    public void setSig(NodoPR sig) {
        this.sig = sig;
    }
    
    @Override
    public String toString() {
        // Guardar separado por comas
        return id_recreacionista + ";" + Horario + ";" + NroPuesto + ";" + id_feria;
    }

    public static NodoPR fromString(String linea) {
        String[] datos = linea.split(";");
        NodoPR n = new NodoPR();
        n.setId_recreacionista(Integer.parseInt(datos[0]));
        n.setHorario(datos[1]);
        n.setNroPuesto(Integer.parseInt(datos[2]));
        n.setId_feria(Integer.parseInt(datos[3]));
        return n;
    }
}
