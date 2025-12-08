package Clases;

import proyectoprogra3.*;

public class NodoSR {
    private int NroPuesto, IdFeria, Id_Componentes;
    private LSimplePR lpr;
    private LDobleJ lj;
    private NodoSR sig,ant;
    
    public NodoSR(){
        sig=ant=null;
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

    public LSimplePR getLpr() {
        return lpr;
    }

    public void setLpr(LSimplePR lpr) {
        this.lpr = lpr;
    }

    public LDobleJ getLj() {
        return lj;
    }

    public void setLj(LDobleJ lj) {
        this.lj = lj;
    }

    public NodoSR getSig() {
        return sig;
    }

    public void setSig(NodoSR sig) {
        this.sig = sig;
    }

    public NodoSR getAnt() {
        return ant;
    }

    public void setAnt(NodoSR ant) {
        this.ant = ant;
    }
    
}
