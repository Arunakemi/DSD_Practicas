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

/**
 *
 * @author gioli
 */
//Esta clase solo maneja del servidor al cliente y no al reves
public class Manejador_Servidor implements Runnable {

    private Socket servidor;
    private BufferedReader entrada;
    private PrintWriter salida;

    public Manejador_Servidor(Socket s) throws IOException {
        servidor = s;
        entrada = new BufferedReader(new InputStreamReader(servidor.getInputStream()));
        salida = new PrintWriter(servidor.getOutputStream());
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
