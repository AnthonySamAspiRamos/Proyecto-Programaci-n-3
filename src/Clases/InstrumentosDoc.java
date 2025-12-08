package Clases;

import proyectoprogra3.*;

public class InstrumentosDoc {
    private String nombre, tipo, observacion;

    public InstrumentosDoc(String nombre, String tipo, String observacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.observacion = observacion;
    }
    public void mostrar(){
        System.out.println("Instrumento: Nombre: "+nombre+" | Tipo: "+tipo+" | observaciones: "+observacion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    
    
    
}
