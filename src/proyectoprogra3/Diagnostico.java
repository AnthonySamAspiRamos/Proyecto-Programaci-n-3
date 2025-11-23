/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra3;

/**
 *
 * @author YOSHUA
 */
public class Diagnostico {
    private String antecedentes,motivos,hallazgo,desiciones,tratamiento,evaluacion;

    public Diagnostico(String antecedentes, String motivos, String hallazgo, String desiciones, String tratamiento, String evaluacion) {
        this.antecedentes = antecedentes;
        this.motivos = motivos;
        this.hallazgo = hallazgo;
        this.desiciones = desiciones;
        this.tratamiento = tratamiento;
        this.evaluacion = evaluacion;
    }
    public void mostrar(){
        System.out.println(antecedentes+" "+motivos+" "+hallazgo+" "+desiciones+" "+tratamiento+" "+evaluacion);
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getMotivos() {
        return motivos;
    }

    public void setMotivos(String motivos) {
        this.motivos = motivos;
    }

    public String getHallazgo() {
        return hallazgo;
    }

    public void setHallazgo(String hallazgo) {
        this.hallazgo = hallazgo;
    }

    public String getDesiciones() {
        return desiciones;
    }

    public void setDesiciones(String desiciones) {
        this.desiciones = desiciones;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public String getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(String evaluacion) {
        this.evaluacion = evaluacion;
    }
    
}
