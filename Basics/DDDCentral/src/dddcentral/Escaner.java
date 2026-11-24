/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dddcentral;

/**
 *
 * @author marco
 */

import java.util.concurrent.ThreadLocalRandom;

public class Escaner extends Thread {

    int id;
    DigitalizacionDeDocumentos miEscaner;

    public Escaner(int id, DigitalizacionDeDocumentos miEscaner) {
        this.id = id;
        this.miEscaner = miEscaner;
    }

    @Override
    public void run() {

        try {

            while (miEscaner.recogerDocumento()) {

                // Tiempo de digitalizacion
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 400));

                miEscaner.terminarDocumento();
            }

            System.out.println("\nEscaner finalizado.");

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Error en la ejecucion del escaner");
        }
    }
}

