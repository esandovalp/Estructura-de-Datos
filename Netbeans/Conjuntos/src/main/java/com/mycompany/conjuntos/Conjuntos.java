
package com.mycompany.conjuntos;

import java.util.Iterator;

public class Conjuntos {

    public static void main(String[] args) {        
        ConjuntoADT<String> col1 = new ConjuntoA();
        ConjuntoADT<String> col2 = new ConjuntoA();
        ConjuntoADT<Alumno> c2 = new ConjuntoA();

        col1.agrega("rojo");
        col1.agrega("verde");
        col1.agrega("gris");
        col1.agrega("azul");
        col1.agrega("oro");
        
        col2.agrega("rojo");
        col2.agrega("blanco");
        col2.agrega("negro");
        col2.agrega("violeta");
        col2.agrega("oro");
        
        System.out.println("\nConjunto de colores: " + col1.toString());
        System.out.println("\nResultado de agregar el rojo: " + col1.agrega("rojo"));
        
        c2.agrega(new Alumno(100,9.5));
        c2.agrega(new Alumno(101,8.3));
        c2.agrega(new Alumno(120,8.9));
        c2.agrega(new Alumno(50,8.0));
        c2.agrega(new Alumno(123,7.3));
        c2.agrega(new Alumno(1233,9.3));
        System.out.println("\nConjunto de alumnos " + c2);
        
        // Ejemplo del uso del iterador
        Iterator<Alumno> it = c2.iterator();
        double max = -1;
        Alumno alum;
        String resultado = "";
        
        while (it.hasNext()){   // es booleano, hay o no hay 
            alum = it.next();
            if (alum.getProm() > max){
                max = alum.getProm();
                resultado = alum.toString();
            }
        }
        
        System.out.println("\nDatos del alumno con mayor calificación: " + resultado);
        
        /* Ejemplo iterador integrado de java 
            for (tipo var: collec) 
        */
        
        int min = 100;
        for (String s : col1)
            if (s.length() < min)
                min = s.length();
        
        System.out.println("\nLongitud minima " + min);
        
        System.out.println("\nConjunto union: " + col1.union(col2));
        
    }
}
