
public class Recursion {
    
    public static int factorial(int n) {
        if ( n == 1 || n == 0) // Estado base 
            return 1; 
        else
            return n * factorial(n-1);
    }
    
    // 27) Escribe un método estático que reciba un arreglo de enteros y regrese la suma de sus componentes. Debes usar recursión. Prueba tu solución.
    public static int sumaArreglo(int[] arreglo) {
        return sumaArreglo(arreglo, 0,  0);
    }
    
    private static int sumaArreglo(int[] arreglo, int pos, int suma){
        
        if (pos < arreglo.length){
            suma = suma + arreglo[pos] + sumaArreglo(arreglo, pos + 1, suma);
        }
        
        return suma;
    }
    
    // 28)Escribe un método estático que reciba un arreglo de enteros e imprima cada uno de sus componentes: a) de izquierda a derecha y b) de derecha a izquierda. Debes usar recursión.
    public static String imprimeIzqDer (int[] arreglo) {
        return imprimeIzqDer(arreglo, 0);
    }
    
    private static String imprimeIzqDer (int[] arreglo, int pos) {
        
        if (pos < arreglo.length)
            return arreglo[pos] + "" + imprimeIzqDer(arreglo, pos + 1);
        else
            return "";
    }
    
    public static String imprimeDerIzq(int[] arreglo){
        int n = arreglo.length-1;   // el out of bounds es porque al imprimir en una posicion, empiezas desde 0
        return imprimeDerIzq(arreglo, n);
    }
    
    private static String imprimeDerIzq(int[] arreglo, int pos){
        
        if (pos >= 0)
            return arreglo[pos]+ "" + imprimeDerIzq(arreglo, pos - 1);
        else
            return "";
    }
    
    // Lectura de archivo 
    
    
    public static void main(String[] args) {
        
        System.out.println("Factorial: " + factorial(3));
        
        int[] a = {1,2,3,4,5};
        
        System.out.println("\nSuma arreglo: " + sumaArreglo(a));
        
        System.out.println("\nImprime izquierda a derecha: " + imprimeIzqDer(a));
        
        System.out.println("\nImprime derecha a izquierda: " + imprimeDerIzq(a));
    }
    
}
