/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra3;

/**
 *
 * @author YOSHUA
 */
public class Componente {
    private int Id_componente;
    private LSimpleC Lc;

    public Componente() {
    }
    
    public Componente(int Id_componente, LSimpleC Lc) {
        this.Id_componente = Id_componente;
        this.Lc = Lc;
    }
    public void mostrar(){
        System.out.println("Id Componentes: "+Id_componente);
        System.out.println("Lista de Componentes: ");
        Lc.mostrar();
    }

    public int getId_componente() {
        return Id_componente;
    }

    public void setId_componente(int Id_componente) {
        this.Id_componente = Id_componente;
    }

    public LSimpleC getLc() {
        return Lc;
    }

    public void setLc(LSimpleC Lc) {
        this.Lc = Lc;
    }
    
}
