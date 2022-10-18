
package pilas;

import java.util.ArrayList;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Emiliano Sandoval
 */
public class Problema15 {
    
    //si lo paso a un arraylist lo primero que checo son los tamaños, si está mas grande el que se busca que este contenido
    // no tiene sentido que vea que este contenido en otro 
    private static <T> ArrayList<T> vaciarPila(Stack<T> pila){
        ArrayList<T> array = new ArrayList();
        
        while(!pila.empty()){
            array.add(pila.pop() );
        }
        
        return array;
    }
    
    private static <T> void regresa(Stack<T> pila, ArrayList<T> array){
        for (int i=array.size()-1; i>=0; i--){
            pila.push(array.get(i));
        }
    }
    
    
    public static <T> boolean contienePila(Stack<T> pila1, Stack<T> pila2) throws Exception{
        boolean resp = false;
        int i =0;
        ArrayList<T> arrayP1;
        ArrayList<T> arrayP2;
        
        arrayP1 = vaciarPila(pila1);
        arrayP2 = vaciarPila(pila2);
        
        if( arrayP1.size() >= arrayP2.size()){
            while(i<arrayP2.size() && arrayP1.contains(arrayP2.get(i)))
                i++;
            if(i==arrayP2.size())
                resp = false;
        }
        
        regresa(pila1, arrayP1);
        regresa(pila2, arrayP2);
        
        return resp;
    }
    
    public static void main(String[] args) {
        Stack<Integer> pila1 = new Stack();
        Stack<Integer> pila2 = new Stack();
        
        pila1.push(1);        
        pila1.push(2);
        pila1.push(3);
        pila1.push(4);
        
        pila2.push(2);
        pila2.push(3);
        
        try {
            System.out.println(contienePila(pila1, pila2));
        } catch (Exception ex) {
            Logger.getLogger(Problema15.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
