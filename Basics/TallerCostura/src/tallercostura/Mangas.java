/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallercostura;

/**
 *
 * @author 2DAM
 */
public class Mangas extends Thread {

    String name = "FabricaCuerpos";

    Taller miTaller;
    int numEjecuciones;

    public Mangas(Taller miTaller, int numEjecuciones) {
        this.miTaller = miTaller;
        this.numEjecuciones = numEjecuciones;
    }
    
    
    @Override
    public void run() {

    }

}
