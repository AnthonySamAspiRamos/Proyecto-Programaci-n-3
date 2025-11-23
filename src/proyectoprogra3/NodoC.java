/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra3;

/**
 *
 * @author YOSHUA
 */
public class NodoC {
    private String Nombre,Utilidad,Observaciones;
    private NodoC sig;

    public NodoC() {
        sig=null;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getUtilidad() {
        return Utilidad;
    }

    public void setUtilidad(String Utilidad) {
        this.Utilidad = Utilidad;
    }

    public String getObservaciones() {
        return Observaciones;
    }

    public void setObservaciones(String Observaciones) {
        this.Observaciones = Observaciones;
    }

    public NodoC getSig() {
        return sig;
    }

    public void setSig(NodoC sig) {
        this.sig = sig;
    }
    
}
