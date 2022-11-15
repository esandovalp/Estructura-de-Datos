
public class OperacionesArregloBidimensional {
    //Problema 1
    //sumaPorRenglón: suma por renglón todos los elementos del arreglo bidimensional, regresando la suma obtenida.
    public static int sumaTotalPorRenglon(int[][] arr){
        return sumaTotalPorRenglon(arr, 0,0, 0);
    }
    
    private static int sumaTotalPorRenglon(int[][] arr, int i,int j, int suma){
        
        if (j == arr[0].length)
            return suma;
        
        suma = suma + arr[i][j];
        
        i++;
        
        if (i == arr.length) {
            i=0;
            j++;
        }
            
        return sumaTotalPorRenglon(arr,i,j,suma);
    }
   
   // Problema 2 
   // sumaPorColumna: suma por columna todos los elementos del arreglo bidimensional, regresando la suma obtenida.
   public static int sumaTotalPorColumna(int[][] arr) {
       return sumaTotalPorColumna(arr, 0, 0,0);
   }
   
   private static int sumaTotalPorColumna(int[][] arr, int i, int j, int suma){
       
       if (i == arr.length)
           return suma;
       
       suma = suma + arr[i][j];
       j++;
       
       if (j == arr[0].length) {
           j=0;
           i++;
       }
       
       return sumaTotalPorColumna(arr,i,j,suma);
   }
   
   // Problema 3
   // toString(): regresa el contenido del arreglo en forma de cadena.
   public static String toString(int[][] arr){
       return toString(arr, new StringBuilder(),0,0);
   }
   
   /*
   for(int[] renglon : res3) {
    for (int columna : renglon) 
        System.out.print(columna + "    ");
    System.out.println();
    }
   */
   private static String toString(int[][] arr, StringBuilder sB, int i, int j){
       
       //if (pos == arr.length) return sB.toString();
       if ( j == arr[0].length)
           return sB.toString();
       
       sB.append(arr[i][j]).append("  ");
       
       i++;
       
       if (i == arr.length){
           i = 0;
           j++;
       }
       
       return toString(arr,sB,i,j);
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
   
   
    public static boolean esSimetrica(int[][] mat, int tam){
	if (mat == null || tam <= 0)
            throw new RuntimeException();
        
	return esSimetrica (mat, tam, 0, 1);
    }

    private static boolean esSimetrica(int[][] mat, int tam, int i, int j){
	if ( i < tam )
            if (j < tam)
                if (mat[i][j] == mat[j][i])
                    return esSimetrica(mat, tam, i, j +1);
                else
                    return false;
            else
                return esSimetrica(mat,tam,i+1,i+2);        // en el else la j se hizo cero?
	else
            return true;
    }

    // matriz triangular inferior (Arriba de la diagonal son todos ceros)
    public static boolean esTriangularInferior(int[][] mat, int tam){
        if (mat == null || tam <= 0)
            throw new RuntimeException();
        
        return esTriangularInferior(mat, tam, 0, 1);
    }
    
    private static boolean esTriangularInferior(int[][] mat, int tam, int i, int j){
        if ( i < tam ){
            if (j < tam)
                if (mat[i][j] == 0)
                    return esTriangularInferior(mat,tam,i,j+1);
                else
                    return false;
            else
                return esTriangularInferior(mat,tam,i+1,i+2);
        } else
            return true;
    }
  
    public static void main(String[] args) {
        int[][] triangular = { {1,0,0},     // (0,0) (0,1) (0,2)
                               {2,1,0},     // (1,0) (1,1) (1,2)
                               {1,2,1}};    // (2,0) (2,1) (2,2)
        
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
        
        int[][] sime1 ={{1,1,2},
                       {1,1,0},
                       {2,0,1}};
        
        
        int[][] sime2= { {1,2},          
                         {2,3} };
        
        System.out.println("Matriz triangular inferior (si es): " + esTriangularInferior(triangular, 3));
        System.out.println("Matriz triangular inferior (no es): " + esTriangularInferior(sime1, 3));
        System.out.println("\nSimetrica: " + esSimetrica(sime1,3));

        
        int[][] a5= { {1,4},          
                      {3,6} };
        
        for(int[] renglon : a3) {
            for (int columna : renglon)
                System.out.print(columna + "  ");
            System.out.println();
}
        
        System.out.println("\nSuma total por renglon: " + sumaTotalPorRenglon(a1));
        
        System.out.println("\nSuma por columna: " + sumaTotalPorColumna(a3));
        
        System.out.println("\ntoString: " + toString(a1));
        
        System.out.println("\nSuma por diagonal 1: " + sumaDiagonal(a1));
        
        try{
            System.out.println("\nSuma por diagonal 2: " + sumaDiagonal(a2));
             
        } catch(Exception e){
            System.out.println("\nNo corrio");
        }
        
        System.out.println("\nSuma por diagonal 3: " + sumaDiagonal(a3));
        
    }
}
