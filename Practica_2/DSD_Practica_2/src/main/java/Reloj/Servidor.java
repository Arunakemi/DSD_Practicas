/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author gioli
 */
public class Servidor {

    private static ArrayList<Manejador_Clientes> clientes = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(3); //maximo numero de hilos

    public static void main(String[] args) throws IOException {
        //El servidor ejecutaria lo que actualmente ejecuta Practica_2.java
        ServerSocket serverSocket = new ServerSocket(11111);//se asigna un puerto de conexion
        while (true) {//ciclamos la aceptacion de nuevos clientes    
            System.out.println("Esperando la conexion de clientes...");
            Socket clienteSocket = serverSocket.accept();
            System.out.println("Cliente conectado");
            Manejador_Clientes HiloCliente = new Manejador_Clientes(clienteSocket, clientes);
            clientes.add(HiloCliente);
            pool.execute(HiloCliente);
        }
    }
}
