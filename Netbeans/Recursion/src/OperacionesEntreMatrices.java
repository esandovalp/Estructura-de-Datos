
public class OperacionesEntreMatrices {
    
    public static int[][] adicionDeMatrices(int[][] mat1,int[][] mat2){
        return adicionDeMatrices(mat1,mat2,new int[mat1.length][mat1[0].length],0,0);
    }
    
    public static int[][] adicionDeMatrices(int[][] mat1,int[][] mat2,int[][] res,int i,int j){
        
        if (j >= mat1[0].length)
            return res;      // estado base
        
        res[i][j] = mat1[i][j] + mat2[i][j];
        
        i ++;
        
        if (i == mat1.length){
            i = 0;
            j ++;
        }
        
        return adicionDeMatrices(mat1, mat2, res, i, j);
        
    }
    public static void main(String[] args) {
        int[][] a = {{1, 2},
                     {1, 1}};
        
        int[][] b = {{1, 2},
                     {3, 1}};
        
        int[][] res2 = adicionDeMatrices(a,b);
                
        System.out.println("Suma de matrices: ");
        for(int[] renglon : res2) {
            for (int columna : renglon) 
                System.out.print(columna + "    ");
            System.out.println();
        }
        
        int[][] a3 = { {1,2,3},
                       {4,5,6},
                       {7,8,9}};
        
        int[][] a4 = { {1,3,2},
                       {1,1,0},
                       {2,0,1}};
        
        int[][] res3 = adicionDeMatrices(a3,a4);
                
        System.out.println("Suma de matrices: ");
        for(int[] renglon : res3) {
            for (int columna : renglon) 
                System.out.print(columna + "    ");
            System.out.println();
        }
    }
}
