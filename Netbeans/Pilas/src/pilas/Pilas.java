/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pilas;

/**
 *
 * @author coron
 */
public class Pilas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PilaA<Integer> p1 = new PilaA();      // Cualquier cosa con mayúscula es una clase 
        PilaA<Integer> p2 = new PilaA();
        
        p1.push(1);
        p2.push(1);
        p1.push(2);
        p2.push(2);
        
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println("\n" + p1.equals(p2));
        
    }
    
}
