package proyectoprogra3;

public class LSimplePR {
    private NodoPR p;
    
    public LSimplePR(){
        p=null;
    }

    public NodoPR getP() {
        return p;
    }

    public void setP(NodoPR p) {
        this.p = p;
    }
    
    
    
    public void adicionar(int i, String h, int nrop,int idf) {
		NodoPR nue=new NodoPR();
		nue.setId_recreacionista(i);
                nue.setHorario(h);
                nue.setNroPuesto(nrop);
                nue.setId_feria(idf);
		if(getP()==null) {
			setP(nue);
		}
		else {
			NodoPR y=getP();
			while(y.getSig()!=null) {
				y=y.getSig();
			}
			y.setSig(nue);
		}
    }
    
    public void mostrar() {
		NodoPR w=getP();
		while(w!=null) {
			System.out.println("Id Promotor: "+w.getId_recreacionista()+" | Horario: "+w.getHorario()+" | NroPuesto: "+w.getNroPuesto()+" | idFeria: "+w.getId_feria());
                        
			w=w.getSig();
		}
    }
}
