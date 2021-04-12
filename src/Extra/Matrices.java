
package Extra;

import java.util.Arrays;


public class Matrices extends Determinante {
    
    public static void main(String[] args) {
        
        double[][] A = {//-4
            {1, 2, 3},
            {4, 7, 6}, 
            {1, 1, 1}
        };
        
        //double[][] B = inversa(A);
        
        for (double[] ds : A) {
            System.out.println(Arrays.toString(ds));
        }
    }
        
    //Matriz Traspuesta
    public static double[][] traspuesta(double matriz[][]){
        
        double[][] aux = new double[matriz[0].length][matriz.length];
        
        for(int i = 0; i < matriz.length; i++){
            
            for(int j = 0; j < matriz[i].length; j++){
                
                aux[j][i] = matriz[i][j];
            }   
        }
        
        return aux;
    }
    
    //Matriz de Cofactores
    public static double[][] cofactores(double matriz[][]){
        
        double[][] aux = new double[matriz.length][matriz[0].length];
        
        for(int i = 0; i < matriz.length; i++){
            
            for(int j = 0; j < matriz[i].length; j++){
                
                double cof = Math.pow(-1, i + j) * detLaplace( adjunta(i, j, matriz) );
                aux[i][j] = cof;
            }   
        }
        
        return aux;
    }
    
    //Matriz Adjunta (Cofactores Traspuesta)
    public static double[][] adjunta(double matriz[][]){
        
        double[][] aux = new double[matriz.length][matriz[0].length];
        
        for(int i = 0; i < matriz.length; i++){
            
            for(int j = 0; j < matriz[i].length; j++){
                
                double cof = Math.pow(-1, i + j) * detLaplace( adjunta(i, j, matriz) );
                aux[j][i] = cof;
            }   
        }
        
        return aux;
    }
    
    //Matriz Inversa
    public static double[][] inversa(double matriz[][]) throws Exception {
        
        double det = Determinante.detLaplace(matriz);
        
        if(det == 0){
            throw new Exception("Determinante igual a 0");
        }
        
        double[][] AUX = new double[matriz.length][matriz[0].length];
        
        for(int i = 0; i < matriz.length; i++){
            
            for(int j = 0; j < matriz[i].length; j++){
                
                double cof = Math.pow(-1, i + j) * detLaplace( adjunta(i, j, matriz) );
                AUX[j][i] = cof / det;
            }   
        }
        
        return AUX;
    }
    
    
    
    //Matriz triangular superior 
    public static double[][] triangularSup(double[][] matriz){
          
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
                break;
            }
        }

        if(cont % 2 != 0) producto(AUX[0], -1);
        
        return AUX;
    }
    
 //Fin de Clase Matrices 
}
