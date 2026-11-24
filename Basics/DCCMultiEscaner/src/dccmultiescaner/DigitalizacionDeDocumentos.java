/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dccmultiescaner;

/**
 *
 * @author marco
 */

public class DigitalizacionDeDocumentos {

    // VARIABLES COMPARTIDAS
    int capacidadBandeja;
    int numUsuariosEsperados;

    int documentosDentro = 0;
    int numUsuariosProcesados = 0;

    int[] bandeja;
    boolean[] procesados;

    public DigitalizacionDeDocumentos(int capacidadBandeja, int numUsuariosEsperados) {

        this.capacidadBandeja = capacidadBandeja;
        this.numUsuariosEsperados = numUsuariosEsperados;

        bandeja = new int[capacidadBandeja];
        procesados = new boolean[numUsuariosEsperados + 1];
    }

    // DEPOSITAR DOCUMENTO
    public synchronized void depositarDocumento(int idUsuario) throws InterruptedException {

        while (documentosDentro == capacidadBandeja) {
            System.out.println("Usuario " + idUsuario + " espera: bandeja llena");
            wait();
        }

        bandeja[documentosDentro] = idUsuario;
        documentosDentro++;

        System.out.println("\nUsuario " + idUsuario +
                " deposita su documento. Bandeja: " +
                documentosDentro + "/" + capacidadBandeja);

        notifyAll();
    }

    // RECOGER DOCUMENTO
    public synchronized int recogerDocumento(int idEscaner) throws InterruptedException {

        while (documentosDentro == 0 && numUsuariosProcesados < numUsuariosEsperados) {
            System.out.println("\nEscaner esperando: no hay documentos en la bandeja.");
            wait();
        }

        // Si ya se han procesado todos, termina
        if (numUsuariosProcesados == numUsuariosEsperados) {
            return -1;
        }

        int documento = bandeja[0];

        actualizarCola();

        documentosDentro--;

        System.out.println("\nEscaner "+idEscaner+ " recoge documento " + documento +
                ". Bandeja: " + documentosDentro + "/" + capacidadBandeja);

        notifyAll();

        return documento;
    }

    // TERMINAR DIGITALIZACION
    public synchronized void terminarDocumento(int documento) {

        System.out.println("\nEscaner termina de digitalizar documento " + documento);

        procesados[documento] = true;
        numUsuariosProcesados++;

        System.out.println("Usuarios procesados: " +
                numUsuariosProcesados + "/" + numUsuariosEsperados);

        notifyAll();
    }

    // ESPERAR DIGITALIZACION
    public synchronized void esperarDigitalizacion(int idUsuario) {

        try {
            while (!procesados[idUsuario]) {
                wait();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // ACTUALIZAR COLA
    public void actualizarCola() {

        for (int i = 0; i < documentosDentro - 1; i++) {
            bandeja[i] = bandeja[i + 1];
        }

        bandeja[documentosDentro - 1] = 0;
    }
}
