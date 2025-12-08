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
    private int id_componente,id_GrupoComponente;
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

    public int getId_componente() {
        return id_componente;
    }

    public void setId_componente(int id_componente) {
        this.id_componente = id_componente;
    }

    public int getId_GrupoComponente() {
        return id_GrupoComponente;
    }

    public void setId_GrupoComponente(int id_GrupoComponente) {
        this.id_GrupoComponente = id_GrupoComponente;
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
    
    @Override
    public String toString() {
        // Guardar separado por comas
        return id_GrupoComponente + ";" +id_GrupoComponente + ";" + Nombre + ";" + Utilidad + ";" + Observaciones;
    }

    public static NodoC fromString(String linea) {
        String[] datos = linea.split(";");
        NodoC n = new NodoC();
        n.setId_componente(Integer.parseInt(datos[0]));
        n.setId_GrupoComponente(Integer.parseInt(datos[1]));
        n.setNombre(datos[2]);
        n.setUtilidad(datos[3]);
        n.setObservaciones(datos[4]);
        return n;
    }
}
