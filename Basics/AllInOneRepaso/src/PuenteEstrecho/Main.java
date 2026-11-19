/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuenteEstrecho;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Puente puente = new Puente();
        Vehiculo[] vehiculos = new Vehiculo[10];
        for (int i = 0; i < 10; i++) {
            int sentido = i % 2;
            vehiculos[i] = new Vehiculo(i + 1, sentido, puente);
            vehiculos[i].start();
        }
        for (int i = 0; i < 10; i++) {
            vehiculos[i].join();
        }
        System.out.println("SIMULACION FINALIZADA");
    }
}
