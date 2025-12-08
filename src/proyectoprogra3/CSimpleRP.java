package proyectoprogra3;

public class CSimpleRP {
    private int max=50;
	private Personal v[]=new Personal[max+1];
	private int init,fin;
	
	public CSimpleRP() {
		init=0;
		fin=0;
	}
	public boolean esVacia() {
		if(init==0 && fin==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean esLlena() {
		if(fin==max) {
			return true;
		}
		else
			return false;
	}
	public int nroElemen() {
		return fin-init;
	}
	public void adicionar(Personal ex) {
		if(!esLlena()) {
			v[fin+1]=ex;
			fin++;
		}
		else {
			System.out.println("Cola Llena");
		}
	}
	public Personal eliminar() {
		Personal elem=null;
		if(!esVacia()) {
			elem=v[init+1];
			init++;
			if(init==fin) {
				init=0;
				fin=0;
			}
			return elem;
			
		}
		else {
			System.out.println("Cola Vacia");
		}
		return elem;
	}
	public void mostrar() {
		CSimpleRP aux=new CSimpleRP();
		while(!esVacia()) {
			Personal e=eliminar();
			e.mostrar();
			aux.adicionar(e);
		}
		vaciar(aux);
	}
	public void vaciar(CSimpleRP z) {
		while(!z.esVacia()) {
			adicionar(z.eliminar());
		}
			
	}
}
