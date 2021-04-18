/* 
*   @authors
*   Bautista Garcia hadad
*   Castañeda Beltran Geovanni
*   Colin Varela Alejandro
*   Pérez Sereno Ricardo Erick
*   Rosales Valdez Edna
*/
public class Reloj extends Thread // Hilo de los relojes
{
    double hora,min,seg;
    int time;
    Boolean detenido;
    public Reloj(double _hora, double _min, double _seg) // Inicializamos el reloj en su valor
    { 
        hora = _hora; 
        min = _min; 
        seg = _seg; 
        time = 1000; 
        detenido = false;
    } 
    @Override
    public void run() 
    {
        while(true) // El reloj continuara hasta ser detenido
        {
            // Avanzamos el tiempo
            if(!detenido) seg++; // Solo avanza si no esta detenido el reloj
            if(seg>=60) { min++; seg = 0; }
            if(min>=60) { hora++; min = 0; }
            if(hora>=24){ hora = 0; }
            // Dormimos 'time' asi podemos acelerar o realentizar el reloj
            try
            {
                java.lang.Thread.sleep(time);
            }
            catch(InterruptedException e)
            { 
                System.out.println("Un reloj fue interrumpido! : " + e);
            }
        }
    }
    public void go_Slow() { time += 100; } // Hace que el reloj avance 1 segundo cada 2...3...4 etc 
    public void go_Fast() { time = (time-100 <= 0)? 100 : time-100; } // No queremos que el reloj vaya 'infinito' rapido but gottagofast 
    public void detener() { detenido = true; }
    public void continuar() { detenido = false; }
    // Bloque set
    public void set_Hora(double newHora){ hora = newHora; } 
    public void set_Min (double newMin ){ min = newMin;   } 
    public void set_Seg (double newSeg ){ seg = newSeg;   } 
    // Bloque get
    public int get_Hora(){ return (int) hora; } 
    public int get_Min (){ return (int) min;  } 
    public int get_Seg (){ return (int) seg;  } 
}