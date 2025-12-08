/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra3;

/**
 *
 * @author YOSHUA
 */
public class NodoDi {
    private int Id_Visitante, Id_Medico;
    private String antesedentes,motivo,hallazgo,desiciones,tratamiento,evaluacion;
    private int Id_Feria;
    private String fecha;
    private NodoDi sig,ant;

    public NodoDi() {
        sig=ant=null;
    }

    public int getId_Visitante() {
        return Id_Visitante;
    }

    public void setId_Visitante(int Id_Visitante) {
        this.Id_Visitante = Id_Visitante;
    }

    public int getId_Medico() {
        return Id_Medico;
    }

    public void setId_Medico(int Id_Medico) {
        this.Id_Medico = Id_Medico;
    }

    public String getAntesedentes() {
        return antesedentes;
    }

    public void setAntesedentes(String antesedentes) {
        this.antesedentes = antesedentes;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    
    public int getId_Feria() {
        return Id_Feria;
    }

    public void setId_Feria(int Id_Feria) {
        this.Id_Feria = Id_Feria;
    }

    public NodoDi getSig() {
        return sig;
    }

    public void setSig(NodoDi sig) {
        this.sig = sig;
    }

    public NodoDi getAnt() {
        return ant;
    }

    public void setAnt(NodoDi ant) {
        this.ant = ant;
    }
    
    
    @Override
    public String toString() {
        // Guardar separado por comas
        return Id_Visitante + ";" + Id_Medico + ";" + antesedentes + ";" + motivo+ ";" +hallazgo+ ";" +desiciones+ ";" +tratamiento+ ";" +evaluacion+ ";" +Id_Feria+ ";" +fecha;
    }

    public static NodoDi fromString(String linea) {
        String[] datos = linea.split(";");
        NodoDi n = new NodoDi();
        n.setId_Visitante(Integer.parseInt(datos[0]));
        n.setId_Medico(Integer.parseInt(datos[1]));
        n.setAntesedentes(datos[2]);
        n.setMotivo(datos[3]);
        n.setHallazgo(datos[4]);
        n.setDesiciones(datos[5]);
        n.setTratamiento(datos[6]);
        n.setEvaluacion(datos[7]);
        n.setId_Feria(Integer.parseInt(datos[8]));
        n.setFecha(datos[9]);
        return n;
    }

}
