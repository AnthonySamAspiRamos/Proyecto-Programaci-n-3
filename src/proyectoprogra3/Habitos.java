package proyectoprogra3;

import java.util.Scanner;

public class Habitos {
	private String frecDeEjercico;
	private String dieta;
	private String consumo;
        private Scanner lec=new Scanner(System.in);
        
	public Habitos(){}
	public Habitos(String frecDeEjercico, String dieta, String consumo){
		this.frecDeEjercico = frecDeEjercico;
		this.dieta = dieta;
		this.consumo = consumo;
	}
	public void mostrar(){
		System.out.println("Frecuencia de Ejercicio: " + frecDeEjercico);
		System.out.println("Dieta: " + dieta);
		System.out.println("Consumo de Sustancias: " + consumo);
	}
        public void leer(){
            System.out.println("Agregando Datos de Habitos");
            System.out.print("Int. Frecuencia de Ejercicio => ");frecDeEjercico=lec.next();
            System.out.print("Int. Dieta => ");dieta=lec.next();
            System.out.print("Int. Consumo de Sustancias => ");consumo=lec.next();
            System.out.print("Datos Agregados.");
        }
	public String getFrecDeEjercico() {
		return frecDeEjercico;
	}
	public void setFrecDeEjercico(String frecDeEjercico) {
		this.frecDeEjercico = frecDeEjercico;
	}
	public String getDieta() {
		return dieta;
	}
	public void setDieta(String dieta) {
		this.dieta = dieta;
	}
	public String getConsumo() {
		return consumo;
	}
	public void setConsumo(String consumo) {
		this.consumo = consumo;
	}
	
}
