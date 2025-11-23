package proyectoprogra3;

public class CSimpleV {
    private int max=50;
    private Visitante v[]=new Visitante[max+1];
    private int init,fin;
	
    public CSimpleV() {
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
	public void adicionar(Visitante ex) {
		if(!esLlena()) {
			v[fin+1]=ex;
			fin++;
		}
		else {
			System.out.println("Cola Llena");
		}
	}
	public Visitante eliminar() {
		Visitante elem=null;
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
		CSimpleV aux=new CSimpleV();
		while(!esVacia()) {
			Visitante e=eliminar();
			e.mostrar();
			aux.adicionar(e);
		}
		vaciar(aux);
	}
	public void vaciar(CSimpleV z) {
		while(!z.esVacia()) {
			adicionar(z.eliminar());
		}
			
	}
}
