package proyectoprogra3;

public class LSimplePA {
    private NodoPA p;
    
    public LSimplePA(){
       p=null;
    }

    public NodoPA getP() {
        return p;
    }

    public void setP(NodoPA p) {
        this.p = p;
    }
    public void adicionar(int i, String h,  int nrop,int idf ) {
		NodoPA nue=new NodoPA();
		nue.setId_Medico(i);
                nue.setHorario(h);
                nue.setNroPuesto(nrop);
                nue.setId_feria(idf);
		if(getP()==null) {
			setP(nue);
		}
		else {
			NodoPA y=getP();
			while(y.getSig()!=null) {
				y=y.getSig();
			}
			y.setSig(nue);
		}
    }
    
    public void mostrar() {
		NodoPA w=getP();
		while(w!=null) {
			System.out.println("Id Medico: "+w.getId_Medico()+" | Horario: "+w.getHorario()+" | NroPuesto: "+w.getNroPuesto()+" | idFeria: "+w.getId_feria());
                        
			w=w.getSig();
		}
    }
    
    
}
