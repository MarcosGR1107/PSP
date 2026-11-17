/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemaBarberoDormilon;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Cliente extends Thread {

    String nombre;
    Barberia miBarberia;

    public Cliente(String nombre, Barberia miBarberia) {
        this.nombre = nombre;
        this.miBarberia = miBarberia;
    }

    @Override
    public void run() {
        try{
        Thread.sleep(ThreadLocalRandom.current().nextInt(2500, 5501));
        miBarberia.llegaCliente(nombre);
        
        }catch(Exception e){
            System.out.println("Error en en RUN cliente "+ nombre);
        }
    }

}
