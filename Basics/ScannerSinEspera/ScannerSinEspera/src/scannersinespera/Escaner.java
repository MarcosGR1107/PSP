/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scannersinespera;

/**
 *
 * @author alejandro
 */
import java.util.Random;

public class Escaner extends Thread {

    private final CentroDigitalizacion centro;
    private final Random random = new Random();

    public Escaner(CentroDigitalizacion centro) {
        this.centro = centro;
    }

    @Override
    public void run() {
        try {
            while (true) {
                // 3. Recogida en orden FIFO o cierre si ya no hay más documentos por entrar/procesar
                int idDocumento = centro.recogerDocumento();
                if (idDocumento == -1) {
                    break;
                }

                // 4. Digitalización: entre 100 y 400 ms FUERA del monitor
                int tiempoDigitalizacion = 100 + random.nextInt(301);
                Thread.sleep(tiempoDigitalizacion);

                // Marcar como digitalizado y liberar escáner
                centro.finalizarDigitalizacion(idDocumento);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Escáner interrumpido.");
        }
    }
}
