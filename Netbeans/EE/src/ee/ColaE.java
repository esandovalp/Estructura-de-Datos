package ee;

import java.util.ArrayList;


public class ColaE <T> {
    private final EE<T> cola;
    
    public ColaE() {
        cola = new EE();
    }
    
    public void agrega(T dato) {
        cola.agregaFinal(dato);
    }
    
    public T saca() {
        T eliminado = cola.quitaPrimero();
        return eliminado;
    }

    
    public T consultaPrimero() {
        T res = cola.quitaPrimero();
        cola.agregaInicio(res);
        return res;
    }

    
    public boolean estaVacia() {
        return cola.estaVacia();
    }
    
    public String toString(){
        
        return cola.toString(); 
        
    }
    // a) cuentaElementos(): regresa el total de elementos almacenados en la cola.
    
    public int cuentaElementos() {
        int res = 0;
        String cadena;
        
        if (!this.estaVacia()) {
            cadena = cola.toString();
            for (int i=0; i < cadena.length(); i++) {
                cadena.charAt(i);
                res++;
            }
            
            res = res - (res/2);
        }
            
        return res;
    }
    
    // b) consultaUltimo(): regresa el último elemento almacenado en la cola, sin quitarlo.
    
    public T consultaUltimo() {
        T res = cola.quitaUltimo();
        cola.agregaFinal(res);
        return res;
    }

    // c) multiQuita(int n): regresa un ArrayList almacenando los n elementos quitados de la cola.
    
    public ArrayList<T> multiQuita(int n) {
        ArrayList<T> arr = new ArrayList();
        int total = this.cuentaElementos();
        
       if( n > total)
           throw new RuntimeException();
       else 
           for (int i=0; i < n ; i++)
               arr.add(this.saca());
       return arr;
    }
    
    public static void main(String[] args) {
        ColaE cola = new ColaE();
        
        cola.agrega(1);
        cola.agrega(2);
        cola.agrega(3);
        cola.agrega(4);
        cola.agrega(5);
        cola.agrega(6);
        cola.agrega(7);
        
        System.out.println(cola.cuentaElementos());
        System.out.println(cola.multiQuita(3));
        System.out.println(cola);
    }
}
