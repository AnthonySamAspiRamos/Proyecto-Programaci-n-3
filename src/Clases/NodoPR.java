package Clases;

import proyectoprogra3.*;

public class NodoPR {
    private int Id_Promotor;
    private String Horario;
    private Personal p;
    private NodoPR sig;
    
    NodoPR(){
        sig=null;
    }

    public int getId_Promotor() {
        return Id_Promotor;
    }

    public void setId_Promotor(int Id_Promotor) {
        this.Id_Promotor = Id_Promotor;
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

    public NodoPR getSig() {
        return sig;
    }

    public void setSig(NodoPR sig) {
        this.sig = sig;
    }
    
}
