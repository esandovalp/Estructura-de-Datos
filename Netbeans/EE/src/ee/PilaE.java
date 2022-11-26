
package ee;

public class PilaE <T> {
    private final EE<T> pila;

    public PilaE() {
        pila = new EE();   
    }
    
    public void push(T dato) {
        pila.agregaInicio(dato);
    }
    
    public T pop() {
        return pila.quitaPrimero();
    }
    
    public boolean isEmpty() {
        return pila.estaVacia();
    }

    
    public T peek() {
        T res = pila.quitaPrimero();
        pila.agregaInicio(res);
        return res;
    }

    
    public String toString() {        
        return pila.toString();
    }
}
