
import java.util.Iterator;
import java.util.NoSuchElementException;


public class IteradorNodo <T> implements Iterator<T> {
    private NodoDoble<T> actual; 

    public IteradorNodo(NodoDoble<T> actual) {
        this.actual = actual;
    }

    @Override
    public boolean hasNext() {
        return actual != null;
    }

    @Override
    public T next() {
        if (this.hasNext()){
            T dato = actual.getDato();
            actual = actual.getSiguiente();
            return dato;
        }
        throw new NoSuchElementException();
    }
    
    
}
