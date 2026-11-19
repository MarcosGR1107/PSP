/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerCostura;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TallerCostura taller = new TallerCostura();
        CostureraMangas cMangas = new CostureraMangas(taller);
        CostureraCuerpos cCuerpos = new CostureraCuerpos(taller);
        Ensamblador ensamblador = new Ensamblador(taller);
        cMangas.start();
        cCuerpos.start();
        ensamblador.start();
        cMangas.join();
        cCuerpos.join();
        ensamblador.join();
        System.out.println("SIMULACION FINALIZADA");
    }
}
