
package principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;


public class Principal {

    
    public static void main(String[] args){
        
        Ventana A = new Ventana();
        
        
        A.setTitle("Matrices");
            
        A.setSize(500, 500);    A.setLocationRelativeTo(null);

        A.setVisible(true);
    }
    
    private static class Ventana extends JFrame {

        public Ventana(){
            
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            this.add(superior(), BorderLayout.NORTH);  
        }
        
        private JPanel superior(){
            
            
            JComponent filas = inputNumber("Filas");
            
            JComponent columnas = inputNumber("Columnas");
            
            
         //--- Panel   
            FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 50, 5);
            
            JPanel panel = new JPanel(layout);
              
            panel.add(filas);   panel.add(columnas);
            
            return panel;
        }
        
        private JComponent inputNumber(String title){
            
            JSpinner number = new JSpinner(new SpinnerNumberModel(3, 1, 10, 1));
            number.setName(title);
            
            JLabel name = new JLabel(title);
            
         //--- Panel   
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
              
            panel.add(name);   panel.add(number);
            
            return panel;
        }
    }
}
