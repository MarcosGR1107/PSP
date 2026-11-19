/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package digitalizaciondedocumentos;

import java.util.concurrent.ThreadLocalRandom;

public class DigitalizacionDeDocumentos {
    // RECURSO COMPARTIDO

    int documentoProcesandoActual = 0;
    int capacidadBandeja;

    int numUsuariosProcesados = 0;
    int numUsuariosEsperados;

    int documentosDentro = 0;
    int[] bandeja = new int[3];
    boolean[] procesados = new boolean[13];

    public DigitalizacionDeDocumentos(int capacidadBandeja, int numUsuariosEsperados) {
        this.capacidadBandeja = capacidadBandeja;
        this.numUsuariosEsperados = numUsuariosEsperados;
    }

    public synchronized void depositarDocumento(int idUsuario) throws InterruptedException {
        while (documentosDentro == bandeja.length) {
            System.out.println("Usuario " + idUsuario + " espera: bandeja llena");
            wait();
        }
        bandeja[documentosDentro] = idUsuario;

        documentosDentro++;

        System.out.println("\nUsuario " + idUsuario + " deposita el documento " + idUsuario + ". Bandeja: " + documentosDentro + "/" + bandeja.length);
        notifyAll();

    }

    public synchronized void recogerDocumento() throws InterruptedException {
        while (documentosDentro == 0 && numUsuariosProcesados < numUsuariosEsperados) {
            // Aunque no haya docs, si no han pasado todos los usuarios, espera
            System.out.println("\nEscáner esperando, No hay documentos en la bandeja.");
            wait();
        }

        documentoProcesandoActual = bandeja[0];
        actualizarCola();
        documentosDentro--;
        notify(); // Notifica a los usuarios que hay un hueco libre y se pelean por el puesto 

        System.out.println("\nEscaner recoge documento " + documentoProcesandoActual + ". \t Bandeja: " + documentosDentro + "/" + bandeja.length);

    }

    public synchronized void terminarDocumento() {
        System.out.println("\nEscaner termino de digitalizar documento " + documentoProcesandoActual);
        numUsuariosProcesados++;
        procesados[documentoProcesandoActual] = true;

        System.out.println("Usuarios procesados: " + numUsuariosProcesados + "/" + numUsuariosEsperados);
        notifyAll();
    }

    public synchronized void esperarDigitalizacion(int idUsuario) {
        try {
            while (!procesados[idUsuario]) {
                wait();
            }
        } catch (InterruptedException ex) {
            System.out.println("Error esperando digitalizacion " + idUsuario + "\n:" + ex.getMessage());
        }

    }

    public synchronized boolean miDocumentoProcesado(int idUsuario) {
        return procesados[idUsuario];
    }

    public void actualizarCola() {
        for (int i = 0; i < bandeja.length - 1; i++) {
            bandeja[i] = bandeja[i + 1];

        }
        bandeja[bandeja.length - 1] = 0;

    }

    public synchronized boolean todosUsuariosProcesados() {
        if (numUsuariosProcesados < numUsuariosEsperados) {
            return true;
        }
        return false;
    }

}
