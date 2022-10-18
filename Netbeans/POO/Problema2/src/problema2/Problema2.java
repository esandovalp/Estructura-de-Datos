
package problema2;

public class Problema2 {

    public static void main(String[] args) {
        Cuadrado cuadradoX = new Cuadrado(4);
        System.out.println("Area de cuadrado X: " + cuadradoX.calculaArea());
        System.out.println("Perimetro de cuadrado X: " + cuadradoX.calculaPerimetro());
        
        Restaurante r = new Restaurante("Sonora Grill");
        System.out.println(r.registraMesas(3));
        System.out.println(r.registraMesas(4));
        System.out.println(r.registraMesas(5));
        
        System.out.println("Total metros tela: " + r.totalMetrosTela());
        System.out.println("Total metros lineales: " + r.totalMetrosLineales());
    }
    
}
