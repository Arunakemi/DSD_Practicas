/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
*   @authors
*   Bautista Garcia hadad
*   Castañeda Beltran Geovanni
*   Colin Varela Alejandro
*   Pérez Sereno Ricardo Erick
*   Rosales Valdez Edna
 */
//Esta clase solo maneja del cliente al servidor y no al reves todo lo que pasa por aqui solo ira desde el cliente a nuestro servidor
//esta clase no sera utilzada creo
public class Manejador_Clientes implements Runnable {

    private Socket cliente;
    private BufferedReader entrada;
    private PrintWriter salida;
    private ArrayList<Manejador_Clientes> clientes;

    //la clase nos permitira mantener los hilos separados de cada cliente 
    public Manejador_Clientes(Socket s, ArrayList<Manejador_Clientes> c) throws IOException {
        this.cliente = s;
        this.clientes = c;//nos ayudara a manejar el los diferentes clientes como asignacion 
        //en caso de necesitarlos
        entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        salida = new PrintWriter(cliente.getOutputStream());
    }

    @Override
    public void run() {
        //El try va cuando se pide algo ya en el while, previene errores y es usado para cerrar la entrada de datos
        //try {
        while (true) {
            //aqui va lo que hace el cliente como los entrada.readLine() o pedidos de otras clases como Servidor.Metodo()
            //normalemnete lo que hace el server con el cliente queda aqui algo similar al codigo de abajo debe agragrase para que el loop no se cicle
            //if( "Lo que sea que queremos leer o esperar" == null )break;
        }
        //abajo son solo excepciones y cerrar variables
        //} catch (IOException ex) {
        //    ex.printStackTrace();
        //} finally {
        //    try {
        //        entrada.close();
        //    } catch (IOException ex) {
        //        ex.printStackTrace();
        //    }
        //}

    }

}
