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
    public void adicionar(int i, String h, Personal pe) {
		NodoPA nue=new NodoPA();
		nue.setId_Medico(i);
                nue.setHorario(h);
                nue.setP(pe);
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
			System.out.println("Id Medico: "+w.getId_Medico()+" | Horario: "+w.getHorario());
                        System.out.println("Datos del Personal: ");
                        w.getP().mostrar();
			w=w.getSig();
		}
    }
    
    
}
