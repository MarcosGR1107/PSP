/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RadiadoAtomico;

/**
 *
 * @author marco
 */
class Consumidor extends Thread {

    int id;
    BufferRadiado buffer;

    public Consumidor(int id, BufferRadiado buffer) {
        this.id = id;
        this.buffer = buffer;
    }

    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                Thread.sleep(400 + (int) (Math.random() * 1000));
                buffer.extraer(id);
            }
        } catch (InterruptedException e) {
            System.out.println("Error en consumidor " + id);
        }
    }
}
