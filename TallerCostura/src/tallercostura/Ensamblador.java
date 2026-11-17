/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallercostura;

/**
 *
 * @author 2DAM
 */
public class Ensamblador extends Thread {
    String name = "Ensamblador";
    Taller miTaller;
    int numPrendas;

    public Ensamblador(Taller miTaller, int numPrendas) {
        this.miTaller = miTaller;
        this.numPrendas = numPrendas;
    }
    
    
    @Override
    public void run() {
        
    }

}
