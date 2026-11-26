/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scannersinespera;

/**
 *
 * @author alejandro
 */
public class CentroDigitalizacion {

    private static final int CAPACIDAD_BANDEJA = 3;
    private static final int TOTAL_USUARIOS = 12;

    // Bandeja circular FIFO de 3 posiciones
    private final int[] bandeja = new int[CAPACIDAD_BANDEJA];
    private int indiceEscritura = 0;
    private int indiceLectura = 0;
    private int ocupacion = 0;

    // Estado del escáner y del ciclo de vida de cada documento
    private boolean escanerOcupado = false;
    private boolean escanerTerminado = false;
    private final boolean[] digitalizado = new boolean[TOTAL_USUARIOS + 1];

    // Contadores para saber cuántos documentos entran realmente y cuántos usuarios ya no depositarán
    private int documentosDepositados = 0;
    private int usuariosFinalizadosSinDepositar = 0;

    /**
     * Intenta depositar el documento.
     * - Si hay hueco, lo deposita y devuelve true.
     * - Si la bandeja está llena y el escáner también está ocupado, no espera y devuelve false.
     * - Si la bandeja está llena pero el escáner está libre (p. ej., recién despertado o a punto de recoger),
     *   espera hasta que haya hueco o se cumpla la condición de marcha inmediata.
     */
    public synchronized boolean intentarDepositarDocumento(int idDocumento, int idUsuario) throws InterruptedException {
        while (ocupacion == CAPACIDAD_BANDEJA) {
            if (escanerOcupado) {
                usuariosFinalizadosSinDepositar++;
                System.out.println("Usuario " + idUsuario + " ve la bandeja llena (" + ocupacion + "/"
                        + CAPACIDAD_BANDEJA + ") y el escáner ocupado: se marcha con el documento "
                        + idDocumento + " sin escanear.");
                notifyAll();
                return false;
            }
            System.out.println("Usuario " + idUsuario + " espera: bandeja llena.");
            wait();
        }

        bandeja[indiceEscritura] = idDocumento;
        indiceEscritura = (indiceEscritura + 1) % CAPACIDAD_BANDEJA;
        ocupacion++;
        documentosDepositados++;

        System.out.println("Usuario " + idUsuario + " deposita el documento " + idDocumento
                + ". Bandeja: " + ocupacion + "/" + CAPACIDAD_BANDEJA);

        notifyAll();
        return true;
    }

    /**
     * Espera hasta que el documento indicado haya terminado de digitalizarse.
     */
    public synchronized void esperarDigitalizacion(int idDocumento, int idUsuario) throws InterruptedException {
        while (!digitalizado[idDocumento]) {
            wait();
        }
        System.out.println("Usuario " + idUsuario + " se marcha con su documento digitalizado.");
    }

    /**
     * Recoge el siguiente documento en orden FIFO.
     * Devuelve el ID del documento o -1 si la bandeja está vacía y ya no queda ningún usuario
     * pendiente de depositar.
     */
    public synchronized int recogerDocumento() throws InterruptedException {
        while (ocupacion == 0 && (documentosDepositados + usuariosFinalizadosSinDepositar) < TOTAL_USUARIOS) {
            wait();
        }

        if (ocupacion == 0 && (documentosDepositados + usuariosFinalizadosSinDepositar) >= TOTAL_USUARIOS) {
            escanerOcupado = false;
            escanerTerminado = true;
            notifyAll();
            return -1;
        }

        int idDocumento = bandeja[indiceLectura];
        indiceLectura = (indiceLectura + 1) % CAPACIDAD_BANDEJA;
        ocupacion--;
        escanerOcupado = true;

        System.out.println("Escáner recoge el documento " + idDocumento
                + ". Bandeja: " + ocupacion + "/" + CAPACIDAD_BANDEJA);

        notifyAll();
        return idDocumento;
    }

    /**
     * Marca el documento como digitalizado, libera el estado ocupado del escáner y notifica.
     */
    public synchronized void finalizarDigitalizacion(int idDocumento) {
        System.out.println("Escáner termina de digitalizar el documento " + idDocumento + ".");
        digitalizado[idDocumento] = true;
        escanerOcupado = false;
        notifyAll();
    }

    public synchronized boolean isEscanerTerminado() {
        return escanerTerminado;
    }

    public int getTotalUsuarios() {
        return TOTAL_USUARIOS;
    }
}