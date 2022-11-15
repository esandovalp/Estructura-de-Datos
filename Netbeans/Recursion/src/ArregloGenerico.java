

public class ArregloGenerico <T extends Comparable> {
    
    //Problema a
    //Búsqueda secuencial: recibe un dato tipo T y regresa la posición en la que está o un -1 si no está.
    public static <T> int busquedaSecuencial(T[] arr, T dato, int total) {
        
         if ( total == 0)
            return -1;
         else
            return busquedaSecuencial(arr, dato, total, 0);
    }
    
    private static <T> int busquedaSecuencial(T[] arr, T dato, int total, int pos)  {
        
        if (pos < total){
            if(dato.equals(arr[pos]))
                return pos;
            else 
                return busquedaSecuencial(arr,dato,total,pos+1);
        } else 
            return -1;
    }
    
    //Problema b
    //Búsqueda binaria: recibe un dato tipo T y regresa la posición en la que está o el negativo de la posición + 1 en la que debería estar.
    public static int binarySearchRecursive(int search, int[] array, int start, int end){
        int middle = (start + end)/2;

        if(end < start)
                 return -1;
        
        if (search < array[middle])
                return binarySearchRecursive(search, array, start, middle - 1);
        
        if (search > array[middle])
                return binarySearchRecursive(search, array, middle + 1, end);

        if (search == array[middle])
                return middle;
		
        return -1;
    }
    //Problema c 
    // toString(): regresa el contenido del arreglo en forma de cadena.
    
    public static <T> String toString(T[] arreglo){
        if (arreglo == null)
            throw new RuntimeException("Esta vacio");
        return toString(arreglo,0, new StringBuilder());
    }
    
    private static <T> String toString(T[] arreglo, int pos, StringBuilder sB ){
        if (pos == arreglo.length){     // estado base 
            return sB.toString();
        } else {
            sB.append(arreglo[pos]).append(" ");
            return toString(arreglo,pos + 1, sB);
        }
    }
    
    //Problema d
    // 4) Método que encuentre y regrese la posición del mayor de los elementos del arreglo.
    public static int regresaMayor(int[] arreglo, int total){
        return regresaMayor(arreglo, total, 0, 0);
    }
   
    private static int regresaMayor(int[] arreglo, int total, int pos, int mayor){
        if (pos < total){
            mayor = arreglo[pos];
            if (mayor < regresaMayor(arreglo, total ,pos + 1, mayor))
                mayor = regresaMayor(arreglo, total, pos + 1, mayor);
        }
        return mayor;
    }
    
    // Problema e 
    // Método que elimine todas las ocurrencias de un cierto objeto en el arreglo.
    // Decide qué parámetros se necesitan y qué tipo de resultado da el método.
    private static <T> void eliminaOcurrencias(T[] arr, T obj, int total){
        if (arr == null)
            throw new RuntimeException("Esta vacio");
        eliminaOcurrencias(arr, obj, 0, total);
    }
    
    private static <T> void eliminaOcurrencias(T[] arr, T obj, int pos, int total){
        
        if (pos < total) {
            if (arr[pos].equals(obj))
                arr[pos] = null;
            else
                eliminaOcurrencias(arr, obj, pos + 1, total);
        }
    }
    
    // Problema f
    // Método todo de ordenación por selección directa.  
    // Return minimum index
    private static int minIndex(int a[], int i, int j){
        if (i == j)
            return i;
        // Find minimum of remaining elements
        int k = minIndex(a, i + 1, j);
        // Return minimum of current and remaining.
            return (a[i] < a[k])? i : k;
	}
	
    public void ordenacionPorSelecDirecta(int a[], int total){
        recurSelectionSort(a, total, 0);
    }

    private static void recurSelectionSort(int a[], int n, int index) {
    
    if (index == n)     // Return when starting and size are same
        return;
    
    int k = minIndex(a, index, n-1);    // calling minimum index function for minimum index
    
    if (k != index){    // Swapping when index nd minimum index are not same
        int temp = a[k];    // swap
        a[k] = a[index];
        a[index] = temp;
    }
    
    recurSelectionSort(a, n, index + 1);    // Recursively calling selection sort function

    }
    
    public static void main(String[] args)  {
        
        Object[] a1 = {2, 3, 4, 6, 8};
        Object[] a2 = {"casa", 'c', 1, 3};
        int totalA1 = a1.length;
        int totalA2 = a2.length;
        Object[] a3 = {}; // length = 0
        int totalA3 = a3.length;
        
        int[] b1 = {2, 3, 9, 6, 8};
        
        Object[] e1 = {"casa", 'c', 1, 3};
        Object[] e2 = null;
        
        System.out.println("Pruebas problema a:" );
        System.out.println(a1.length);
        System.out.println(busquedaSecuencial(a1, 3, totalA1));
        System.out.println(busquedaSecuencial(a2, 3, totalA2));
        System.out.println(busquedaSecuencial(a3,3, totalA3));
        
        System.out.println("\nPruebas problema busqueda binaria: ");
        System.out.println(binarySearchRecursive(6, b1, 0, totalA1));

        System.out.println("\nPruebas problema c: ");
        System.out.println(toString(a1));
        
        System.out.println("\nPruebas problema d: ");
        System.out.println(regresaMayor(b1, totalA1));

        System.out.println("\nPruebas problema eliminaOcurrencias: " + toString(e1));
        eliminaOcurrencias(e1, 3, e1.length);
        System.out.println(toString(e1));
        
        try {
            System.out.println("\nPrueba con null: " + toString(e2));
            eliminaOcurrencias(e2, "perro", e2.length);
            System.out.println(toString(e2));

        } catch(Exception e){
            System.out.println(e);
        }
        
        System.out.println("\n");
        int arr[] = {3, 1, 5, 2, 7, 0};
        for (int i = 0; i< arr.length; i++)
            System.out.print(arr[i] + " ");
        
        recurSelectionSort(arr, arr.length, 0);
        
        System.out.println("\n");
        for (int i = 0; i< arr.length; i++)
            System.out.print(arr[i] + " ");
        
    }
}
