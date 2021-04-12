
package Extra;


public class Determinante {
    
    public static boolean puedeCalcularse(double[][] matriz){
        
        if(matriz.length == matriz[0].length){
            
            return true;
        }
        else {
            return false;
        }
    }
    
 //------------------------------------------------------------------------------------   
    
    //Determinante por la Regla de Laplace
    public static double detLaplace(double[][] matriz){
        
        double det = 0;
        
        if(matriz.length == 1){
            
            det = matriz[0][0];
        }
        else {
            
            for(int i = 0; i < matriz[0].length; i++){
                
                det += matriz[0][i] * Math.pow(-1, (0 + i)) * detLaplace( adjunta(0, i, matriz) );
            }
        }
        
        return det;
    }
    
    //Retorna la matriz quitando la fila y columna indicada
    public static double[][] adjunta(int fila, int columna, double[][] matriz){
        
        double AUX[][] = new double[matriz.length-1][matriz[0].length-1];
        
        int I = 0, J = 0;
        
        for(int i = 0; i < matriz.length; i++){
            
            if(fila != i){
                
                for(int j = 0; j < matriz[i].length; j++){
            
                    if(columna != j){

                        AUX[I][J] = matriz[i][j];
                        J++;
                    }
                }
                
                I++;    J = 0;  
            }   
        }
        
        return AUX;    
    }
    
 //-------------------------------------------------------------------------------------
    
    //Determinante por el Metodo de Gauss
    public static double detGauss(double[][] matriz){
        
        int cont = 0;
        
        double[][] AUX = matriz.clone();
        
        for(int i = 0; i < AUX.length; i++){
            
            double pivot = AUX[i][i];
            
            int f = i;
            
            while(pivot == 0 && f < AUX.length - 1){
                
                for(int k = f; i <= k; k--){
                                       
                    intercambiarFila(k, AUX);

                    cont++;
                }              
                
                pivot = AUX[i][i];
                f++;
            }

            
            if(pivot != 0){
                
                for(int j = i + 1; j < AUX[0].length; j++){
                    
                    double N = AUX[j][i]/pivot;
                    
                    sumarFila(AUX[j], -N, AUX[i]);
                }
            }
            else{
                return 0;
            }
        }
        
        double det = 1;
        
        for(int i = 0; i < AUX.length; i++) {
            
            det *= AUX[i][i];
        }
        
        if(cont % 2 != 0) det *= -1;
        
        return det;
    }
    
    //Multiplica la Fila A por N --> A = N *A
    private static void producto(double A[], double N){
        
        for(int i = 0; i < A.length; i++){
            
            A[i] = N * A[i];
        }
    }
    
    //Suma a la Fila A la Fila B multiplicada por N --> A = A + N*B
    private static void sumarFila(double A[], double N, double[] B){
        
        for(int i = 0; i < A.length; i++){
            
            A[i] += N * B[i];
        }
    }
    
    //Intercambia la Fila i con la Fila  i + 1
    private static void intercambiarFila(int i, double[][] A){
        
        double[] aux = A[i];
        
        A[i] = A[i + 1];
        
        A[i + 1] = aux;
    }
    
 //Fin de la Clase Determinante
}
