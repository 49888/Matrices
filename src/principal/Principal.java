
package principal;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.text.JTextComponent;


public class Principal {

    
    
    public static void main(String[] args){
        
        Ventana A = new Ventana();
        
        A.setTitle("Matrices");
            
        A.setSize(500, 500);    A.setLocationRelativeTo(null);

        A.setVisible(true);
    }
       
}
