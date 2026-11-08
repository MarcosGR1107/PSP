/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memoriacompartida;

/**
 *
 * @author 2DAM
 */
public class memoriacompartida {

    public static void main(String[] args) {
        try {
            Contador miCounter = new Contador(100);

            Sumador sum1 = new Sumador("Sumador 1", miCounter);
            Restador res1 = new Restador("Restador 1", miCounter);

            Thread hilo2 = new Thread(res1);

            sum1.start();
            hilo2.start();
            sum1.join();
            hilo2.join();

            System.out.println("Valor final: " + miCounter.valor());
//        Thread hilo2 = new Thread(res1);
//        hilo1.start();
//        hilo2.start();
        } catch (Exception e) {
            System.out.println("Error en el main:\n" + e.getMessage());
        }
    }
}
