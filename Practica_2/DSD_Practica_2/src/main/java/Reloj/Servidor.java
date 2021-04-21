/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reloj;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

/* 
*   @authors
*   Bautista Garcia hadad
*   Castañeda Beltran Geovanni
*   Colin Varela Alejandro
*   Pérez Sereno Ricardo Erick
*   Rosales Valdez Edna
 */
public class Servidor {

    private static ArrayList<Manejador_Clientes> clientes = new ArrayList<>();
    private static ExecutorService pool = Executors.newFixedThreadPool(3); // maximo numero de hilos

    public static void main(String[] args) throws IOException {
        // El servidor ejecutaria lo que actualmente ejecuta Practica_2.java
        // Sacamos la hora actual
        LocalTime horaActual = LocalTime.now();
        // Creamos los 4 relojes
        Reloj[] clocks = {new Reloj(horaActual.getHour(), horaActual.getMinute(), horaActual.getSecond()), // El primer
            // reloj
            // tiene el
            // horario
            // real
            new Reloj(Math.random() * 24, Math.random() * 60, Math.random() * 60), // El resto horas al azar
            new Reloj(Math.random() * 24, Math.random() * 60, Math.random() * 60),
            new Reloj(Math.random() * 24, Math.random() * 60, Math.random() * 60)};
        // Los iniciamos
        for (int i = 0; i < 4; i++) {
            clocks[i].start();
        }
        // Creamos la ventana para visualizar
        Ventana v = new Ventana(clocks); // Le mandamos la referencia de los relojes
        v.setVisible(true);

        // se asigna un puerto de conexion
        ServerSocket serverSocket = new ServerSocket(11111);
        while (true) {// ciclamos la aceptacion de nuevos clientes
            System.out.println("Esperando la conexion de clientes...");
            Socket clienteSocket = serverSocket.accept();
            System.out.println("Cliente conectado");
            //puede que las siguientes 3 lineas de codigo no sean necesarias 
            Manejador_Clientes HiloCliente = new Manejador_Clientes(clienteSocket, clientes);
            clientes.add(HiloCliente);
            pool.execute(HiloCliente);
            //salir del programa si la lista llega a tener 3 usuarios conectados
            if (clientes.get(2) != null) {
                break;
            }
        }
        //se actualizan los relojes de la aplicacion una vez que los clientes estan conectados ?
        while (true) {
            for (int i = 0; i < 4; i++) {
                v.setClock(i, "  " + clocks[i].get_Hora() + ":" + clocks[i].get_Min() + ":" + clocks[i].get_Seg());
            }
        }
    }
}
