package Clases;

import proyectoprogra3.*;

public class NodoDa {
	private Observaciones o;
	private Habitos h;
	private String recomendaciones;
	private NodoDa sig;
	
	public NodoDa() {
		sig=null;
	}

	public Observaciones getO() {
		return o;
	}

	public void setO(Observaciones o) {
		this.o = o;
	}

	public Habitos getH() {
		return h;
	}

	public void setH(Habitos h) {
		this.h = h;
	}

	public String getRecomendaciones() {
		return recomendaciones;
	}

	public void setRecomendaciones(String recomendaciones) {
		this.recomendaciones = recomendaciones;
	}

	public NodoDa getSig() {
		return sig;
	}

	public void setSig(NodoDa sig) {
		this.sig = sig;
	}
	
	
}
