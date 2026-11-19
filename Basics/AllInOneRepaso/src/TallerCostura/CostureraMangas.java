/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerCostura;

/**
 *
 * @author marco
 */
class CostureraMangas extends Thread {

    TallerCostura taller;

    public CostureraMangas(TallerCostura taller) {
        this.taller = taller;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(300 + (int) (Math.random() * 500));
                taller.ponerManga();
            }
        } catch (InterruptedException e) {
            System.out.println("Error en costurera de mangas");
        }
    }
}
