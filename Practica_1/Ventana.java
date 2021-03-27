import java.awt.Font;
import java.awt.event.*;  
import java.awt.GridLayout;
import javax.swing.*;
/* 
*   @authors
*   Colin Varela Alejandro
*/
public class Ventana extends JFrame {

    // Variables de los botos y sus iconos
    private ImageIcon icon = new ImageIcon("Imagenes/edit.png"); 
    private ImageIcon icon_plus = new ImageIcon("Imagenes/plus.png"); 
    private ImageIcon icon_minus = new ImageIcon("Imagenes/minus.png"); 
    private JLabel[] clockDisplays = { new JLabel(), new JLabel(), new JLabel(), new JLabel() };
    private JButton[] editButtons = { new JButton(icon), new JButton(icon), new JButton(icon), new JButton(icon) };
    private JButton[] fastButtons = { new JButton(icon_plus), new JButton(icon_plus), new JButton(icon_plus), new JButton(icon_plus) };
    private JButton[] slowButtons = { new JButton(icon_minus), new JButton(icon_minus), new JButton(icon_minus), new JButton(icon_minus) };
    Reloj[] clocks; // Necesitamos una referencia de los relojes para los audio listener
    
    Ventana(Reloj[] c)
    {
        clocks  = c;
        // Configuramos ventana
        setTitle("Practica 1 : Relojes");
        setLayout(new GridLayout(2,4));
        setSize(700,200);
        // Tamaño relojes
        for(int i=0;i<4;i++) 
            clockDisplays[i].setFont(new Font("Arial",Font.BOLD,35));
        // Action listener para los botones
        for(int i=0; i<4; i++) 
        {
            // Botones de edicion
            editButtons[i].setName(String.valueOf(i));
            editButtons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  
                    JButton b = (JButton) e.getSource();
                    System.out.println(b.getName());

                    // TODO : Abrir la ventana para editar la hora del reloj

                }  
            });
            // Botones de + velocidad
            fastButtons[i].setName(String.valueOf(i));
            fastButtons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  
                    JButton b = (JButton) e.getSource();
                    clocks[Integer.parseInt(b.getName())].go_Fast();
                }  
            });
            // Botones de - velocidad
            slowButtons[i].setName(String.valueOf(i));
            slowButtons[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){  
                    JButton b = (JButton) e.getSource();
                    clocks[Integer.parseInt(b.getName())].go_Slow();
                }  
            });
        }
        // Agregamos elementos
        for(int i=0; i<4; i++)
        {
            add(clockDisplays[i]);
            JPanel p = new JPanel();
            p.setLayout(new GridLayout(2,2));
            p.add(editButtons[i]);
            p.add(new JLabel());
            p.add(fastButtons[i]);
            p.add(slowButtons[i]);
            add(p);
        }
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Cerrar todo al cerrar la ventana
        setResizable(false);
        setLocationRelativeTo(null);
    }
    public void setClock(int clockID, String clockTxt)
    {
        clockDisplays[clockID].setText(clockTxt);
    }
}
