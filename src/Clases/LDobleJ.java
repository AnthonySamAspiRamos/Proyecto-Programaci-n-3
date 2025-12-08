package Clases;

import proyectoprogra3.*;

public class LDobleJ {
    private NodoJ p;
    
    public LDobleJ(){
        p=null;
    }

    public NodoJ getP() {
        return p;
    }

    public void setP(NodoJ p) {
        this.p = p;
    }
    
    public void adicionar(String  n, String t, String d, int p) {
		NodoJ nue=new NodoJ();
		nue.setNombre(n);
                nue.setTiempo(t);
                nue.setDescripcion(d);
                nue.setParticipaciones(p);
		if(getP()==null) {
			setP(nue);
		}
		else {
			NodoJ y=getP();
			while(y.getSig()!=null) {
				y=y.getSig();
			}
			y.setSig(nue);
                        nue.setAnt(y);
		}
    }
    
    public void mostrar() {
		NodoJ w=getP();
		while(w!=null) {
			System.out.println("Juego: Nombre:"+w.getNombre()+" | Tiempo: "+w.getTiempo()+" | Descripcion"+w.getDescripcion()+" | Participaciones: "+w.getParticipaciones());
			w=w.getSig();
		}
    }
}
