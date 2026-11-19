/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fumadores;

/**
 *
 * @author marco
 */
class Fumador extends Thread {

    int miIngrediente;
    Mesa mesa;

    public Fumador(int miIngrediente, Mesa mesa) {
        this.miIngrediente = miIngrediente;
        this.mesa = mesa;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (!mesa.cogerIngredientes(miIngrediente)) {
                    break;
                }
                System.out.println("Fumador " + miIngrediente + " liando y fumando...");
                Thread.sleep(1000 + (int) (Math.random() * 1500));
                System.out.println("Fumador " + miIngrediente + " termina de fumar");
            }
        } catch (InterruptedException e) {
            System.out.println("Error en fumador " + miIngrediente);
        }
    }
}
