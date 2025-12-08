package Clases;

import proyectoprogra3.*;

public class PilaFI {
	private int max=100;
	private FichaInfo v[]=new FichaInfo[max+1];
	private int tope;
	
	public PilaFI() {
		tope=0;
	}
	boolean esvacia() {
		if(tope==0)
			return true;
		return false;
	}
	boolean esllena() {
		if(tope==max)
			return true;
		return false;
	}
	int nroelem() {
		return tope;
	}
	void adicionar(FichaInfo elem) {
		if(esllena())
			System.out.println("Pila llena");
		else {
			tope++;
			v[tope]=elem;
		}
	}
	FichaInfo eliminar() {
		FichaInfo elem=null;
		if(esvacia())
			System.out.println("Pila vacia");
		else {
			elem=v[tope];
			tope--;
		}
		return elem;
	}
	void mostrar() {
		PilaFI aux=new PilaFI();
		while(!esvacia()) {
			FichaInfo x=eliminar();
			x.mostrar();
			aux.adicionar(x);
		}
		vaciar(aux);
	}
	void vaciar(PilaFI z) {
		while(!z.esvacia())
			adicionar(z.eliminar());
	}
}
