/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

/**
 *
 * @author 2DAM
 */
public class TallerReparacionMoviles {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int numClientes = 12;
            int capacidadEstanteria = 3;

            Taller RC = new Taller(numClientes, capacidadEstanteria);
            Tecnico miTecnico = new Tecnico(RC);
            miTecnico.start();

            Cliente[] clientes = new Cliente[numClientes];

            for (int i = 0; i < numClientes; i++) {
                clientes[i] = new Cliente(i + 1, RC);
                clientes[i].start();
            }
            
            for (int i = 0; i < numClientes; i++) {
                clientes[i].join();
            }

            miTecnico.join();
            
            System.out.println("\n=================================");
            System.out.println("TODOS LOS MOVILES SE HAN REPARADO");
            System.out.println("=================================");
            
        } catch (InterruptedException ex) {
            System.out.println("Error main");
        }
    }

}
