/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemaSantaClaus;

/**
 *
 * @author 2DAM
 */
public class SantaClaus extends Thread {

    Taller miTaller;

    public SantaClaus(Taller miTaller) {
        this.miTaller = miTaller;
    }

    @Override
    public void run() {
        try {
            miTaller.esperarRenosYElfos();
        } catch (Exception e) {
            interrupt();
        }
    }

}
