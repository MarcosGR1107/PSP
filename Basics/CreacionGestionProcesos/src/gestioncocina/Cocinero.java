/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncocina;

/**
 *
 * @author 2DAM
 */
public class Cocinero extends Thread {

    String nombre;
    Horno horno;

    public Cocinero(String nombre, Horno horno) {
        this.nombre = nombre;
        this.horno = horno;
    }

    @Override
    public void run() {
        try {
            System.out.println("Comenzando preparación " + nombre);
            Thread.sleep(1000);
            System.out.println("Termina preparación " + nombre);
        } catch (Exception e) {
            System.out.println("Error:\n" + e.getMessage());
        }

        synchronized (horno) {
            try {
                System.out.println("Comenzando horneado " + nombre);
                Thread.sleep(2000);
                System.out.println("Termina horneado " + nombre);
            } catch (Exception e) {
                System.out.println("Error:\n" + e.getMessage());
            }
        }

        try {
            System.out.println("Comenzando empaquetado " + nombre);
            Thread.sleep(1000);
            System.out.println("Termina empaquetado " + nombre);
        } catch (Exception e) {
            System.out.println("Error:\n" + e.getMessage());
        }

    }

}
