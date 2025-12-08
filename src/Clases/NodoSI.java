package Clases;

import proyectoprogra3.*;

public class NodoSI {
    private int NroPuesto, IdFeria, Id_Componentes;
    private LSimplePI pi;
    private NodoSI ant,sig;
    
    public NodoSI(){
        ant=sig=null;
    }

    public int getNroPuesto() {
        return NroPuesto;
    }

    public void setNroPuesto(int NroPuesto) {
        this.NroPuesto = NroPuesto;
    }

    public int getIdFeria() {
        return IdFeria;
    }

    public void setIdFeria(int IdFeria) {
        this.IdFeria = IdFeria;
    }

    public int getId_Componentes() {
        return Id_Componentes;
    }

    public void setId_Componentes(int Id_Componentes) {
        this.Id_Componentes = Id_Componentes;
    }

    public LSimplePI getPi() {
        return pi;
    }

    public void setPi(LSimplePI pi) {
        this.pi = pi;
    }

    public NodoSI getAnt() {
        return ant;
    }

    public void setAnt(NodoSI ant) {
        this.ant = ant;
    }

    public NodoSI getSig() {
        return sig;
    }

    public void setSig(NodoSI sig) {
        this.sig = sig;
    }
    
}
