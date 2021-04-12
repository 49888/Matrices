
package principal;

import Extra.Determinante;
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
import javax.swing.JPanel;
import javax.swing.JToggleButton;


public class Barra extends JMenuBar {

    
    ButtonGroup grupo = new ButtonGroup();
    
    JPanel panelCentral;
    
    double[][] Matriz;      boolean Calcular = false;
    
    HashMap<String, Component[]> Escenas = new HashMap<>();
    
    public Barra(JPanel panelCentral){
        
        this.panelCentral = panelCentral;
        
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
        
        /*
        boton.addActionListener(new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                
                JToggleButton target = (JToggleButton)e.getSource();
                
                panelCentral.removeAll();
                
                JComponent panel = calcular( target.getName() );
  

                if(panel != null){
                    panelCentral.add(panel);      
                }
                
                panelCentral.setVisible(false); panelCentral.setVisible(true);
            }
        });
        //*/
        
        grupo.add(boton);
        
        return boton;
    }
    
    private JComponent calcular(String n){
        
        JPanel panel = null;
        
        switch( n ){

            case "Traspuesta":
                break; 

            case "Cofactores":
                break;

            case "Adjunta":
                break;

            case "Inversa":
                break;

            case "Determinante":
                double Det = Determinante.detLaplace(Matriz);

                JLabel det = new JLabel("Determinante: " + Det);

                panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 50));
                panel.add(det);
                break;
        }
        
        return panel;
    }
    
    public void setMatriz(double matriz[][], boolean calcular){
        
        this.Matriz = matriz;    this.Calcular = calcular;
    }
}
