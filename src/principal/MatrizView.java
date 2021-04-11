
package principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;




public class MatrizView  {

    
 //---------------------------- VISUALIZAR MATRIZ
    public static JComponent getView(String[][] matriz, String title){
        
        int filas = matriz.length;  int columnas = matriz[0].length;
        
     //Layout   
        GridLayout layout = new GridLayout(filas, columnas);
        
        layout.setHgap(10);  layout.setVgap(10);
          
     //Papel   
        JPanel panel = new JPanel(layout);
        
        for(int i = 0; i < filas; i++){
            
            for(int j = 0; j < columnas; j++){
                
                String name = Integer.toString(i+1) + Integer.toString(j+1);
                
                panel.add( labelItem(matriz[i][j], name, name) );
            }
        }
        
        return panel;
    }
    
    private static JLabel labelItem(String text, String name, String tooltip){
        
        JLabel label = new JLabel();
                
            label.setText(text);
            label.setName(name);
            label.setToolTipText(tooltip);

            label.setHorizontalAlignment(JLabel.CENTER);

            label.setPreferredSize(new Dimension(70, 50));

            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        return label;
    }
            
 //----------------------------- INGRESAR MATRIZ
    public static JComponent inputMatriz(int filas, int columnas){
        
     //Layout   
        GridLayout layout = new GridLayout(filas, columnas);
        
        layout.setHgap(10);  layout.setVgap(10);
          
     //Papel   
        JPanel panel = new JPanel(layout);
        
        for(int i = 0; i < filas; i++){
            
            for(int j = 0; j < columnas; j++){
                
                String name = Integer.toString(i+1) + Integer.toString(j+1);
                
                panel.add( inputItem(name) );
            }
        }
        
        return panel;
    }
    
    private static JTextField inputItem(String name){
        
        JTextField input = new JTextField();
        
        input.setName(name);
        
        input.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        input.setHorizontalAlignment(JTextField.CENTER);
        
        input.setPreferredSize(new Dimension(70, 50));
        
        return input;
    }
    
 //Fin de Clase MatrizView
}
