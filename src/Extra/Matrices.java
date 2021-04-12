
package Extra;

import java.util.Arrays;


public class Matrices {
    
    public static void main(String[] args) {
        
        
    }
        
    
    public static double[][] traspuesta(double matriz[][]){
        
        double[][] aux = new double[matriz[0].length][matriz.length];
        
        for(int i = 0; i < matriz.length; i++){
            
            for(int j = 0; j < matriz[i].length; j++){
                
                aux[j][i] = matriz[i][j];
            }   
        }
        
        return aux;
    }
    
    
    public static double[][] inversa(double matriz[][]){
        
        double[][] AUX = new double[matriz.length][matriz[0].length];
        
        return AUX;
    }
}
