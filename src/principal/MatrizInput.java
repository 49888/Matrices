
package principal;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.JTextComponent;


public class MatrizInput extends JScrollPane {
    
    int Filas;  int Columnas;
    
    JTextComponent[][] Inputs;

    public MatrizInput(int Filas, int Columnas){
        
        this.Filas = Filas;     this.Columnas = Columnas;
        
        this.Inputs = new JTextComponent[Filas][Columnas];
        
     //Layout   
        GridLayout layout = new GridLayout(this.Filas, this.Columnas);
        
        layout.setHgap(10);  layout.setVgap(10);
          
     //Papel   
        JPanel panel = new JPanel(layout);
        
        
        for(int i = 0; i < this.Filas; i++){
            
            for(int j = 0; j < this.Columnas; j++){
                
                String name = Integer.toString(i+1) + Integer.toString(j+1);
                
                JTextComponent input = inputItem(name);
                
                Inputs[i][j] = input;
                
                panel.add( input );
            }
        }
        
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 50, 20));
        
        panel2.add(panel);
        
        this.setViewportView(panel2);   
    }
    
    
    private static JTextField inputItem(String name){
        
        JTextField input = new JTextField();
        
        input.setName(name);
        
        input.setFont(new Font("Consolas", Font.PLAIN, 14));
        
        input.setHorizontalAlignment(JTextField.CENTER);
        
        input.setPreferredSize(new Dimension(70, 50));
        
        return input;
    }
    
    
    //Covierte la Matriz de Texto a Numeros
    public double[][] obtenerMatriz(){

        double[][] AUX = new double[Filas][Columnas];

        boolean error = false;

        for(int i = 0; i < Filas; i++){

            for(int j = 0; j < Columnas; j++){

                Double value = obtenerValor( Inputs[i][j].getText() );

                if(value != null){

                    AUX[i][j] = value.doubleValue();   
                }
                else{
                    error = true;
                    break;
                }
            }
            if(error) break;
        }

        if(error){
           JOptionPane.showMessageDialog(null, "Valores no admitidos", "Error al cargar", JOptionPane.ERROR_MESSAGE);
           
           return null;
        }

        return AUX;
    }
        
    //Convierte Texto a un Numero
    private static Double obtenerValor(String value){

        value = value.replaceAll(" ", "");

        Double numero = null;

        try {

            if( value.contains("/") ){//Fraccion

                String[] a = value.split("/");

                double num = Double.parseDouble( a[0] );

                double den = Double.parseDouble( a[1] );

                numero = num/den;
            } 
            else if( value.contains(",") ){//Decimal con ,

                String n = value.replace(",", ".");

                numero = Double.parseDouble(n);
            }
            else {//Entero o Decimal con .

                numero = Double.parseDouble(value);
            }        
        }
        catch (Exception e){//Cualquier otro caso: Letras

            //e.printStackTrace();

            numero = null;
        }

        return numero; 
    }
}
