package proyectoprogra3;

public class LDobleSA {
    private NodoSA p;
    
    public LDobleSA(){
        p=null;
    }

    public NodoSA getP() {
        return p;
    }

    public void setP(NodoSA p) {
        this.p = p;
    }
    public void adicionar(int np, int idf, int idmd, LSimplePA pa) {
		NodoSA nue=new NodoSA();
		nue.setNroPuesto(np);
                nue.setIdFeria(idf);
                nue.setId_MedicamentosDispo(idmd);
                nue.setLpa(pa);
		if(getP()==null) {
			setP(nue);
		}
		else {
			NodoSA y=getP();
			while(y.getSig()!=null) {
				y=y.getSig();
			}
			y.setSig(nue);
                        nue.setAnt(y);
		}
    }
    
    public void mostrar() {
		NodoSA w=getP();
		while(w!=null) {
			System.out.println("NroPuesto"+w.getNroPuesto()+" | Id Feria: "+w.getIdFeria()+" | Id Medicamentos Disponibles: "+w.getId_MedicamentosDispo());
                        System.out.println("Datos de Medicos: ");
                        w.getLpa().mostrar();
			w=w.getSig();
		}
    }
}
