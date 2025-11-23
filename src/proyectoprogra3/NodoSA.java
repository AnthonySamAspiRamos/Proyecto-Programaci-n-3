package proyectoprogra3;

public class NodoSA {
    private int NroPuesto, IdFeria, Id_MedicamentosDispo;
    private LSimplePA lpa;
    private PilaInsD pid;
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

    public int getId_MedicamentosDispo() {
        return Id_MedicamentosDispo;
    }

    public void setId_MedicamentosDispo(int Id_MedicamentosDispo) {
        this.Id_MedicamentosDispo = Id_MedicamentosDispo;
    }

    public LSimplePA getLpa() {
        return lpa;
    }

    public void setLpa(LSimplePA lpa) {
        this.lpa = lpa;
    }

    public PilaInsD getPid() {
        return pid;
    }

    public void setPid(PilaInsD pid) {
        this.pid = pid;
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
    
}
