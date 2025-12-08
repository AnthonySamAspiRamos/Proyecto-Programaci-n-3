package Clases;

import proyectoprogra3.*;

public class LSimplePR {
    private NodoPR p;
    
    LSimplePR(){
        p=null;
    }

    public NodoPR getP() {
        return p;
    }

    public void setP(NodoPR p) {
        this.p = p;
    }
    
    
    
    public void adicionar(int i, String h, Personal pe) {
		NodoPR nue=new NodoPR();
		nue.setId_Promotor(i);
                nue.setHorario(h);
                nue.setP(pe);
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
			System.out.println("Id Promotor: "+w.getId_Promotor()+" | Horario: "+w.getHorario());
                        System.out.println("Datos de Promotores: ");
                        w.getP().mostrar();
			w=w.getSig();
		}
    }
}
