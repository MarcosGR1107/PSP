/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Cliente extends Thread{
    int id;
    Taller miTaller;

    public Cliente(int id, Taller miTaller) {
        this.id = id;
        this.miTaller = miTaller;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextInt(0, 300));
            miTaller.llegaCliente(id);
            miTaller.retirarMovilCliente(id);
            
            System.out.println("Cliente "+ id + " se va.");
            
        } catch (InterruptedException ex) {
            System.getLogger(Cliente.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
    
}
