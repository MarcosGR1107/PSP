/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerCostura;

/**
 *
 * @author marco
 */
class CostureraCuerpos extends Thread {

    TallerCostura taller;

    public CostureraCuerpos(TallerCostura taller) {
        this.taller = taller;
    }

    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(600 + (int) (Math.random() * 800));
                taller.ponerCuerpo();
            }
        } catch (InterruptedException e) {
            System.out.println("Error en costurera de cuerpos");
        }
    }
}
