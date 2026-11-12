/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemaSantaClaus;

/**
 *
 * @author 2DAM
 */
public class Elfo extends Thread {
    int numElfo;
    Taller miTaller;

    @Override
    public void run() {
        miTaller.llegaElfo(numElfo);
    }

    
}
