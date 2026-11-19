/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerCostura;

/**
 *
 * @author marco
 */
class TallerCostura {

    final int NumMaxMangas = 6;
    final int NumMaxCuerpos = 4;
    int mangas = 0;
    int cuerpos = 0;

    public synchronized void ponerManga() throws InterruptedException {
        while (mangas >= NumMaxMangas) {
            System.out.println("Cesto de mangas lleno. Costurera de mangas espera...");
            wait();
        }
        mangas++;
        System.out.println("Manga fabricada. Total mangas: " + mangas);
        notifyAll();
    }

    public synchronized void ponerCuerpo() throws InterruptedException {
        while (cuerpos >= NumMaxCuerpos) {
            System.out.println("Cesto de cuerpos lleno. Costurera de cuerpos espera...");
            wait();
        }
        cuerpos++;
        System.out.println("Cuerpo fabricado. Total cuerpos: " + cuerpos);
        notifyAll();
    }

    public synchronized void ensamblarJersey(int numero) throws InterruptedException {
        while (mangas < 2 || cuerpos < 1) {
            wait();
        }
        mangas = mangas - 2;
        cuerpos = cuerpos - 1;
        System.out.println("Jersey " + numero + " ensamblado. Quedan " + mangas + " mangas y " + cuerpos + " cuerpos");
        notifyAll();
    }
}
