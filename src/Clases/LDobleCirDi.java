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
public class LDobleCirDi {
    private NodoDi p;

    public LDobleCirDi() {
        p=null;
    }

    public NodoDi getP() {
        return p;
    }

    public void setP(NodoDi p) {
        this.p = p;
    }
    public void adiprincipio(int idv,int idm,Diagnostico d,int ifd){
        NodoDi nue=new NodoDi();
        nue.setId_Visitante(idv);
        nue.setId_Medico(idm);
        nue.setD(d);
        nue.setId_Feria(ifd);
        NodoDi z=getP();
        if(z==null)
            setP(nue);
        else{
            nue.setSig(getP());
            getP().setAnt(nue);
            setP(nue);
        }
    }
    
    public void mostrar(){
        NodoDi e=getP();
        while (e!=null){
            System.out.println(e.getId_Visitante()+" "+e.getId_Medico()+" "+e.getId_Feria());
            e.getD().mostrar();
            e=e.getSig();
        }
    }
}
