
package ee;

import java.util.Iterator;


public interface ConjuntoEDT <T> extends Iterable<T> {
    public boolean agrega(T dato);
    public T elimina(T dato);
    public boolean contiene(T dato);
    public boolean estaVacio();
    public int getCardinalidad();
    public Iterator<T> iterator();
    public ConjuntoEDT<T> union(ConjuntoEDT<T> otro);
}

