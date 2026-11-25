/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dccmultiescaner;

/**
 *
 * @author marco
 */
public class DCCMultiEscaner {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int capacidadBandeja = 3;
        int numUsuarios = 18;
        int numEscaneres = 2;

        DigitalizacionDeDocumentos RC = new DigitalizacionDeDocumentos(capacidadBandeja, numUsuarios);

        // Crear escaneres
        Escaner[] escaneres = new Escaner[numEscaneres];

        for (int i = 0; i < numEscaneres; i++) {

            escaneres[i] = new Escaner(i + 1, RC);
            escaneres[i].start();
        }

        // Crear usuarios
        Usuario[] usuarios = new Usuario[numUsuarios];

        for (int i = 0; i < numUsuarios; i++) {

            usuarios[i] = new Usuario(i + 1, RC);
            usuarios[i].start();
        }

        // =================================
        // ESPERAR FINALIZACION
        // =================================
        try {

            // Esperar a todos los usuarios
            for (int i = 0; i < numUsuarios; i++) {
                usuarios[i].join();
            }

            // Esperar a todos los escaneres
            for (int i = 0; i < numEscaneres; i++) {
                escaneres[i].join();
            }

            System.out.println("\n=================================");
            System.out.println("TODOS LOS USUARIOS HAN TERMINADO");
            System.out.println("TODOS LOS ESCANERES HAN TERMINADO");
            System.out.println("=================================");

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Error en el programa principal");
        }
    }

}
