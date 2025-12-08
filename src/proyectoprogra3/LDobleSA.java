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
    public void adicionar(int np, int idf,int idins) {
		NodoSA nue=new NodoSA();
		nue.setNroPuesto(np);
                nue.setIdFeria(idf);
                nue.setIdInstrumentosDoc(idins);
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
			System.out.println("NroPuesto"+w.getNroPuesto()+" | Id Feria: "+w.getIdFeria()+" | Id instrumentos: "+w.getIdInstrumentosDoc());
                        
			w=w.getSig();
		}
    }
}
