/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RadiadoAtomico;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        BufferRadiado buffer = new BufferRadiado();
        Productor productor = new Productor(buffer);
        Consumidor[] consumidores = new Consumidor[3];
        productor.start();
        for (int i = 0; i < 3; i++) {
            consumidores[i] = new Consumidor(i, buffer);
            consumidores[i].start();
        }
        productor.join();
        for (int i = 0; i < 3; i++) {
            consumidores[i].join();
        }
        System.out.println("SIMULACION FINALIZADA");
    }
}
