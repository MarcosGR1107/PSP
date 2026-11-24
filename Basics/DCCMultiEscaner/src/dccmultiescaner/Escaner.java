/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dccmultiescaner;

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

            int documento;

            while ((documento = miEscaner.recogerDocumento(id)) != -1) {

                System.out.println("Escaner " + id +
                        " esta digitalizando documento " + documento);

                // Tiempo de digitalizacion
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 400));

                System.out.println("Escaner " + id +
                        " termina documento " + documento);

                miEscaner.terminarDocumento(documento);
            }

            System.out.println("Escaner " + id + " finalizado.");

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Error en la ejecucion del escaner " + id);
        }
    }
}


