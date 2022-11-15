/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conjuntos;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author coron
 */
public class SegundoParcialSegundaPregunta {
    // son disjuntos si no tienen elementos en comun
    // no destructivo! 
    public static <T> boolean sonDisjuntos(ConjuntoADT<T> conjunto1, ConjuntoADT<T> conjunto2) {
        boolean resp = false;
        
        if (conjunto1 == null || conjunto2 == null)
            throw new RuntimeException();
        
        if (conjunto1.getCardinalidad() == conjunto2.getCardinalidad())  {      // pueden ser disjuntos y un conjunto ser mas grande que otro. No es necesario checar si la cardinalidad 
            T t2 = conjunto2.iterator().next();                                                 // es igual.
            if (conjunto1.agrega(t2)) {                                                 // creo que la idea es usar el iterador como variable para poder moverse dentro del conjunto 
                resp = true;
                conjunto1.elimina(t2);
                conjunto2.agrega(t2);
            }
                
        }
            
            
        
        return resp;
    }
    
     public static <T> boolean sonDisjuntos2(Set<T> conjunto1, Set<T> conjunto2) {
        boolean resp = false;
        
        if (conjunto1 == null || conjunto2 == null)
            throw new RuntimeException();
        
        if (Collections.disjoint(conjunto1, conjunto2))
            resp = true;
        
        return resp;
    }
     
    public static <T> void consultaElementosIterador(ConjuntoADT<T> conjunto1 ) {
        Iterator<T> it = conjunto1.iterator();  // esto es posible porque la clase conjunto extiende Iterable
        
        while (it.hasNext())
            System.out.print(it.next());
    }
    
    public static void main(String[] args) {
        ConjuntoADT<Integer> conjunto1 = new ConjuntoA();
        ConjuntoADT<Integer> conjunto2 = new ConjuntoA();
        ConjuntoADT<Integer> conjunto3 = new ConjuntoA();
        ConjuntoADT<Integer> conjunto4 = new ConjuntoA();
        
        
        conjunto1.agrega(1);
        conjunto1.agrega(2);
        conjunto1.agrega(3);
        conjunto1.agrega(4);
        
        consultaElementosIterador(conjunto1);
        
        conjunto2.agrega(5);
        conjunto2.agrega(6);
        conjunto2.agrega(7);
        conjunto2.agrega(8);
        
        Set<Integer> set = new HashSet<Integer> (); 
        Set<Integer> set2 = new HashSet<Integer> (); 
        
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        
        System.out.println(sonDisjuntos2(set,set2));
        
        System.out.println(sonDisjuntos(conjunto1,conjunto2));
        System.out.println(conjunto1.toString());
        System.out.println(conjunto2.toString());
        try {
            System.out.println(sonDisjuntos(null,null));
        } catch (Exception e) {
            
        }
        
        conjunto3.agrega(1);
        conjunto3.agrega(2);
        conjunto3.agrega(3);
        conjunto3.agrega(4);
        
        conjunto4.agrega(1);
        conjunto4.agrega(6);
        conjunto4.agrega(7);
        conjunto4.agrega(8);
        
        System.out.println(sonDisjuntos(conjunto3,conjunto4));
        System.out.println(conjunto3.toString());
        System.out.println(conjunto4.toString());
        
    }
}
