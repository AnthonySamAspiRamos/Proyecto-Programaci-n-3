package proyectoprogra3;

public class LSimpleDa {
	private NodoDa p;
	
	public LSimpleDa() {
		p=null;
	}
	public NodoDa getP() {
		return p;
	}
	public void setP(NodoDa p) {
		this.p = p;
	}
	public void adicionar(Observaciones o, Habitos h, String recomendaciones) {
		NodoDa nuevo=new NodoDa();
		nuevo.setO(o);
		nuevo.setH(h);
		nuevo.setRecomendaciones(recomendaciones);
		if(getP()==null) {
			setP(nuevo);
		}else {
			NodoDa w=getP();
			while(w.getSig()!=null) {
				w=w.getSig();
			}
			w.setSig(nuevo);
		}
	}
	public void mostrar() {
		NodoDa w=getP();
		while(w!=null) {
			w.getO().mostrar();
			w.getH().mostrar();
			System.out.println("Recomendaciones: "+w.getRecomendaciones());
			System.out.println("---------------------");
			w=w.getSig();
		}
	}
}
