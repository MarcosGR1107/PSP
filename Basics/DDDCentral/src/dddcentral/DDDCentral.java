/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dddcentral;

/**
 *
 * @author marco
 */
public class DDDCentral {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {

            int capacidadBandeja = 5;
            int numUsuarios = 30;

            DigitalizacionDeDocumentos RC = new DigitalizacionDeDocumentos(capacidadBandeja, numUsuarios);

            Escaner miEscaner = new Escaner(1, RC);
            miEscaner.start();

            Usuario[] usuarios = new Usuario[numUsuarios];

            for (int i = 0; i < numUsuarios; i++) {

                usuarios[i] = new Usuario(i + 1, RC);
                usuarios[i].start();
            }

            for (int i = 0; i < numUsuarios; i++) {
                usuarios[i].join();
            }

            miEscaner.join();

            System.out.println("\n=================================");
            System.out.println("TODOS LOS USUARIOS HAN TERMINADO");
            System.out.println("=================================");

        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println("Error en el programa principal");
        }

    }

}
