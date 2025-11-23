/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra3;

/**
 *
 * @author YOSHUA
 */
public class CSimpleC {
    private int max=50;
    private Componente v[]=new Componente[max+1];
    private int ini,fin;
    
    CSimpleC()
    {
        ini=fin=0;
    }
    boolean esvacia ()
    {
	if (ini == 0 && fin == 0)
	    return (true);
	return (false);
    }
    boolean esllena ()
    {
	if (fin == max)
	    return (true);
	return (false);
    }
    int nroelem ()
    {
	return (fin - ini);
    }
    void adicionar (Componente elem)
    {
	if (!esllena ())
	{
	    fin++;
	    v [fin] = elem;
	}
	else
	    System.out.println ("Cola Simple llena");
    }
    Componente eliminar ()
    {
	Componente elem=new Componente();
	if (!esvacia ())
	{
	    ini++;
	    elem = v [ini];
	    if (ini == fin)
		ini = fin = 0;
	}
	else
	    System.out.println ("Cola Simple vacia");
	return (elem);
    }
    void mostrar ()
    {
	Componente elem;
	if (esvacia ())
	    System.out.println ("Cola vacia");
	else
	{
	    System.out.println ("\n Zonas de la Cola ");
	    CSimpleC aux = new CSimpleC ();
	    while (!esvacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		elem.mostrar();
	    }
	    vaciar(aux);
	}
    }
    
    void vaciar (CSimpleC a)
    {
	while (!a.esvacia ())
	    adicionar (a.eliminar ());
    }
}
