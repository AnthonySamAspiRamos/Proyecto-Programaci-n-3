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
public class NodoDi {
    private int Id_Visitante, Id_Medico;
    private Diagnostico d;
    private int Id_Feria;
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

    public Diagnostico getD() {
        return d;
    }

    public void setD(Diagnostico d) {
        this.d = d;
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
    

}
