package proyectoprogra3;

public class LSimplePI {
    private NodoPI p;
    
    public LSimplePI(){
        p=null;
    }

    public NodoPI getP() {
        return p;
    }

    public void setP(NodoPI p) {
        this.p = p;
    }
    
    public void adicionar(int i, String h, int nrop,int idf ) {
		NodoPI nue=new NodoPI();
		nue.setId_Informador(i);
                nue.setHorario(h);
                nue.setNroPuesto(nrop);
                nue.setId_feria(idf);
		if(getP()==null) {
			setP(nue);
		}
		else {
			NodoPI y=getP();
			while(y.getSig()!=null) {
				y=y.getSig();
			}
			y.setSig(nue);
		}
    }
    
    public void mostrar() {
		NodoPI w=getP();
		while(w!=null) {
			System.out.println("Id Informador: "+w.getId_Informador()+" | Horario: "+w.getHorario()+" | NroPuesto: "+w.getNroPuesto()+" | idFeria: "+w.getId_feria());
                        
                        
			w=w.getSig();
		}
    }
    
}
