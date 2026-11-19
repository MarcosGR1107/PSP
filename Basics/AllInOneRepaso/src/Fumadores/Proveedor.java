/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fumadores;

/**
 *
 * @author marco
 */
class Proveedor extends Thread {

    Mesa mesa;

    public Proveedor(Mesa mesa) {
        this.mesa = mesa;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 6; i++) {
                int faltante = (int) (Math.random() * 3);
                mesa.ponerIngredientes(faltante);
                Thread.sleep(200);
            }
            mesa.terminarJornada();
            System.out.println("Proveedor termina de repartir");
        } catch (InterruptedException e) {
            System.out.println("Error en proveedor");
        }
    }
}
