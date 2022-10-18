
package pilas;

import java.util.Stack;

/**
 *
 * @author Emiliano Sandoval
 */
public class Problema17 {
    
    // la misma pila la dejamos sin repetir
    /**
     * 
     * @param <T>
     * @param pila 
     */
    public static <T> void pilaSinRepetir(Stack<T> pila) {
        Stack<T> aux = new Stack();
        
      if (pila.empty()) 
          System.out.println("La pila esta vacia");
      
      else {
          while(!pila.empty()) {
              aux.push(pila.pop());
              
              try{
                  if(aux.peek().equals(pila.peek()))
                      aux.pop();
              } 
              
              catch (Exception e){
              }
         
              
          }
          
          while(!aux.empty()){
              pila.push(aux.pop());
          }
      }
      
    }
    
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack();
        
        
        pila.push(1);
        pila.push(2);
        pila.push(2);
        pila.push(2);
        pila.push(3);
        
        
        System.out.println(pila.toString());
        
        pilaSinRepetir(pila);
        
        System.out.println("\n");
        System.out.println(pila.toString());
        
    }
}
