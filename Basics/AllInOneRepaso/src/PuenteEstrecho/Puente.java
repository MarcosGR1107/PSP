/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuenteEstrecho;

/**
 *
 * @author marco
 */
class Puente {

    int dentro = 0;
    int sentidoActual = -1;
    int[] esperando = new int[2];
    int seguidos = 0;

    public synchronized void llegar_al_puente(int numero, int sentido) throws InterruptedException {
        int otroSentido = 1 - sentido;
        esperando[sentido]++;
        while (dentro == 3 || (dentro > 0 && sentidoActual != sentido) || (esperando[otroSentido] > 0 && seguidos >= 3)) {
            wait();
        }
        esperando[sentido]--;
        if (dentro == 0) {
            sentidoActual = sentido;
            seguidos = 0;
        }
        dentro++;
        seguidos++;
        System.out.println("Vehiculo " + numero + " entra al puente en sentido " + sentido + " (Dentro: " + dentro + ")");
    }

    public void cruzar_puente(int numero, int sentido) throws InterruptedException {
        System.out.println("Vehiculo " + numero + " cruzando en sentido " + sentido + "...");
        Thread.sleep(500 + (int) (Math.random() * 1000));
    }

    public synchronized void salir_del_puente(int numero, int sentido) {
        dentro--;
        System.out.println("Vehiculo " + numero + " sale del puente (Dentro: " + dentro + ")");
        if (dentro == 0) {
            int otroSentido = 1 - sentido;
            if (esperando[otroSentido] > 0) {
                sentidoActual = otroSentido;
            } else {
                sentidoActual = -1;
            }
            seguidos = 0;
        }
        notifyAll();
    }
}
