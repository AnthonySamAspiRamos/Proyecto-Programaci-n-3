
package Clases;

import proyectoprogra3.*;

public class NodoPI {
    private int Id_Informador;
    private String Horario;
    private Personal p;
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

    public Personal getP() {
        return p;
    }

    public void setP(Personal p) {
        this.p = p;
    }

    public NodoPI getSig() {
        return sig;
    }

    public void setSig(NodoPI sig) {
        this.sig = sig;
    }
    
    
}
