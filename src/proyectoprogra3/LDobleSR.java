package proyectoprogra3;

public class LDobleSR {
    private NodoSR p;
    
    public LDobleSR(){
        p=null;
    }

    public NodoSR getP() {
        return p;
    }

    public void setP(NodoSR p) {
        this.p = p;
    }
    
    public void adicionar(int np, int idf, int idmd, LSimplePR pa,LDobleJ ju) {
		NodoSR nue=new NodoSR();
		nue.setNroPuesto(np);
                nue.setIdFeria(idf);
                nue.setId_Componentes(idmd);
                nue.setLpr(pa);
                nue.setLj(ju);
		if(getP()==null) {
			setP(nue);
		}
		else {
			NodoSR y=getP();
			while(y.getSig()!=null) {
				y=y.getSig();
			}
			y.setSig(nue);
                        nue.setAnt(y);
		}
    }
    
    public void mostrar() {
		NodoSR w=getP();
		while(w!=null) {
			System.out.println("NroPuesto"+w.getNroPuesto()+" | Id Feria: "+w.getIdFeria()+" | Id Componentes"+w.getId_Componentes());
                        System.out.println("Datos de Promotores: ");
                        w.getLpr().mostrar();
                        System.out.println("Lista de Juegos: ");
                        w.getLj().mostrar();
			w=w.getSig();
		}
    }
}
