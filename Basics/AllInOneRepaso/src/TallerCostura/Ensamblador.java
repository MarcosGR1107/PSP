/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerCostura;

/**
 *
 * @author marco
 */
class Ensamblador extends Thread {

    TallerCostura taller;

    public Ensamblador(TallerCostura taller) {
        this.taller = taller;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                taller.ensamblarJersey(i);
                Thread.sleep(500 + (int) (Math.random() * 500));
            }
        } catch (InterruptedException e) {
            System.out.println("Error en ensamblador");
        }
    }
}
