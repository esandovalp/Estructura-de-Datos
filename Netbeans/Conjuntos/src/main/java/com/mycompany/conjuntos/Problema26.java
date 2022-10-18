
package com.mycompany.conjuntos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problema26 {
    
    public static String imprimeInglesyFrances(ConjuntoADT<String> ingles, ConjuntoADT<String> frances ){
        StringBuilder sB = new StringBuilder();
        
        ingles.interseccion(frances);
        
        for (String alumno : ingles){
            sB.append(ingles.toString());
        }
        
        return sB.toString();
    } 
    
    
    public static void main(String[] args) throws FileNotFoundException  {
        ConjuntoADT<String> ingles = new ConjuntoA();
        ConjuntoADT<String> frances = new ConjuntoA();
        ConjuntoADT<String> otros = new ConjuntoA();

        
        
        File doc = new File("IdiomasExtranjeros");
        Scanner lee = new Scanner(doc);
        String al;
        int n;
        
        // debes incluir un método estático para leer los datos de un archivo de texto e ir guardándolos en los conjuntos
        // se agrega solamente el nombre
        
        
        while (lee.hasNextLine()) {
            al = lee.nextLine();
            n = al.indexOf(",");
            
            String idioma = al.substring(0,n);
            String nombre = al.substring(n+1);
            
            switch (idioma) {
                case "ingles" -> ingles.agrega(nombre);
                case "frances" -> frances.agrega(nombre);
                default -> otros.agrega(nombre);
            }
        }    
        
        System.out.println("\nAlumnos del conjunto ingles: " + ingles.toString());
        System.out.println("\nAlumnos del conjunto frances: " + frances.toString());
        System.out.println("\nAlumnos del conjunto otros: " + otros.toString());
    }
    
}

