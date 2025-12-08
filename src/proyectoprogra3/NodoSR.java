package proyectoprogra3;

public class NodoSR {
    private int NroPuesto, IdFeria, Id_Componentes;
    
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
    
    @Override
    public String toString() {
        // Guardar separado por comas
        return NroPuesto + ";" +IdFeria + ";" + Id_Componentes;
    }

    public static NodoSR fromString(String linea) {
        String[] datos = linea.split(";");
        NodoSR n = new NodoSR();
        n.setNroPuesto(Integer.parseInt(datos[0]));
        n.setIdFeria(Integer.parseInt(datos[1]));
        n.setId_Componentes(Integer.parseInt(datos[2]));
        return n;
    }
}
