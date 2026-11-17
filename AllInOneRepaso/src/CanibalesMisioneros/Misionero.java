/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CanibalesMisioneros;

/**
 *
 * @author marco
 */
class Misionero extends Thread {

    int id;
    Rio rio;

    public Misionero(int id, Rio rio) {
        this.id = id;
        this.rio = rio;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 1500));
            rio.LlegaMisionero(id);
            System.out.println("Misionero " + id + " ha cruzado el rio");
        } catch (InterruptedException e) {
            System.out.println("Error en misionero " + id);
        }
    }
}
