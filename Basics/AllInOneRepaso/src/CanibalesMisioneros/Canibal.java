/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CanibalesMisioneros;

/**
 *
 * @author marco
 */
class Canibal extends Thread {

    int id;
    Rio rio;

    public Canibal(int id, Rio rio) {
        this.id = id;
        this.rio = rio;
    }

    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1500));
            rio.LlegaCanibal(id);
            System.out.println("Canibal " + id + " ha cruzado el rio");
        } catch (InterruptedException e) {
            System.out.println("Error en canibal " + id);
        }
    }
}
