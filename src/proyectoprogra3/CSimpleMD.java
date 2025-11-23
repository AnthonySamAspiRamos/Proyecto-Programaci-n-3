/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogra3;

/**
 *
 * @author YOSHUA
 */
public class CSimpleMD {
    private int max=50;
    private MedicamentosDispo v[]=new MedicamentosDispo[max+1];
    private int ini,fin;
    
    CSimpleMD()
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
    void adicionar (MedicamentosDispo elem)
    {
	if (!esllena ())
	{
	    fin++;
	    v [fin] = elem;
	}
	else
	    System.out.println ("Cola Simple llena");
    }
    MedicamentosDispo eliminar ()
    {
	MedicamentosDispo elem=new MedicamentosDispo();
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
	MedicamentosDispo elem;
	if (esvacia ())
	    System.out.println ("Cola vacia");
	else
	{
	    System.out.println ("\n Zonas de la Cola ");
	    CSimpleMD aux = new CSimpleMD ();
	    while (!esvacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		elem.mostrar();
	    }
	    vaciar(aux);
	}
    }
    
    void vaciar (CSimpleMD a)
    {
	while (!a.esvacia ())
	    adicionar (a.eliminar ());
    }
}
