/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemaSantaClaus;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Taller {
    int numRenosDisponibles = 9;

    int numElfosDisponibles = 20;
    int numElfosQuejandose = 0;

    public synchronized void despertarSanta() {

    }

    public synchronized void mandarRenoVacaciones(int numReno) {
        System.out.println("Mandando al reno " + numReno + " de vacaciones");
        numRenosDisponibles--;
        System.out.println("Renos disponibles: " + numRenosDisponibles);
    }

    public synchronized void llegaRenoVacaciones(int numReno) {
        numRenosDisponibles++;
        System.out.println("El reno " + numReno + " ha vuelto.");
        System.out.println("Renos disponibles: " + numRenosDisponibles + "/9");
        if (numRenosDisponibles == 9) {
            notifyAll();
        }
    }

    public synchronized void esperarRenosYElfos() {
        try {
            while (numRenosDisponibles < 9 && numElfosQuejandose != 3) {
                wait();
            }
            notify();
        } catch (Exception e) {
            System.out.println("Error en salidaConRenos:\n" + e.getMessage());
        }
    }

    public synchronized void elfoTrabajando(int numElfo) {
        try {
            System.out.println("Mandando al elfo " + numElfo + " a trabajar");
            numElfosDisponibles--;
            System.out.println("Elfos disponibles: " + numElfosDisponibles);
            if (Math.random() * 10 > 7) {

            }
            Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 20001));

        } catch (Exception e) {
            System.out.println("Error mandando a trabajar al elfo:\n" + e.getMessage());
        }

    }

    public synchronized void llegaElfo(int numElfo) {
        try {

            while (numElfosQuejandose == 3) {
                wait();
            }

            numElfosQuejandose++;

            System.out.println("El elfo " + numElfo + " ha vuelto.");
            System.out.println("Elfos quejándose: " + numElfosQuejandose);
            if (numElfosQuejandose == 3) {
                notifyAll();
            }
        } catch (Exception e) {
            System.out.println("Error esperando Elfo:\n" + e.getMessage());
        }

    }

}
