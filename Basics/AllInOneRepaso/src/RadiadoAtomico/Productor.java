/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RadiadoAtomico;

/**
 *
 * @author marco
 */
class Productor extends Thread {

    BufferRadiado buffer;

    public Productor(BufferRadiado buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 6; i++) {
                Thread.sleep(300 + (int) (Math.random() * 400));
                buffer.depositar(i * 10);
            }
        } catch (InterruptedException e) {
            System.out.println("Error en productor");
        }
    }
}
