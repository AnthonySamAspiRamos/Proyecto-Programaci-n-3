package Clases;

import proyectoprogra3.*;

public class LDobleFI {
	private NodoFI p;

	public LDobleFI() {
		p=null;
	}
	public NodoFI getP() {
		return p;
	}
	public void setP(NodoFI p) {
		this.p = p;
	}
	public void adicionar(int id_info, PilaFI in) {
		NodoFI nuevo=new NodoFI();
		nuevo.setId_Informaciones(id_info);
		nuevo.setIn(in);
		if(getP()==null) {
			setP(nuevo);
		}else {
			NodoFI w=getP();
			while(w.getSig()!=null) {
				w=w.getSig();
			}
			w.setSig(nuevo);
			nuevo.setAnt(w);		
		}
	}
	public void mostrar() {
		NodoFI w=getP();
		while(w!=null) {
			System.out.println("ID Informacion: "+w.getId_Informaciones());
			System.out.println("-----Pila de Informaciones-----");
			w.getIn().mostrar();
			System.out.println("---------------------");
			w=w.getSig();
		}
	}
	
}
