/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra3;

/**
 *
 * @author YOSHUA
 */
public class PilaMS {
    private int max=50;
    private MedicamentosSumi v[]=new MedicamentosSumi[max+1];
    private int tope;

    public PilaMS() {
        tope=0;
    }
    
    boolean esvacia()
    {
        if(tope==0)
           return true; 
        return false; 
    }
    boolean esllena()
    {
        if(tope==max)
            return true;
        return false;
    }
    int nroelem()
    {
        return tope;
    }
    void adicionar(MedicamentosSumi elem)
    {
       if (!esllena ())
	{
	    tope++;
	    v [tope] = elem;
	}
	else
	    System.out.println ("Pila llena");
      
    }
    MedicamentosSumi eliminar()
    {
        MedicamentosSumi elem = null;
    	if (!esvacia ())
    	{
    		elem = v [tope];
    		tope--;
    	}
    	else
    		System.out.println ("Pila vacia");
    	return (elem);
        
    }
    void mostrar()
    {
         MedicamentosSumi elem;
	if (esvacia ())
	    System.out.println ("Pila vacia");
	else
	{
	    PilaMS aux = new PilaMS ();
	    while (!esvacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		elem.mostrar();
	    }
	    vaciar(aux);
	}
       
    }    
    void vaciar (PilaMS Z)
    {
	while (!Z.esvacia ())
	    adicionar (Z.eliminar ());

    } 
    
}
