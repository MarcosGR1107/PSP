/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fumadores;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Mesa mesa = new Mesa();
        Proveedor proveedor = new Proveedor(mesa);
        Fumador[] fumadores = new Fumador[3];
        for (int i = 0; i < 3; i++) {
            fumadores[i] = new Fumador(i, mesa);
            fumadores[i].start();
        }
        proveedor.start();
        proveedor.join();
        for (int i = 0; i < 3; i++) {
            fumadores[i].join();
        }
        System.out.println("SIMULACION FINALIZADA");
    }
}
