/**
 * 
 * @author Emiliano Sandoval
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Problema9 c = new Problema9();
        
        System.out.println(c.altaFigurasTriangulo(2, 3,3));
        System.out.println(c.altaFigurasTriangulo(4, 4, 4));
        System.out.println(c.altaFigurasCirculo(8));
        System.out.println(c.altaFigurasCirculo(5));
        System.out.println(c.altaFigurasRectangulo(2, 4));
        System.out.println(c.altaFigurasCuadrado(3));
        System.out.println(c.altaFigurasCirculo(10));
        System.out.println(c.altaFigurasCuadrado(8));
        System.out.println(c.altaFigurasTriangulo(3, 3, 3));
        System.out.println(c.altaFigurasTriangulo(1, 1, 1));
        System.out.println(c.altaFigurasCuadrado(2));
        
        System.out.println("\nCadena de figuras: ");
        System.out.println(c.cadenaFiguras());
        
        System.out.println("\nCirculo mas grande: ");
        System.out.println(c.circuloGrande());
        
        System.out.println("\n" + c.totalCuadrados());
        
        System.out.println("\nBorrar triangulos equilateros: " );
        c.eliminaEquilateros();
        System.out.println(c.cadenaFiguras());
    }
    
}
