/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicasyncronyze;

/**
 *
 * @author 2DAM
 */
public class Principal {

    public static void main(String[] args) {
        try {
            Impresora impresora1 = new Impresora("", 5);

            Empleado empleado1 = new Empleado(impresora1, "Primero");

            Empleado empleado2 = new Empleado(impresora1, "Segundo");

            Empleado empleado3 = new Empleado(impresora1, "Tercero");

            Thread hilo1 = new Thread(empleado1);
            Thread hilo2 = new Thread(empleado2);
            Thread hilo3 = new Thread(empleado3);

            hilo1.start();
            hilo2.start();
            hilo3.start();

            hilo1.join();
            hilo2.join();
            hilo3.join();
            
        } catch (Exception e) {
            System.out.println("Error:\n" + e.getMessage());
        }
    }

}
