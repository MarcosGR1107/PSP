package filosofoscomensales;

import java.util.concurrent.ThreadLocalRandom;

public class Mesa {

    boolean[] numTenedores;

//    int[] sillasFilosofos;
    public Mesa(int numFilosofos) {
        this.numTenedores = new boolean[numFilosofos];
//        this.sillasFilosofos = new int[numFilosofos];
    }

    // FALSE = tenedor libre
    public synchronized void comerFilosofo(int idFilosofo) throws InterruptedException {
        int izquierdo = idFilosofo - 1;
        int derecho = idFilosofo % numTenedores.length;

        /*
        if (idFilosofo == 1) {
            while (numTenedores[numTenedores.length - 1] || numTenedores[0]) {
                System.out.println("El F1 no puede comer ");
                wait();
            }
        } else if (idFilosofo == numTenedores.length) {
            while (numTenedores[numTenedores.length - 1] || numTenedores[idFilosofo - 1]) {
                System.out.println("El ultimo no puede comer");
                wait();
            }
        } else {
            while (numTenedores[idFilosofo - 1] || numTenedores[idFilosofo]) {
                System.out.println("Filosofo " + idFilosofo + " no puede comer");
                wait();
            }
         */
        while (numTenedores[izquierdo] || numTenedores[derecho]) {
            System.out.println("\nFilosofo " + idFilosofo + ":\t Esperando...");
            wait();
        }

        numTenedores[izquierdo] = true;
        numTenedores[derecho] = true;
        System.out.println("\nFilosofo " + idFilosofo + ":\t Comiendo");
        Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5001));
    }

    public synchronized void terminarComerFilosofo(int idFilosofo) {
        int izquierdo = idFilosofo - 1;
        int derecho = idFilosofo % numTenedores.length;
        System.out.println("Filosofo " + idFilosofo + ": \tHa terminado de comer ");

        numTenedores[izquierdo] = false;
        numTenedores[derecho] = false;
        notify();
    }
}
