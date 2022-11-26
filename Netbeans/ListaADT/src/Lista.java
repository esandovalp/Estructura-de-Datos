
import java.util.Iterator;


public class Lista <T> implements ListaADT<T> {
    protected NodoDoble<T> primero;
    protected NodoDoble<T> ultimo;

    public Lista() {
        primero = null;
        ultimo = null;
    }
    
    @Override
    public Iterator<T> iterator() {
        return new IteradorNodo(primero);
    }

    @Override
    public boolean estaVacia() {
        return primero == null;
    }

    @Override
    public T quitaPrimero() {
        T eliminado = null;
        
        if (!this.estaVacia()) {
            eliminado = primero.getDato();
            
            if (primero == ultimo){
                primero = null;
                ultimo = null;
            }
            else {
                NodoDoble<T> temporal = primero;
                primero.setAnterior(null);
                temporal.setSiguiente(null);
            }
        }
        
        return eliminado;
   }

    @Override
    public T quitaUltimo() {
        T eliminado = null;
        
        if (!this.estaVacia()) {
            eliminado = ultimo.getDato();
            
            if (primero == ultimo){
                primero = null;
                ultimo = null;
            }
            else {
                NodoDoble<T> temporal = ultimo;
                ultimo = ultimo.getAnterior();
                ultimo.setSiguiente(null);
                temporal.setAnterior(null);
            }
        }
        
        return eliminado;
    }

    @Override
    public T quita(T dato) {
        T eliminado = null;
        
        if (!this.estaVacia()) {
            if (primero.getDato().equals(dato)){
                primero.getSiguiente().setAnterior(null);
                primero.setSiguiente(null);
            }
            NodoDoble<T> aux = primero;
            while (aux != null && !aux.getDato().equals(dato))
                aux = aux.getSiguiente();
            if (aux.getDato().equals(dato)){
                eliminado = aux.getDato();
                aux.getSiguiente().setAnterior(null);
                aux.getAnterior().setSiguiente(aux.getSiguiente());
                aux.setAnterior(null);
                aux.setSiguiente(null);
            }
            // checar caso en que el dato este en el ultimo nodo 
        }
 
        return eliminado;
    }

    @Override
    public boolean contiene(T dato) {
        boolean resp = false;
        
        if (!this.estaVacia())
            resp = contiene(dato, primero, ultimo);
        
        return resp;
    }

    private boolean contiene(T dato,NodoDoble<T> izq, NodoDoble<T> der){
        if (izq.getDato().equals(dato) || der.getDato().equals(dato))
            return true;
        else 
            if (izq == der || izq.getSiguiente() == der)
                return false;
            else
                return contiene(dato, izq.getSiguiente(),der.getAnterior());
    }
    
    
    @Override
    public int calculaTamanio() {
        int res = 0;
        
        if (!this.estaVacia()) {
            NodoDoble<T> aux = primero;
            while (aux != null){        
                res++;
                aux = aux.getSiguiente();
            }
        }
        
        return res;
    }

    // checar caso en que este vacia (en el main)
    @Override
    public T consultaPrimero() {
        return primero.getDato();
    }

    @Override
    public T consultaUltimo() {
        return ultimo.getDato();
    }
    
    public String toString(){
        return toString(primero, new StringBuilder());
    }
    
    private String toString(NodoDoble<T> actual, StringBuilder sB){
        if (actual == null)
            return sB.toString();
        else {
            sB.append(actual.getDato()).append(" ");
            return toString(actual.getSiguiente(),sB);
        }
    }
}
