/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tallercostura;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Taller {

    int capacidadCestaMangas;
    int capacidadCestaCuerpos;

    int[] cestaMangas = new int[capacidadCestaMangas];
    int[] cestaCuerpos = new int[capacidadCestaCuerpos];

    int numMangasFabricadas = 0;
    int numMangasEnCesta = 0;

    int numCuerposFabricadas = 0;
    int numCuerposEnCesta = 0;

    int numPrendasFabricadas = 0;

    public Taller(int capacidadCestaMangas, int capacidadCestaCuerpos) {
        this.capacidadCestaMangas = capacidadCestaMangas;
        this.capacidadCestaCuerpos = capacidadCestaCuerpos;
    }

    private synchronized void fabricarManga() throws InterruptedException {
        while (numMangasEnCesta == cestaMangas.length) {
            System.out.println("Cesta mangas llena, esperando...");
            wait();
        }
        Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 5001));
        
        numMangasFabricadas++;
        numMangasEnCesta++;
        
        
        notifyAll();
    }

    private synchronized void fabricarCuerpo() throws InterruptedException {
        while (numCuerposEnCesta == cestaCuerpos.length) {
            System.out.println("Cesta cuerpos llena, esperando...");
            wait();
        }
        Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 8001));

        notifyAll();
    }

    private synchronized void fabricarPrenda() throws InterruptedException {
        while (numMangasEnCesta < 2 || numCuerposEnCesta < 1) {
            System.out.println("No hay componentes, esperando...");
            wait();
        }
        Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 6001));

        notifyAll();

    }
    
    private void actualizarCola(Array< arrayAux){
        for(int i = 0; i < arrayAux.length - 1; i++){
            
        }
    }
    

}
