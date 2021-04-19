import java.awt.Font;
import java.awt.event.*;  
import java.awt.GridLayout;
import javax.swing.*;
/* 
*   @authors
*   Bautista Garcia hadad
*   Castañeda Beltran Geovanni
*   Colin Varela Alejandro
*   Pérez Sereno Ricardo Erick
*   Rosales Valdez Edna
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
    int editedClock = 0; // Cual es el reloj que esta siendo editado
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
        // Creamos la ventanaa de edicion
        JDialog editWindow = new JDialog();
        editWindow.setSize(500,200);
        editWindow.setLayout(new GridLayout(2,3));
        JTextField[] textosEditables = {new JTextField(),new JTextField()}; 
        editWindow.add(new JLabel("Horas"));
        editWindow.add(new JLabel("Minutos"));
        editWindow.add(new JLabel());
        editWindow.add(textosEditables[0]);
        editWindow.add(textosEditables[1]);
        JButton confirmar = new JButton("Confirmar");
        confirmar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                int hra = 0, min = 0;
                try
                {
                    hra = Integer.parseInt(textosEditables[0].getText()); 
                    min = Integer.parseInt(textosEditables[1].getText());
                }
                catch(Exception ex) // Manejamos la excepcion si escriben texto en la caja de edicion
                {
                    System.out.println("No se agregó un valor numerico : " + ex);
                }
                clocks[editedClock].set_Hora( (hra>=24)? 23 : ((hra<0)? 0 : hra));
                clocks[editedClock].set_Min( (min>=60)? 59 : ((min<0)? 0 : min));
                clocks[editedClock].set_Seg(0);
                clocks[editedClock].continuar();
                editWindow.setVisible(false);
                setEnabled(true);
                setVisible(true);
            }
        });
        editWindow.add(confirmar);
        editWindow.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        editWindow.setResizable(false);
        editWindow.setLocationRelativeTo(null);
        // Action listener para los botones
        ActionListener botonEdicion_AL = new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                setEnabled(false);
                JButton b = (JButton) e.getSource();
                System.out.println(b.getName());
                editedClock = Integer.parseInt(b.getName()); // Asignamos relog a editar
                clocks[editedClock].detener(); // Lo detenemos
                textosEditables[0].setText(String.valueOf(clocks[editedClock].get_Hora())); // Conseguimos sus valores
                textosEditables[1].setText(String.valueOf(clocks[editedClock].get_Min()));
                editWindow.setVisible(true); // Mostramos ventana de edicion
            }  
        };
        ActionListener bottonFast_AL = new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                JButton b = (JButton) e.getSource();
                clocks[Integer.parseInt(b.getName())].go_Fast();
            }  
        };
        ActionListener bottonSlow_AL = new ActionListener(){
            public void actionPerformed(ActionEvent e){  
                JButton b = (JButton) e.getSource();
                clocks[Integer.parseInt(b.getName())].go_Slow();
            }  
        };
        // Asignamos names y los action listener
        for(int i=0; i<4; i++) 
        {
            // Botones de edicion
            editButtons[i].setName(String.valueOf(i));
            editButtons[i].addActionListener(botonEdicion_AL);
            // Botones de + velocidad
            fastButtons[i].setName(String.valueOf(i));
            fastButtons[i].addActionListener(bottonFast_AL);
            // Botones de - velocidad
            slowButtons[i].setName(String.valueOf(i));
            slowButtons[i].addActionListener(bottonSlow_AL);
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
    public void setClock(int clockID, String clockTxt) // Funcion para modificar los textos de los relojes desde main
    {
        clockDisplays[clockID].setText(clockTxt);
    }
}