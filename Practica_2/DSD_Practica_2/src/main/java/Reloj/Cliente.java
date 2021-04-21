/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import java.io.IOException;
import java.net.Socket;

/* 
*   @authors
*   Bautista Garcia hadad
*   Castañeda Beltran Geovanni
*   Colin Varela Alejandro
*   Pérez Sereno Ricardo Erick
*   Rosales Valdez Edna
 */
public class Cliente {

    public static void main(String[] arg) throws IOException {
        Socket socketConnection = new Socket("127.0.0.1", 11111);
        System.out.println("conectado");
        Manejador_Servidor servercon= new Manejador_Servidor(socketConnection);
        new Thread(servercon).start();
        //Lo que necesite el cliente hacer. seria hacer una ventana con la info de uno de los relojes
        
        while(true){
            //pedir la hora desde el server
            //v.setClock(i, "  " + clocks[i].get_Hora() + ":" + clocks[i].get_Min() + ":" + clocks[i].get_Seg());
        } 
    }
}
