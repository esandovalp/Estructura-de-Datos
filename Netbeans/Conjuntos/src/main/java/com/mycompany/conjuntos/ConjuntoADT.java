
package com.mycompany.conjuntos;

import java.util.Iterator;

public interface ConjuntoADT <T> extends Iterable<T> {
    
    public boolean agrega(T dato);
    public boolean contiene(T dato);
    public T elimina(T dato);
    public boolean estaVacio();
    public int getCardinalidad();
    public ConjuntoADT<T> union(ConjuntoADT<T> otro);
    public Iterator<T> iterator();
    public ConjuntoADT<T> interseccion(ConjuntoADT<T> otro);
    public ConjuntoADT<T> diferencia(ConjuntoADT<T> otro);
    
}
