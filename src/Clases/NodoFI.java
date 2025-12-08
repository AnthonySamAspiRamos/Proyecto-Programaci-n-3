package Clases;

import proyectoprogra3.*;

public class NodoFI {
	private int id_Informaciones;
	private PilaFI in;
	public NodoFI ant,sig;
	
	public NodoFI() {
		ant=sig=null;
	}

	public int getId_Informaciones() {
		return id_Informaciones;
	}

	public void setId_Informaciones(int id_Informaciones) {
		this.id_Informaciones = id_Informaciones;
	}

	public PilaFI getIn() {
		return in;
	}

	public void setIn(PilaFI in) {
		this.in = in;
	}

	public NodoFI getAnt() {
		return ant;
	}

	public void setAnt(NodoFI ant) {
		this.ant = ant;
	}

	public NodoFI getSig() {
		return sig;
	}

	public void setSig(NodoFI sig) {
		this.sig = sig;
	}
	
}
