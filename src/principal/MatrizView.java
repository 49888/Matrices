
package principal;

import Extra.Fraccion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;




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
    public static JComponent inputMatriz(int filas, int columnas, JTextComponent Inputs[][]){
        
     //Layout   
        GridLayout layout = new GridLayout(filas, columnas);
        
        layout.setHgap(10);  layout.setVgap(10);
          
     //Papel   
        JPanel panel = new JPanel(layout);
        
        for(int i = 0; i < filas; i++){
            
            for(int j = 0; j < columnas; j++){
                
                String name = Integer.toString(i+1) + Integer.toString(j+1);
                
                JTextComponent input = inputItem(name);
                
                Inputs[i][j] = input;
                
                panel.add( input );
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
    
    //Covierte la Matriz de Texto a Numeros
    public static double[][] obtenerMatriz(JTextComponent matriz[][]){

        double[][] AUX = new double[matriz.length][matriz[0].length];

        boolean error = false;

        for(int i = 0; i < matriz.length; i++){

            for(int j = 0; j < matriz[i].length; j++){

                Double value = obtenerValor( matriz[i][j].getText() );

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
    
    
    
    //Covierte la Matriz de Numeros a Texto
    public static String[][] obtenerMatriz(double matriz[][]){
        
        String[][] AUX = new String[matriz.length][matriz[0].length];
        
        for(int i = 0; i < matriz.length; i++){
            
            for(int j = 0; j < matriz[i].length; j++){
                
                double N = matriz[i][j];
                
                if( N - (long)N != 0 ){
                    
                    Fraccion F = Fraccion.convFraccion(N);
                    
                    AUX[i][j] = F.toString();
                }
                else{
                    AUX[i][j] = Long.toString( (long)N );
                }
            }    
        }
        
        return AUX;
    }
    
 //Fin de Clase MatrizView
}
