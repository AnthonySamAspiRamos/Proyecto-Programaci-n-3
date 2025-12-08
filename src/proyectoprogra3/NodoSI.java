package proyectoprogra3;

public class NodoSI {
    private int NroPuesto, IdFeria, Id_Componentes;

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
    @Override
    public String toString() {
        // Guardar separado por comas
        return NroPuesto + ";" +IdFeria + ";" + Id_Componentes;
    }

    public static NodoSI fromString(String linea) {
        String[] datos = linea.split(";");
        NodoSI n = new NodoSI();
        n.setNroPuesto(Integer.parseInt(datos[0]));
        n.setIdFeria(Integer.parseInt(datos[1]));
        n.setId_Componentes(Integer.parseInt(datos[2]));
        return n;
    }
}
