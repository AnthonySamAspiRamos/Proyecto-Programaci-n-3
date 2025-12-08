package Clases;

import proyectoprogra3.*;

public class FichaInfo {
	private int id_Visitante;
	private int id_Informador;
	//private LSimpleDa da;
        private Observaciones o;
        private Habitos h;
	private int id_Feria;
	
	public FichaInfo(int id_Visitante, int id_Informador, Observaciones ob, Habitos ha, int id_Feria) {
		this.id_Visitante = id_Visitante;
		this.id_Informador = id_Informador;
		//this.da = da;
                o=ob;
                h=ha;
		this.id_Feria = id_Feria;
	}
	public void mostrar() {
		System.out.println("ID Visitante: " + id_Visitante);
		System.out.println("ID Informador: " + id_Informador);
                System.out.println("Observaciones: ");
                o.mostrar();
                System.out.println("Habitos: ");
                h.mostrar();
		System.out.println("ID Feria: " + id_Feria);
                
		//System.out.println("Datos Adicionales: ");
		//da.mostrar();
	}
	public int getId_Visitante() {
		return id_Visitante;
	}
	public void setId_Visitante(int id_Visitante) {
		this.id_Visitante = id_Visitante;
	}
	public int getId_Informador() {
		return id_Informador;
	}
	public void setId_Informador(int id_Informador) {
		this.id_Informador = id_Informador;
	}
        /*
	public LSimpleDa getDa() {
		return da;
	}
	public void setDa(LSimpleDa da) {
		this.da = da;
	}
        */

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
        
	public int getId_Feria() {
		return id_Feria;
	}
	public void setId_Feria(int id_Feria) {
		this.id_Feria = id_Feria;
	}
	
	
}
