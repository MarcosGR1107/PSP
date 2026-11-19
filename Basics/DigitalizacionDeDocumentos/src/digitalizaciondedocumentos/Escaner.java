/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package digitalizaciondedocumentos;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Escaner extends Thread {

    int id;
    DigitalizacionDeDocumentos miEscaner;
    int numEjecucionesEsperado;
    int numEjecucionesRealizadas = 0;

    public Escaner(int id, DigitalizacionDeDocumentos miEscaner, int numEjecucionesEsperado) {
        this.id = id;
        this.miEscaner = miEscaner;
        this.numEjecucionesEsperado = numEjecucionesEsperado;
    }

    @Override
    public void run() {
        while (miEscaner.todosUsuariosProcesados()) {
            try {
                miEscaner.recogerDocumento();
                
                //Tiempo de espera del escáner
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 400));
                
                miEscaner.terminarDocumento();
                numEjecucionesRealizadas++;
            } catch (InterruptedException ex) {
                System.out.println("Error en la ejecución de Escáner");
            }
        }
    }

}
