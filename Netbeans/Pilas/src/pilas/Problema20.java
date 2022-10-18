
package pilas;

import java.util.Stack;

/**
 *
 * @author Emiliano Sandoval
 */
public class Problema20 {
    
    public static int regresaBinario(int n) {
        Stack<Integer> aux = new Stack();
        StringBuilder sB = new StringBuilder();
        int mod;
    
        while (n > 0){
            mod = n%2;
            aux.push(mod);
            n = n/2;
        }
        
        while(!aux.empty()) {
            sB.append(aux.pop());
        }
        return Integer.parseInt(sB.toString());
    }
    
    public static void main(String[] args) {
        System.out.println(regresaBinario(24));
    }
}
