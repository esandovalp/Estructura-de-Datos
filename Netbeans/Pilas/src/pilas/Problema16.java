
package pilas;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Emiliano Sandoval
 */
public class Problema16 {
    // pila invertida, esa misma pila 
   
    /**
     * 
     * @param <T>
     * @param pila: pila que se va a invertir 
     */
    public static <T> void inviertePila(Stack<T> pila){
        ArrayList <T> aux = new ArrayList();
        
        while(!pila.isEmpty()) 
            aux.add(pila.pop());
        
        for(int i=0; i<aux.size(); i++) 
            pila.push(aux.get(i));
        
    }

    
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack();
        
        pila.push(1);
        pila.push(2);
        pila.push(3);
        
        System.out.println(pila.toString());
        
        inviertePila(pila);
        
        System.out.println("\n" + pila.toString());
    }
}
