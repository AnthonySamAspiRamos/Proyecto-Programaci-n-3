package proyectoprogra3;

public class NodoPA {
    private int Id_Medico;
    private String Horario;
    private Personal p;
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

    public Personal getP() {
        return p;
    }

    public void setP(Personal p) {
        this.p = p;
    }

    public NodoPA getSig() {
        return sig;
    }

    public void setSig(NodoPA sig) {
        this.sig = sig;
    }
    
}
