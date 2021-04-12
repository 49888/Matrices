
package principal;

import Extra.Determinante;
import Extra.Matrices;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class Barra extends JMenuBar {

    
    ButtonGroup grupo = new ButtonGroup();
    
    JPanel panelCentral;
    
    MatrizInput matrizInput;
    
    JPanel panelSuperior;
    
    public Barra(JPanel panelCentral, JPanel panelSuperior){
        
        this.panelCentral = panelCentral;
        
        this.panelSuperior = panelSuperior;
        
        JToggleButton Matriz = boton("Matriz");
        JToggleButton Traspuesta = boton("Traspuesta");
        JToggleButton Cofactores = boton("Cofactores");
        JToggleButton Adjunta = boton("Adjunta");
        JToggleButton Inversa = boton("Inversa");
        JToggleButton Determinante = boton("Determinante");
        
        Matriz.setSelected(true);
        
        
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        
        panel.add(Matriz);  panel.add(Traspuesta);  panel.add(Cofactores);
        panel.add(Adjunta); panel.add(Inversa);     panel.add(Determinante);
        
        this.add(panel);
    }
    
    private JToggleButton boton(String name){
        
        JToggleButton boton = new JToggleButton();
        
        boton.setText(name);
        boton.setName(name);
        
        boton.setBackground(Color.GRAY.lightGray);
        
        
        boton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                JToggleButton target = (JToggleButton)e.getSource();
                
                panelCentral.removeAll();
                
                if(target.getName() == "Matriz"){
                    
                    panelSuperior.setVisible(true);
                    
                    panelCentral.add(matrizInput);
                }
                else {
                    panelSuperior.setVisible(false);
                    
                   JComponent panel = calcular( target.getName() );
                   
                   if(panel != null) panelCentral.add(panel);   
                }
 
                panelCentral.setVisible(false); panelCentral.setVisible(true);
            }
        });
        //*/
        
        grupo.add(boton);
        
        return boton;
    }
    
    private JComponent calcular(String n){
        
        JComponent AUX = null;
        
        double[][] Matriz = matrizInput.obtenerMatriz();
            
        if(Matriz != null){
            
            if(n == "Traspuesta"){
                
                AUX = new MatrizView( Matrices.traspuesta(Matriz) );
            }
            else {
                
                if( Determinante.puedeCalcularse(Matriz) ){
                    
                    switch( n ){

                        case "Cofactores":
                            break;

                        case "Adjunta":
                            break;

                        case "Inversa":
                            break;

                        case "Determinante":
                           break;
                    }
                }
                else{
                    JOptionPane.showMessageDialog(panelCentral, "La matriz no es Cuadrada", "Error", JOptionPane.ERROR_MESSAGE);
                }    
            }
        }    
            
        return AUX;
    }
    
    public void setMatrizInput(MatrizInput input){
        
        this.matrizInput = input;
    }
}
