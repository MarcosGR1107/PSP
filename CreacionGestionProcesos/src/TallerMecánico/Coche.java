/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerMecánico;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Coche extends Thread{
    int id;
    Taller miTaller;

    public Coche(int id, Taller miTaller) {
        this.id = id;
        this.miTaller = miTaller;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Taller getMiTaller() {
        return miTaller;
    }

    public void setMiTaller(Taller miTaller) {
        this.miTaller = miTaller;
    }
    
    

    @Override
    public void run() {
        try{
        Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 20000));
        if (miTaller.entraCoche(id)){
            miTaller.esperarReparacion(id);
        }
        
    }catch(Exception e){
        
    }
    }
    
    
}
