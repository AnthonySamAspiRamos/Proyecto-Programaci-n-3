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
public class MedicamentosDispo {
    private int Id_MedicamentoDispo;
    private String tipo;
    private int stock;

    public MedicamentosDispo() {
    }

    
    public MedicamentosDispo(int Id_MedicamentoDispo, String tipo, int stock) {
        this.Id_MedicamentoDispo = Id_MedicamentoDispo;
        this.tipo = tipo;
        this.stock = stock;
    }
    public void mostrar(){
        System.out.println(Id_MedicamentoDispo+" "+tipo+" "+stock);
    }

    public int getId_MedicamentoDispo() {
        return Id_MedicamentoDispo;
    }

    public void setId_MedicamentoDispo(int Id_MedicamentoDispo) {
        this.Id_MedicamentoDispo = Id_MedicamentoDispo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
}
