package proyectoprogra3;

public class PilaInsD {
    private int max=100;
    private InstrumentosDoc v[]=new InstrumentosDoc[max+1];
    private int tope;
    
    PilaInsD ()
    {
	tope = 0;
    }
    boolean esVacia ()
    {
	if (tope == 0)
	    return (true);
	return (false);
    }
    boolean esLlena ()
    {
	if (tope == max)
	    return (true);
	return (false);
    }
    int nroelem ()
    {
	return (tope);
    }
    void adicionar (InstrumentosDoc elem)
    {
	if (!esLlena ())
	{
	    tope++;
	    v [tope] = elem;
	}
	else
	    System.out.println ("Pila llena");
    }
    InstrumentosDoc eliminar ()
    {
	InstrumentosDoc elem = null;
	if (!esVacia ())
	{
	    elem = v [tope];
	    tope--;
	}
	else
	    System.out.println ("Pila vacia");
	return (elem);
    }
    void mostrar ()
    {
	InstrumentosDoc elem;
	if (esVacia ())
	    System.out.println ("Pila vacia");
	else
	{
	    System.out.println ("InstrumentosDoc de la Pila ");
	    PilaInsD aux = new PilaInsD ();
	    while (!esVacia ())
	    {
		elem = eliminar ();
		aux.adicionar (elem);
		elem.mostrar();
	    }
	    vaciar(aux);
	}
    }
    void vaciar (PilaInsD a)
    {
	while (!a.esVacia ())
	    adicionar (a.eliminar ());

    }
}
