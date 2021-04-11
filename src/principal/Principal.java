
package principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;


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
            
            this.add(crearTabla(), BorderLayout.CENTER);
            
            this.add(inferior(), BorderLayout.SOUTH);
        }
        
     //------------------------- PANEL SUPERIOR ------------------------------   
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
            number.setPreferredSize(new Dimension(70, 25));
            
            JLabel name = new JLabel(title);
            
         //--- Panel   
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
              
            panel.add(name);   panel.add(number);
            
            return panel;
        }
        
        
     //------------------------- PANEL CENTRAL ------------------------------   
        private JComponent crearTabla(){
            
            String[][] A = {
                {"00", "01", "02", "03"},
                {"10", "11", "12", "03"},
                {"20", "21", "22", "02"},
            };
            
            
            
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
             
            panel.add(MatrizView.inputMatriz(7, 7));
            
            return new JScrollPane(panel);
        }
        
     //------------------------- PANEL INFERIOR ------------------------------
        private JComponent inferior(){
            
            JButton boton = new JButton("Cargar Matriz");
            
            JPanel panel = new JPanel();
            
            panel.add(boton);
            
            return panel;
        }
        
     //Fin de Clase Ventana
    }
}
