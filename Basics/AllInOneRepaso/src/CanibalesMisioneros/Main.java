/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CanibalesMisioneros;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Rio rio = new Rio();
        Misionero[] misioneros = new Misionero[3];
        Canibal[] canibales = new Canibal[6];
        for (int i = 0; i < 3; i++) {
            misioneros[i] = new Misionero(i + 1, rio);
            misioneros[i].start();
        }
        for (int i = 0; i < 6; i++) {
            canibales[i] = new Canibal(i + 1, rio);
            canibales[i].start();
        }
        for (int i = 0; i < 3; i++) {
            misioneros[i].join();
        }
        for (int i = 0; i < 6; i++) {
            canibales[i].join();
        }
        System.out.println("SIMULACION FINALIZADA");
    }
}
