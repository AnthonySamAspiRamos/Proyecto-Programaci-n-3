
package proyectoprogra3;

public class LDobleSI {
    private NodoSI p;
    
    public LDobleSI(){
        p=null;
    }

    public NodoSI getP() {
        return p;
    }

    public void setP(NodoSI p) {
        this.p = p;
    }
    public void adicionar(int np, int idf, int idc) {
		NodoSI nue=new NodoSI();
		nue.setNroPuesto(np);
                nue.setIdFeria(idf);
                nue.setId_Componentes(idc);
		if(getP()==null) {
			setP(nue);
		}
		else {
			NodoSI y=getP();
			while(y.getSig()!=null) {
				y=y.getSig();
			}
			y.setSig(nue);
                        nue.setAnt(y);
		}
    }
    
    public void mostrar() {
		NodoSI w=getP();
		while(w!=null) {
			System.out.println("NroPuesto"+w.getNroPuesto()+" | Id Feria: "+w.getIdFeria()+" | Id Componentes: "+w.getId_Componentes());
                        w=w.getSig();
		}
    }
}
