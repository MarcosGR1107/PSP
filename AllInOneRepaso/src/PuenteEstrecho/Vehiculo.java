/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PuenteEstrecho;

/**
 *
 * @author marco
 */
class Vehiculo extends Thread {

    int numero;
    int sentido;
    Puente puente;

    public Vehiculo(int numero, int sentido, Puente puente) {
        this.numero = numero;
        this.sentido = sentido;
        this.puente = puente;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 2000));
            puente.llegar_al_puente(numero, sentido);
            puente.cruzar_puente(numero, sentido);
            puente.salir_del_puente(numero, sentido);
        } catch (InterruptedException e) {
            System.out.println("Error en vehiculo " + numero);
        }
    }
}
