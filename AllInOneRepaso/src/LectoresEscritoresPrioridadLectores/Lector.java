/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LectoresEscritoresPrioridadLectores;

/**
 *
 * @author marco
 */
class Lector extends Thread {

    int numero;
    BaseDeDatos bd;

    public Lector(int numero, BaseDeDatos bd) {
        this.numero = numero;
        this.bd = bd;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 2000));
            bd.entrarLeer(numero);
            Thread.sleep(500 + (int) (Math.random() * 1000));
            bd.salirLeer(numero);
        } catch (InterruptedException e) {
            System.out.println("Error en lector " + numero);
        }
    }
}
