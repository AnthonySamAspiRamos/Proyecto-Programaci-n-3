
package proyectoprogra3;

public class NodoPI {
    private int Id_Informador;
    private String Horario;
    private int NroPuesto,id_feria;
    private NodoPI sig;
    
    public NodoPI(){
        sig=null;
    }

    public int getId_Informador() {
        return Id_Informador;
    }

    public void setId_Informador(int Id_Informador) {
        this.Id_Informador = Id_Informador;
    }

    public String getHorario() {
        return Horario;
    }

    public void setHorario(String Horario) {
        this.Horario = Horario;
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
    
    

    public NodoPI getSig() {
        return sig;
    }

    public void setSig(NodoPI sig) {
        this.sig = sig;
    }
    
    @Override
    public String toString() {
        // Guardar separado por comas
        return Id_Informador + ";" + Horario + ";" + NroPuesto + ";" + id_feria;
    }

    public static NodoPI fromString(String linea) {
        String[] datos = linea.split(";");
        NodoPI n = new NodoPI();
        n.setId_Informador(Integer.parseInt(datos[0]));
        n.setHorario(datos[1]);
        n.setNroPuesto(Integer.parseInt(datos[2]));
        n.setId_feria(Integer.parseInt(datos[3]));
        return n;
    }
}
