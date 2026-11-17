/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemaSantaClaus;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Reno extends Thread{

    int numReno;
    Taller miTaller;
    
    public Reno(int numReno, Taller taller) {
        this.numReno = numReno;
        this.miTaller = taller;
    }

    @Override
    public void run() {
        try{            
        miTaller.mandarRenoVacaciones(numReno);
        Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2501));

        miTaller.llegaRenoVacaciones(numReno);
        }catch(Exception e){
            System.out.println("Error con el reno");
        }
    }

    
    

}
