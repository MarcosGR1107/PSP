/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package digitalizaciondedocumentos;

public class Main {

    public static void main(String[] args) {
        try {
            int capacidadBandeja = 3;
            int numUsuarios = 12;
            
            
            DigitalizacionDeDocumentos RC = new DigitalizacionDeDocumentos(capacidadBandeja, numUsuarios);
            Escaner miEscaner = new Escaner(1, RC, numUsuarios);
            miEscaner.start();
            
            for (int i = 1; i <= numUsuarios; i++) {
                Usuario usuario = new Usuario(i, RC);
                usuario.start();
            }

            
            miEscaner.join();
            
        } catch (Exception e) {
            System.out.println("Error main");
        }
    }
}
