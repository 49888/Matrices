
package principal;

import Extra.Fraccion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;




public class MatrizView  extends JScrollPane {

    int Filas;  int Columnas;
    
    double[][] Matriz;
    
    public MatrizView(double[][] Matriz){
        
        this.Filas = Matriz.length;     this.Columnas = Matriz[0].length;
        
        this.Matriz = Matriz;
        
     //Layout   
        GridLayout layout = new GridLayout(Filas, Columnas);
        
        layout.setHgap(10);  layout.setVgap(10);
          
     //Papel   
        JPanel panel = new JPanel(layout);
        
        for(int i = 0; i < Filas; i++){
            
            for(int j = 0; j < Columnas; j++){
                
                String name = Integer.toString(i+1) + Integer.toString(j+1);
                
                String tooltip = null;
                
                String value = "";
                
                double N = Matriz[i][j];
                
                if( N - (long)N != 0 ){
                    
                    tooltip = Double.toString(N);
                    
                    Fraccion F = Fraccion.convFraccion(N);
                    
                    value = F.toString();
                }
                else{
                    value = Long.toString( (long)N );
                }
                
                panel.add( labelItem(value, name, tooltip) );
            }
        }
        
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        
        panel2.add(panel);
        
        this.setViewportView(panel2); 
    }
    
    

    private static JLabel labelItem(String text, String name, String tooltip){
        
        JLabel label = new JLabel();
                
            label.setText(text);
            label.setName(name);
            label.setToolTipText(tooltip);

            label.setHorizontalAlignment(JLabel.CENTER);

            label.setPreferredSize(new Dimension(70, 50));

            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            label.setBackground(Color.WHITE);
            label.setOpaque(true);
            label.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        return label;
    }
 
 //Fin de Clase MatrizView
}
