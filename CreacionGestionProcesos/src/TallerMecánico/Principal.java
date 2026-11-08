/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerMecánico;

/**
 *
 * @author 2DAM
 */
public class Principal {

    public static void main(String[] args) {
        int capacidadTaller = 6;
        Coche[] coches = new Coche[10];
        int numeroClientesEsperado = 10;

        Taller miTaller = new Taller();
        Mecanico miMeca = new Mecanico(miTaller);
        miMeca.start();
        for (int i = 0; i < numeroClientesEsperado; i++) {
            Coche coche = new Coche(i, miTaller);
            coche.start();
        }
        
        for (int i = 0; i < 10; i++){
            coches[i].join();
        }
        
        miMeca.join();
    }

}
