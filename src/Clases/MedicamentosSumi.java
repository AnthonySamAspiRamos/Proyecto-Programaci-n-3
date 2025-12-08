/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import proyectoprogra3.*;

/**
 *
 * @author YOSHUA
 */
public class MedicamentosSumi {
    private String Nombre;
    private int capacidad;
    private String tipo;

    public MedicamentosSumi(String Nombre, int capacidad, String tipo) {
        this.Nombre = Nombre;
        this.capacidad = capacidad;
        this.tipo = tipo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public void mostrar(){
        System.out.println(Nombre+" "+capacidad+" "+tipo);
    }
}
