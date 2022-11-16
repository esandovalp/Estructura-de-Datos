
package ee;

public class PilaE <T> {
    private final EE<T> pila;

    public PilaE() {
        pila = new EE();                 
    }
    
    public void push(T dato) {
        pila.agregaFinal(dato);
    }
    
    public T pop() {
        return pila.quitaUltimo();
    }
    
    public boolean isEmpty() {
        return pila.estaVacia();
    }

    
    public T peek() {
        T res = pila.quitaUltimo();
        pila.agregaFinal(res);
        return res;
    }

    
    public String toString() {        
        return pila.toString();
    }
}
