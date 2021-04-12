
package Extra;


public class Fraccion {
    
    int numerador;
        int denominador;

    public Fraccion(int numerador, int denominador){
        this.numerador = numerador;
        this.denominador = denominador;
    }

    @Override
    public String toString() {
        return numerador + " / " + denominador;
    } 
    
 //-----------------------------------------------------------------------   
    
    //Convertir decimal a fraccion
    public static Fraccion convFraccion(double N){
        
        boolean negativo = false;
        
        if(N < 0){
            negativo = true;
            N = Math.abs(N);
        }
        
        int num = 1;   int den = 1;
        
        double aux = (double)(num)/(double)(den);

        while( aux != N ){
            
            if(aux < N){
                num++;
            }
            else {
                num--;
                den++;
            }

            aux = (double)(num)/(double)(den); 
        }
        
        if(negativo) num *= -1;
        
        return new Fraccion(num, den);
    }
    
    
    //Algoritmo de Euclides para encontrar el maximo comun divisor
    public static int MCD(int A, int B){
        
        int mcd = 1;
        
        int max = Math.max(A, B);  int min = Math.min(A, B);
        
        if(max % min == 0){
            
            mcd = min;
        }
        else {
            mcd = MCD(min, max % min);
        }
        
        return mcd;
    }
    
 //Fin de clase Fraccion
}
