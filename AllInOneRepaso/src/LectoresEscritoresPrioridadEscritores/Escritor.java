/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LectoresEscritoresPrioridadEscritores;

/**
 *
 * @author marco
 */
class Escritor extends Thread {

    int numero;
    BaseDeDatos bd;

    public Escritor(int numero, BaseDeDatos bd) {
        this.numero = numero;
        this.bd = bd;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 2000));
            bd.entrarEscribir(numero);
            Thread.sleep(1000 + (int) (Math.random() * 1000));
            bd.salirEscribir(numero);
        } catch (InterruptedException e) {
            System.out.println("Error en escritor " + numero);
        }
    }
}
