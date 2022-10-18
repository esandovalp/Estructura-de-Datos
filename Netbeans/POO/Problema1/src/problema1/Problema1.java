/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package problema1;

/**
 *
 * @author coron
 */
public class Problema1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Rectangulo rect1 = new Rectangulo(3,4);
        System.out.println("Area de un rectangulo: " + rect1.calculaArea() );
        
        ComplejoVacacional complejo = new ComplejoVacacional("Complejo cool");
        
        complejo.registraAlberca(2, 5);
        complejo.registraAlberca(3, 7);
        complejo.registraAlberca(5, 20);
        
        System.out.println("Total metros: " + complejo.totalMetrosLona());
        System.out.println("Total perimetro: " + complejo.totalMetrosLineales());
    }
    
}
