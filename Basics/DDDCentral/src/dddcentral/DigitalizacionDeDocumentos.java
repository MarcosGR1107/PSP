/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dddcentral;

/**
 *
 * @author marco
 */

public class DigitalizacionDeDocumentos {

    int documentoProcesandoActual = 0;

    int capacidadBandeja;
    int numUsuariosEsperados;

    int numUsuariosProcesados = 0;
    int documentosDentro = 0;

    int[] bandeja;
    boolean[] procesados;

    public DigitalizacionDeDocumentos(int capacidadBandeja, int numUsuariosEsperados) {

        this.capacidadBandeja = capacidadBandeja;
        this.numUsuariosEsperados = numUsuariosEsperados;

        bandeja = new int[capacidadBandeja];
        procesados = new boolean[numUsuariosEsperados + 1];
    }

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

    public synchronized boolean recogerDocumento() throws InterruptedException {

        while (documentosDentro == 0 && numUsuariosProcesados < numUsuariosEsperados) {
            System.out.println("\nEscaner esperando: no hay documentos en la bandeja.");
            wait();
        }

        // Si ya se han procesado todos, termina el escáner
        if (numUsuariosProcesados == numUsuariosEsperados) {
            return false;
        }

        documentoProcesandoActual = bandeja[0];

        actualizarCola();
        documentosDentro--;

        System.out.println("\nEscaner recoge documento " +
                documentoProcesandoActual + ". Bandeja: " +
                documentosDentro + "/" + capacidadBandeja);

        notifyAll();

        return true;
    }

    public synchronized void terminarDocumento() {

        System.out.println("\nEscaner termino de digitalizar documento " +
                documentoProcesandoActual);

        procesados[documentoProcesandoActual] = true;
        numUsuariosProcesados++;

        System.out.println("Usuarios procesados: " +
                numUsuariosProcesados + "/" + numUsuariosEsperados);

        notifyAll();
    }

    public synchronized void esperarDigitalizacion(int idUsuario) {

        try {
            while (!procesados[idUsuario]) {
                wait();
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public void actualizarCola() {

        for (int i = 0; i < documentosDentro - 1; i++) {
            bandeja[i] = bandeja[i + 1];
        }

        bandeja[documentosDentro - 1] = 0;
    }

    public synchronized boolean todosUsuariosProcesados() {
        return numUsuariosProcesados < numUsuariosEsperados;
    }
}
