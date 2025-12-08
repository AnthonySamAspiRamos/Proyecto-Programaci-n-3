package Clases;

import proyectoprogra3.*;

public class MultiColaF {
    private int nc;
    private CCircF f[]=new CCircF[15];
    
    public MultiColaF(){
        for(int i=1 ; i<=14 ; i++){
            f[i]=new CCircF();
        }
    }

    public int getNc() {
        return nc;
    }

    public void setNc(int nc) {
        this.nc = nc;
    }
    public boolean esvacia(int i)
    {
        return f[i].esVacia();
    }
    public boolean esllena(int i)
    {
        return f[i].esLlena();
    }
    public int nroelem(int i)
    {
        return f[i].nroElem();
    }
    public void adicionar(int i,Feria x)
    {
        f[i].adicionar(x);
    }
    public Feria eliminar(int i)
    {
        return f[i].eliminar();
    }
    public void mostrar(int i)
    {
        f[i].mostrar();
    }
    public void mostrar()
    {
        for(int i=1;i<=nc;i++)
        {
            f[i].mostrar();
            System.out.println(" ");
        }
    }
    public void vaciar(int i,CCircF z)
    {
        f[i].vaciar(z);
    }
    public void vaciar(int i,int j)
    {
        f[i].vaciar(f[j]);
    }
}
