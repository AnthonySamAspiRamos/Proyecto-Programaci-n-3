package Clases;

import proyectoprogra3.*;

public class CCircF {
    private int max=100;
	private Feria V[]=new Feria[max+1];
	private int init,fin;
	public CCircF() {
		init=0;
		fin=0;
	}
	public int nroElem() {
		if (init==0 && fin==0) {
			return 0;
		}
		else {
			if(fin>init) {
				return fin-init;
			}
			else {
				return max-init+fin;
			}
		}
	}
	public boolean esVacia() {
		if(nroElem()==0) {
			return true;
		}
		else
			return false;
	}
	public boolean esLlena() {
		if (nroElem()==max)
			return true;
		else
			return false;
	}
	public void adicionar(Feria e) {
		if(!esLlena()) {
			if(fin==max) 
				fin=1;			
			else
				fin++;
			V[fin]=e;
		}
		else
			System.out.println("Cola Circular Llena");
	}
	public Feria eliminar() {
		Feria elem=null;
		if(!esVacia()) {
			init++;
			elem=V[init];
			if(init==max)			
				init=0;
			//AL PRINCIPIO HABIA UN ERROR POR QUE FALTABA ESTE IF
			//Este controla para ver si la cola llega a un punto vacio. Lo resetea
			if(init==fin)
				init=fin=0;
		}
		else
			System.out.println("Cola Circular Vacia");
		return elem;
	}
	public void mostrar() {
		//METODO CON UN AUXILIAR:
		CCircF a=new CCircF();
		while(!esVacia()) {
			Feria x=eliminar();
			x.mostrar();
			a.adicionar(x);
		}
		vaciar(a);
		//METODO CON SOLO UNA COLA:
		/*
		int n=nroElem();
		System.out.println(n);
		for(int i=1;i<=n;i++) {
			Artesania x=eliminar();
			x.mostrar();
			a.adicionar(x);
		vaciar(a);
		*/
	}
	public void vaciar(CCircF ax) {
		while(!ax.esVacia()) {
			adicionar(ax.eliminar());
		}
	}
}
