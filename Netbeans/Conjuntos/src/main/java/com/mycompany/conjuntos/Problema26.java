
package com.mycompany.conjuntos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problema26 {
    
    // 1) Generar una cadena con los nombres de todos los alumnos que dominan inglés y francés  
    public static String inglesYFrances(ConjuntoADT<String> ingles, ConjuntoADT<String> frances){
        ConjuntoADT<String> inter = ingles.interseccion(frances);
        String cad = "";
        
        if (inter.estaVacio() == true)
            cad = cad + "Esta vacio";
        else
            cad += inter.toString();
        
        return cad;
    }
    
    // 2) Obtener el total de alumnos que sólo dominan inglés
    public static int totalIngles(ConjuntoADT<String> ingles ) {
        int n = 0;
        
        for (String i : ingles){
            n++;
        }
        
        return n;
    }
    
    // 3) Generar una cadena con los nombres de los alumnos que dominan, al menos, 3 idiomas.
    public static String tresIdiomas(ConjuntoADT<String> ingles, ConjuntoADT<String> frances, ConjuntoADT<String> otros){
        ConjuntoADT<String> inter = ingles.interseccion(frances).interseccion(otros);
        String cad = "";
        
        if (inter.estaVacio() == true)
            cad = cad + "Esta vacio";
        else
            cad += inter.toString();
        
        return cad;
    }
    
    public static void main(String[] args) throws FileNotFoundException  {
        ConjuntoADT<String> ingles = new ConjuntoA();
        ConjuntoADT<String> frances = new ConjuntoA();
        ConjuntoADT<String> otros = new ConjuntoA();
        
        File doc = new File("IdiomasExtranjeros");
        Scanner lee = new Scanner(doc);
        String alumno;
        int n;
        
        // debes incluir un método estático para leer los datos de un archivo de texto e ir guardándolos en los conjuntos
        // se agrega solamente el nombre
        while (lee.hasNextLine()) {
            alumno = lee.nextLine();
            n = alumno.indexOf(",");
            
            String idioma = alumno.substring(0,n);
            String nombre = alumno.substring(n+1);
            
            switch (idioma) {
                case "ingles" -> ingles.agrega(nombre);
                case "frances" -> frances.agrega(nombre);
                default -> otros.agrega(nombre);
            }
        }    
        
        System.out.println("\nAlumnos del conjunto ingles: " + ingles.toString());
        System.out.println("\nAlumnos del conjunto frances: " + frances.toString());
        System.out.println("\nAlumnos del conjunto otros: " + otros.toString());
        
        System.out.println("\nAlumnos que están en ingles y frances: " + inglesYFrances(ingles, frances));
        
        System.out.println("\nTotal de alumnos que dominan el ingles: " + totalIngles(ingles));
        
        System.out.println("\nAlumnos que están en ingles y frances: " + tresIdiomas(ingles, frances,otros));
    }
    
}

