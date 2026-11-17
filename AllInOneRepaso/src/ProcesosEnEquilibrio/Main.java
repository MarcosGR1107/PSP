/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcesosEnEquilibrio;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Recurso recurso = new Recurso();
        ProcesoA[] procesosA = new ProcesoA[3];
        ProcesoB[] procesosB = new ProcesoB[6];
        for (int i = 0; i < 6; i++) {
            procesosB[i] = new ProcesoB(i + 1, recurso);
            procesosB[i].start();
        }for (int i = 0; i < 3; i++) {
            procesosA[i] = new ProcesoA(i + 1, recurso);
            procesosA[i].start();
        }
        for (int i = 0; i < 6; i++) {
            procesosB[i].join();
        }
        for (int i = 0; i < 3; i++) {
            procesosA[i].join();
        }
        System.out.println("SIMULACION FINALIZADA");
    }
}
