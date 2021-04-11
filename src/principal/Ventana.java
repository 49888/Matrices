
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
import javax.swing.SpinnerNumberModel;
import javax.swing.text.JTextComponent;


public class Ventana extends JFrame{
    
    JTextComponent[][] Inputs;
        
    public Ventana(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(superior(), BorderLayout.NORTH); 

        this.add(crearMatriz(3, 3), BorderLayout.CENTER);

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
    private JComponent crearMatriz(int filas, int columnas){

        Inputs = new JTextComponent[filas][columnas];

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));

        panel.add( MatrizView.inputMatriz(filas, columnas, Inputs) );

        return new JScrollPane(panel);
    }
        
 //------------------------- PANEL INFERIOR ------------------------------
    private JComponent inferior(){

        JButton boton = new JButton("Cargar Matriz");

        boton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){

                double[][] A = MatrizView.obtenerMatriz(Inputs);

                for(double[] ds : A){
                    System.out.println( Arrays.toString(ds) );
                }
            }
        });


     //---> Panel   
        JPanel panel = new JPanel();

        panel.add(boton);

        return panel;
    }
    
    

 //Fin de Clase Ventana
}
