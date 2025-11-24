package proyectoprogra3;

import java.util.Scanner;

public class Observaciones {
	private int peso;
	private int altura;
	private String presArterial;
	private String glucosa;
	private String colesterol;
        private Scanner lec=new Scanner(System.in);
        
        public Observaciones(){
            
        }
	
	public Observaciones(int peso, int altura, String presArterial, String glucosa, String colesterol){
		this.peso = peso;
		this.altura = altura;
		this.presArterial = presArterial;
		this.glucosa = glucosa;
		this.colesterol = colesterol;
	}
	public void mostrar(){
		System.out.println("Peso: " + peso + " kg");
		System.out.println("Altura: " + altura + " cm");
		System.out.println("Presion Arterial: " + presArterial);
		System.out.println("Glucosa: " + glucosa);
		System.out.println("Colesterol: " + colesterol);
	}
        public void leer(){
            System.out.println("Agregando Datos de Observaciones.");
            System.out.print("Int. Peso =>");peso=lec.nextInt();
            System.out.print("Int. Altura =>");altura=lec.nextInt();
            System.out.print("Int. Presion Arterial =>");presArterial=lec.next();
            System.out.print("Int. Nivel de glucosa =>");glucosa=lec.next();
            System.out.print("Int. Nivel de colesterol =>");colesterol=lec.next();
            System.out.println("Datos Agregados.");
        }
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public String getPresArterial() {
		return presArterial;
	}
	public void setPresArterial(String presArterial) {
		this.presArterial = presArterial;
	}
	public String getGlucosa() {
		return glucosa;
	}
	public void setGlucosa(String glucosa) {
		this.glucosa = glucosa;
	}
	public String getColesterol() {
		return colesterol;
	}
	public void setColesterol(String colesterol) {
		this.colesterol = colesterol;
	}
	
}
