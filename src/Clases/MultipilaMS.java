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
public class MultipilaMS {
    private int np;
    private PilaMS P[]=new PilaMS[50];

    public MultipilaMS(){
        for(int i=1;i<=49;i++)
        {
            P[i]=new PilaMS();
        }
    }
    
    
    public int getNP() {
        return np;
    }

    public void setNP(int n) {
        this.np = n;
    }
    public boolean esvacia(int i)
    {
        return P[i].esvacia();
    }
    public boolean esllena(int i)
    {
        return P[i].esllena();
    }
    public int nroelem(int i)
    {
        return P[i].nroelem();
    }
    public void adicionar(int i,MedicamentosSumi x)
    {
        P[i].adicionar(x);
    }
    public MedicamentosSumi eliminar(int i)
    {
        return P[i].eliminar();
    }
    public void mostrar(int i)
    {
        P[i].mostrar();
    }
    public void mostrar()
    {
        for(int i=1;i<=np;i++)
        {
            P[i].mostrar();
            System.out.println(" ");
        }
    }
    public void vaciar(int i,PilaMS z)
    {
        P[i].vaciar(z);
    }
    public void vaciar(int i,int j)
    {
        P[i].vaciar(P[j]);
    }
}
