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

<<<<<<< HEAD
    public static void main(String[] args) {
=======
    public static void main(String[] args) throws InterruptedException {
>>>>>>> 35b2afb906c8e4a2db577c3aae8cf333b751029f
        int capacidadTaller = 6;
        Coche[] coches = new Coche[10];
        int numeroClientesEsperado = 10;

        Taller miTaller = new Taller();
        Mecanico miMeca = new Mecanico(miTaller);
        miMeca.start();
<<<<<<< HEAD
=======
        
>>>>>>> 35b2afb906c8e4a2db577c3aae8cf333b751029f
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
