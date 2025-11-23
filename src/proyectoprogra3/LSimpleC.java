/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra3;

/**
 *
 * @author YOSHUA
 */
public class LSimpleC {
    private NodoC p;

    public LSimpleC() {
        p=null;
    }

    public NodoC getP() {
        return p;
    }

    public void setP(NodoC p) {
        this.p = p;
    }
    public void nroNodos(){
        int c=0;
        NodoC z=getP();
        while(z!=null)
        {
            c++;
            z=z.getSig();
        }
        System.out.println(c);
    }
    public void adiFinal(String n,String u,String o){
        NodoC nuevo=new NodoC();
        nuevo.setNombre(n);
        nuevo.setUtilidad(u);
        nuevo.setObservaciones(o);
        if (getP()==null)
            setP(nuevo);
        else{
            NodoC r=getP();
            while (r.getSig()!=null){
                r=r.getSig();
            }
            r.setSig(nuevo);
        }
    }
    public NodoC eliPrincipio(){
        NodoC q=getP();
        if (q.getSig()==null)
            setP(null);
        else{
            setP(q.getSig());
            q.setSig(null);
        }
        return q;
    }
    public NodoC eliFinal(){
        NodoC q=getP();
        if (q.getSig()==null)
            setP(null);
        else{
            while(q.getSig()!=null)
                q=q.getSig();
            NodoC w=getP();
            while(w.getSig()!=q)
                w=w.getSig();
            w.setSig(null);
        }
        return q;
    }
    public void mostrar(){
        NodoC e=getP();
        while (e!=null){
            System.out.print(e.getNombre()+" "+e.getUtilidad()+" "+e.getObservaciones());
            e=e.getSig();
        }
    }
    
    
}
