package proyectoprogra3;

public class Habitos {
	private String frecDeEjercico;
	private String dieta;
	private String consumo;
	
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
