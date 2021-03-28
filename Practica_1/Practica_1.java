import java.time.LocalTime;
/* 
*   @authors
*   Bautista Garcia hadad
*   Castañeda Beltran Geovanni
*   Colin Varela Alejandro
*   Pérez Sereno Ricardo Erick
*   Rosales Valdez Edna
*/
class Practica_1 
{
    public static void main(String[] args) {
        
        // Sacamos la hora actual
        LocalTime horaActual = LocalTime.now(); 

        // Creamos los 4 relojes
        Reloj[] clocks = {
            new Reloj( horaActual.getHour(), horaActual.getMinute(), horaActual.getSecond()), //El primer reloj tiene el horario real
            new Reloj( Math.random() * 24,   Math.random() * 60,     Math.random() * 60    ), //El resto horas al azar
            new Reloj( Math.random() * 24,   Math.random() * 60,     Math.random() * 60    ),
            new Reloj( Math.random() * 24,   Math.random() * 60,     Math.random() * 60    )
        };

        // Los iniciamos
        for(int i=0;i<4;i++) 
            clocks[i].start();

        // Creamos la ventana para visualizar
        Ventana v = new Ventana(clocks); // Le mandamos la referencia de los relojes
        v.setVisible(true);

        // Seguiremos actualizando la hora hasta que se termine la aplicacion
        while(true)
        {
            for(int i=0;i<4;i++)
                v.setClock( i , "  " + clocks[i].get_Hora() + ":" + clocks[i].get_Min() + ":" + clocks[i].get_Seg());
        }

    }
}