/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas;

import java.util.Stack;

/**
 *
 * @author Emiliano Sandoval
 */
public class Problema14 {
    // Problema 14
    /**
     * 
     * @param <T>
     * @param pila: Pila en la que se quiere ver cuantos elementos tiene 
     * @return elementos de la pila 
     */
    public static <T> int elementosAlmacenados(Stack<T> pila) {   // una PilaADT soporta mas generalidad
        Stack<T> aux = new Stack();
        int contador = 0;
        
        while(!pila.isEmpty()) {    
            aux.push(pila.pop());
            contador = contador + 1;
        }
        
        while(!aux.isEmpty())
            pila.push(aux.pop());
        
        return contador;
    }
    
    public static void main(String[] args) {
        Stack<Integer> pila = new Stack();
        
        pila.push(1);
        pila.push(2);
        pila.push(3);
        pila.push(4);
        pila.push(7);
        
        System.out.println(elementosAlmacenados(pila));
        System.out.println(pila.toString());
    }
}
