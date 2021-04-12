
package principal;

import java.awt.Dimension;


public class Principal {

    public static void main(String[] args){
        
        Ventana A = new Ventana();
        
        A.setTitle("Matrices");
            
        A.setSize(600, 500);    A.setLocationRelativeTo(null);
        
        A.setMinimumSize(new Dimension(550, 500));

        A.setVisible(true);  
    }
       
}
