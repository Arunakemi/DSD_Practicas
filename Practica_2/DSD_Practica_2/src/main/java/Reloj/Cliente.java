/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author gioli
 */
public class Cliente {

    public static void main(String[] arg) throws IOException {
        Socket socketConnection = new Socket("127.0.0.1", 11111);
        //Lo que necesite el cliente hacer. seria hacer una ventana con la info de uno de los relojes
    }
}
