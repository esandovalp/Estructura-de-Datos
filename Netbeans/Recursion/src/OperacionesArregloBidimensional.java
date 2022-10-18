
public class OperacionesArregloBidimensional {
    //Problema 1
    //sumaPorRenglón: suma por renglón todos los elementos del arreglo bidimensional, regresando la suma obtenida.
    public static int sumaTotalPorRenglon(int[][] arr){
        return sumaTotalPorRenglon(arr, 0, 0);
    }
    
    private static int sumaTotalPorRenglon(int[][] arr, int pos, int suma){
        
        if (pos < arr[0].length)
            suma = sumaPorRenglon(arr, pos ) + sumaTotalPorRenglon( arr,  pos+ 1, suma);
        
        return suma;
    }
    
    private static int sumaPorRenglon(int[][] arr, int renglon){
       return sumaPorRenglon(arr, renglon, 0, 0);
   }
   
   private static int sumaPorRenglon(int[][] arr, int renglon, int pos, int suma){
       
       if (pos < arr.length)
           suma = arr[renglon][pos] + sumaPorRenglon( arr,  renglon,  pos+1, suma);
       
       return  suma;
   }
   
   // Problema 2 
   // sumaPorColumna: suma por columna todos los elementos del arreglo bidimensional, regresando la suma obtenida.
   public static int sumaTotalPorColumna(int[][] arr) {
       return sumaTotalPorColumna(arr, 0, 0);
   }
   
   private static int sumaTotalPorColumna(int[][] arr, int pos, int suma){
       
       if (pos < arr.length)
           suma =  sumaPorColumna(arr, pos) + sumaTotalPorColumna(arr, pos + 1, suma);
       
       return suma;
   }
   
   private static int sumaPorColumna(int[][] arr, int columna){
       return sumaPorColumna(arr, columna, 0, 0);
   }
   
   private static int sumaPorColumna(int[][] arr, int columna, int pos, int suma) {
       
       if (pos < arr.length) {
           suma =   arr[pos][columna] + sumaPorColumna(arr, columna, pos + 1, suma);
       }
       
       return suma;
   }
   
   // Problema 3
   // toString(): regresa el contenido del arreglo en forma de cadena.
   public static String toString(int[][] arr){
       return toString(arr, 0, new StringBuilder());
   }
   
   private static String toString(int[][] arr, int pos, StringBuilder sB){
       
       //if (pos == arr.length) return sB.toString();
       
       if (pos < arr.length){
           sB.append(stringRenglon(arr,pos)).append(" ");
           toString(arr, pos+1,sB);
       }
       
       return sB.toString();
   }
   
   private static String stringRenglon(int a[][], int renglon){
       return stringRenglon(a, renglon, 0, new StringBuilder());
   }
   
   private static String stringRenglon(int a[][], int renglon, int pos, StringBuilder sB){
       
       if (pos == a.length)
           return sB.toString();
       
       if (pos < a.length){
           sB.append(a[renglon][pos]);
           stringRenglon(a,renglon,pos+1, sB);
       }
       return sB.toString();
   }
   
   // Problema 4 
   // sumaDiagonalPrincipal: suma y regresa los elementos de la diagonal principal.
   public static int sumaDiagonal(int[][] arr){         
       if (arr.length < arr[0].length || arr[0].length < arr.length)
           throw new RuntimeException();
       return sumaDiagonal(arr, 0, 0);
   }
   
   private static int sumaDiagonal(int arr[][], int pos, int suma){
       if (pos < arr[0].length)
           suma = suma + arr[pos][pos] + sumaDiagonal(arr, pos + 1, suma);
       
       return suma;
   }
   
   // 5) sumaMatrices: suma dos matrices y regresa la matriz resultado.
   
   public static String sumaMatrices(int[][] m1, int[][] m2) {
       int renglones = m1.length;
       int columnas = m1[0].length;
       
       int[][] res = new int[renglones][columnas];
       
       if (m1.length != m2.length || m1[0].length != m2[0].length)
           throw new RuntimeException("Las matrices no tienen el mismo tamaño");
       
       return sumaMatrices(m1, m2, 0, 0, res );
   }
   
   private static String sumaMatrices(int[][] m1, int[][] m2, int contR, int cont, int[][] res){
       int i=0;
       
       if (contR < res.length && cont < res.length){
           res[contR][cont] = sumaPorPos(m1,m2,contR,cont);
           sumaMatrices(m1,m2,0,cont+1,res);
       }
       
       return toString(res);
   }
   
   private static int sumaPorPos(int[][] m1, int[][] m2, int renglon, int pos){
       return  m1[renglon][pos] + m2[renglon][pos];     // asi es diagonal, quiero que se vaya moviendo por renglon o columna.
   }
  
    public static void main(String[] args) {
        int[][] a1= { {1,4},          // esta notacion es la perrona 
                      {3,6} };        // primera [] renglon segunda [] columna 
        int[][] a2 = { {1,2,3},     // este caso no funciona 
                       {4,5,6}};
        int[][] a3 = { {1,2,3},
                       {4,5,6},
                       {7,8,9}};
        
        int[][] a4 = { {1,3,2},
                       {1,1,0},
                       {2,0,1}};
        
        int[][] a5= { {1,4},          // esta notacion es la perrona 
                      {3,6} };
        
        System.out.println("Length " + a2[0].length);
        
        for (int i=0;i<2;i++){
            for (int j=0;j<2;j++){
                System.out.println(a1[i][j]);
            }
        }
        
        System.out.println("\nSuma por renglon: " + sumaPorRenglon(a1, 0));
        System.out.println("\nSuma total por renglon: " + sumaTotalPorRenglon(a1));
        
        System.out.println("\nSuma por columna: " + sumaPorColumna(a3, 0));
        System.out.println("\nSuma por columna: " + sumaTotalPorColumna(a3));
        
        System.out.println("\nString: " + toString(a1));
        
        System.out.println("\nSuma por diagonal 1: " + sumaDiagonal(a1));
        
        try{
            System.out.println("\nSuma por diagonal 2: " + sumaDiagonal(a2));
             
        } catch(Exception e){
            System.out.println("\nNo corrio");
        }
        
        System.out.println("\nSuma por diagonal 3: " + sumaDiagonal(a3));

        System.out.println("\nSuma posicion por posicion: " + sumaPorPos(a3,a4,0,1));
        
        System.out.println("\nSuma matrices: " + sumaMatrices(a3,a4));
        
        System.out.println("\nSuma matrices: " + sumaMatrices(a1,a5));
        
    }
}
