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

public class Usuario extends Thread {

    private final int idUsuario;
    private final int idDocumento;
    private final CentroDigitalizacion centro;
    private final Random random = new Random();

    public Usuario(int idUsuario, int idDocumento, CentroDigitalizacion centro) {
        this.idUsuario = idUsuario;
        this.idDocumento = idDocumento;
        this.centro = centro;
    }

    @Override
    public void run() {
        try {
            // 1. Llegada: espera entre 0 y 300 ms fuera del monitor
            int tiempoLlegada = random.nextInt(301);
            Thread.sleep(tiempoLlegada);

            // 2. Intenta depositar: si bandeja llena y escáner ocupado, se marcha sin escanear
            boolean depositado = centro.intentarDepositarDocumento(idDocumento, idUsuario);
            if (!depositado) {
                return;
            }

            // 5. Entrega: si logró depositar, espera a que su documento esté digitalizado
            centro.esperarDigitalizacion(idDocumento, idUsuario);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Usuario " + idUsuario + " interrumpido.");
        }
    }
}
