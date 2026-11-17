/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcesosEnEquilibrio;

/**
 *
 * @author marco
 */
class Recurso {

    final int N = 6;
    int dentroA = 0;
    int dentroB = 0;

    public synchronized void entrarA(int numero) throws InterruptedException {
        while ((dentroA + dentroB >= N) || (dentroB < 2 * (dentroA + 1))) {
            System.out.println("Proceso A" + numero + " esperando (A=" + dentroA + ", B=" + dentroB + ")");
            wait();
        }
        dentroA++;
        System.out.println("Entra A" + numero + " -> Dentro: A=" + dentroA + ", B=" + dentroB);
    }

    public synchronized void salirA(int numero) {
        dentroA--;
        System.out.println("Sale A" + numero + " -> Dentro: A=" + dentroA + ", B=" + dentroB);
        notifyAll();
    }

    public synchronized void entrarB(int numero) throws InterruptedException {
        while (dentroA + dentroB >= N) {
            System.out.println("Proceso B" + numero + " esperando por cupo lleno");
            wait();
        }
        dentroB++;
        System.out.println("Entra B" + numero + " -> Dentro: A=" + dentroA + ", B=" + dentroB);
        notifyAll();
    }

    public synchronized void salirB(int numero) {
        dentroB--;
        System.out.println("Sale B" + numero + " -> Dentro: A=" + dentroA + ", B=" + dentroB);
        notifyAll();
    }
}
