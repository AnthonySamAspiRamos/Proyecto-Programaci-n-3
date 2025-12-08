package proyectoprogra3;

public class NodoSA {
    private int NroPuesto, IdFeria, idInstrumentosDoc;
    
    private NodoSA  sig, ant;
    
    public NodoSA(){
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

    public int getIdInstrumentosDoc() {
        return idInstrumentosDoc;
    }

    public void setIdInstrumentosDoc(int idInstrumentosDoc) {
        this.idInstrumentosDoc = idInstrumentosDoc;
    }



    public NodoSA getSig() {
        return sig;
    }

    public void setSig(NodoSA sig) {
        this.sig = sig;
    }

    public NodoSA getAnt() {
        return ant;
    }

    public void setAnt(NodoSA ant) {
        this.ant = ant;
    }
    @Override
    public String toString() {
        // Guardar separado por comas
        return NroPuesto + ";" +IdFeria + ";" + getIdInstrumentosDoc();
    }

    public static NodoSA fromString(String linea) {
        String[] datos = linea.split(";");
        NodoSA n = new NodoSA();
        n.setNroPuesto(Integer.parseInt(datos[0]));
        n.setIdFeria(Integer.parseInt(datos[1]));
        n.setIdInstrumentosDoc(Integer.parseInt(datos[2]));
        return n;
    }
}
