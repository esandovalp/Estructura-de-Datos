
public class Pruevas {

    public static int sumaArreglo(int[] arreglo) {
        int suma = 0;
        for (int i = 0; i < arreglo.length; i++) {
            suma = suma + arreglo[i];
        }

        return suma;
    }

    public static String imprimeIzqDer(int[] arreglo) {
        StringBuilder sB = new StringBuilder();

        for (int i = 0; i < arreglo.length; i++) {
            sB.append(arreglo[i]);
        }

        return sB.toString();
    }

    public static String imprimeDerIzq(int[] arreglo) {
        StringBuilder sB = new StringBuilder();

        for (int i = arreglo.length - 1; i >= 0; i--) {
            sB.append(arreglo[i]);
        }

        return sB.toString();
    }

    public static <T> int busquedaSecuencial(int[] array, T dato) {
        int res = -1;

        for (int i = 0; i < array.length; i++) {

            if (dato instanceof Integer) {
                if (array[i] == (Integer) dato) {
                    res = i;
                }
            }
        }
        return res;
    }

    public static int busquedaBinaria(int[] arr, int num) {
        if (arr == null) {
            return -1;
        }

        int izq = 0;
        int der = arr.length - 1;

        while (izq <= der) {
            int mid = (izq + der) / 2;

            if (num < arr[mid]) {
                der = mid - 1;
            } else if (num > arr[mid]) {
                izq = mid;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void ordenSeleccionDirecta(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }

            int temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
                //0  1  2
   /* int a[][] = {{1, 1, 1},
                 {1, 1, 1},
                 {1, 1, 1}};
    */             

    public static int sumaTotalPorRenglones(int[][] arr) {
        int suma = 0;
        
        for (int i=0; i<arr[0].length; i++){
            suma = suma + sumaPorRenglon(arr,i);
        }
        
        return suma;
    }
    
    private static int sumaPorRenglon(int[][] arr, int renglon) {
        int suma = 0;
        
        for (int i = 0; i < arr.length; i++)
            suma = suma + arr[renglon][i];
        return suma;
    }
    
    public static int sumaTotalPorColumnas(int[][] arr) {
        int suma = 0;
        
        for (int i = 0; i < arr.length; i++){
            suma = suma + sumaPorColumna(arr, i);
        }
        return suma;
    }
    public static int sumaPorColumna(int[][] arr, int columna) {
        int suma = 0;
        
        for (int i=0; i < arr[0].length; i++) {
            suma = suma + arr[i][columna];
        }
        
        return suma;
    }
    
    public static String regresaStringRenglon(int[][] arr, int renglon){
        StringBuilder sB = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            sB.append(arr[0][i]);
        }
        
        return sB.toString();
    }
    
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        int[] b = null;
        int[] c = {3, 2, 4, 1, 8};
        int[][] d = {{1, 2},
                     {1, 1}};
        int[][] e = {{1, 1, 1},
                     {2, 2, 2}};
        
        int f[][] = {{1, 3, 1},
                    {1, 1, 1},
                    {4, 1, 1}};

        System.out.println("Suma arreglo recursivo: " + sumaArreglo(a));

        System.out.println("\n" + imprimeIzqDer(a));

        System.out.println("\n" + imprimeDerIzq(a));

        System.out.println("\n" + busquedaSecuencial(a, 4));

        System.out.println("\n" + busquedaBinaria(b, 4));

        System.out.println("\n");
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }

        System.out.println("\nDespues de la ordenacion: ");
        ordenSeleccionDirecta(c);

        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        
        System.out.println("\nSuma por renglon: "+ sumaPorRenglon(f,0));
        System.out.println("\nSuma total por renglones: " + sumaTotalPorRenglones(f));
        
        System.out.println("\nSuma por columnas: "+ sumaPorColumna(f,0));
        System.out.println("\nSuma total por columnas " + sumaTotalPorColumnas(f));
        
        System.out.println("\nString por renglones: " + regresaStringRenglon(f,0));
    }
}
