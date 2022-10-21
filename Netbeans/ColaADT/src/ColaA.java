
public class ColaA <T> implements ColaADT<T> {
    private T[] cola;
    private int primero;
    private int ultimo;
    private int MAXIMO = 20;
    
    public ColaA() {
        cola = (T[]) new Object[MAXIMO];
    }
    
    public ColaA(int max) {
        cola = (T[]) new Object[max];
    }

    /*
        @Override
    public void agrega(T dato) {
        if ((ultimo + 1)% cola.length == primero)
            expande();
    }
    */
    @Override
    public void agrega(T dato) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T saca() {
        if (estaVacia())
            throw new RuntimeException();
        
        T eliminado = cola[primero];
        cola[primero] = null;
            
        if (primero == ultimo){ // hay un solo elemento
            primero = -1;   // indica cola vacia 
            ultimo = -1;
        } else 
            primero = (primero + 1) % cola.length;
        
        return eliminado;
    }

    @Override
    public T consultaPrimero() {
        if (!estaVacia())
            return cola[primero];
        throw new RuntimeException();
    }

    @Override
    public boolean estaVacia() {
        return primero == -1;
    }
}
