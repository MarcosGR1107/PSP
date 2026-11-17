/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CanibalesMisioneros;

/**
 *
 * @author marco
 */
class Rio {

    int esperandoM = 0;
    int esperandoC = 0;
    int plazasM = 0;
    int plazasC = 0;
    int aBordo = 0;
    boolean zarpar = false;

    private void comprobarCombinacion() {
        if (!zarpar && aBordo == 0) {
            if (esperandoM >= 3) {
                plazasM = 3;
                plazasC = 0;
                zarpar = true;
            } else if (esperandoC >= 3) {
                plazasM = 0;
                plazasC = 3;
                zarpar = true;
            } else if (esperandoM >= 1 && esperandoC >= 2) {
                plazasM = 1;
                plazasC = 2;
                zarpar = true;
            }
        }
    }

    public synchronized void LlegaMisionero(int id) throws InterruptedException {
        esperandoM++;
        System.out.println("Llega Misionero " + id + " a la orilla");
        comprobarCombinacion();
        notifyAll();
        while (!zarpar || plazasM == 0) {
            wait();
        }
        esperandoM--;
        plazasM--;
        aBordo++;
        if (aBordo == 3) {
            System.out.println("Bote lleno y seguro. Cruzando el rio...");
            aBordo = 0;
            zarpar = false;
            comprobarCombinacion();
            notifyAll();
        } else {
            while (aBordo > 0) {
                wait();
            }
        }
    }

    public synchronized void LlegaCanibal(int id) throws InterruptedException {
        esperandoC++;
        System.out.println("Llega Canibal " + id + " a la orilla");
        comprobarCombinacion();
        notifyAll();
        while (!zarpar || plazasC == 0) {
            wait();
        }
        esperandoC--;
        plazasC--;
        aBordo++;
        if (aBordo == 3) {
            System.out.println("Bote lleno y seguro. Cruzando el rio...");
            aBordo = 0;
            zarpar = false;
            comprobarCombinacion();
            notifyAll();
        } else {
            while (aBordo > 0) {
                wait();
            }
        }
    }
}
