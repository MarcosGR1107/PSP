/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProcesosEnEquilibrio;

/**
 *
 * @author marco
 */
class ProcesoA extends Thread {

    int numero;
    Recurso recurso;

    public ProcesoA(int numero, Recurso recurso) {
        this.numero = numero;
        this.recurso = recurso;
    }

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1500));
            recurso.entrarA(numero);
            Thread.sleep(500 + (int) (Math.random() * 1000));
            recurso.salirA(numero);
        } catch (InterruptedException e) {
            System.out.println("Error en proceso A" + numero);
        }
    }
}
