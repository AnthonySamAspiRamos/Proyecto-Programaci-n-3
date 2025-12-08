package Clases;

import proyectoprogra3.*;

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
    
    public void adicionar(int i, String h, Personal pe) {
		NodoPI nue=new NodoPI();
		nue.setId_Informador(i);
                nue.setHorario(h);
                nue.setP(pe);
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
			System.out.println("Id Informador: "+w.getId_Informador()+" | Horario: "+w.getHorario());
                        System.out.println("Datos del Personal: ");
                        w.getP().mostrar();
			w=w.getSig();
		}
    }
    
}
