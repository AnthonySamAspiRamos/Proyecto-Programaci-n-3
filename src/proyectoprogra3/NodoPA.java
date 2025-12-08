package proyectoprogra3;

public class NodoPA {
    private int Id_Medico;
    private String Horario;
    private int NroPuesto,id_feria;
    private NodoPA sig;
    
    public NodoPA(){
        sig=null;
    }

    public int getId_Medico() {
        return Id_Medico;
    }

    public void setId_Medico(int Id_Medico) {
        this.Id_Medico = Id_Medico;
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

    @Override
    public String toString() {
        // Guardar separado por comas
        return Id_Medico + ";" + Horario + ";" + NroPuesto + ";" + id_feria;
    }

    public static NodoPA fromString(String linea) {
        String[] datos = linea.split(";");
        NodoPA n = new NodoPA();
        n.setId_Medico(Integer.parseInt(datos[0]));
        n.setHorario(datos[1]);
        n.setNroPuesto(Integer.parseInt(datos[2]));
        n.setId_feria(Integer.parseInt(datos[3]));
        return n;
    }

    public NodoPA getSig() {
        return sig;
    }

    public void setSig(NodoPA sig) {
        this.sig = sig;
    }
    
}
