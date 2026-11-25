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

public class Usuario extends Thread {

    int id;
    DigitalizacionDeDocumentos escaner;

    public Usuario(int id, DigitalizacionDeDocumentos escaner) {
        this.id = id;
        this.escaner = escaner;
    }

    @Override
    public void run() {

        try {

            // Tiempo de llegada del usuario
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 301));

            escaner.depositarDocumento(id);

            escaner.esperarDigitalizacion(id);

            System.out.println("Usuario " + id + " se va");

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Error en la ejecucion del usuario " + id);
        }
    }
}

