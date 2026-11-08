package filosofoscomensales;

import java.util.concurrent.ThreadLocalRandom;

public class Filosofo extends Thread {

    int ciclosCompletados = 0;

    int idFilosofo;
    Mesa miMesa;
    int ciclosPorFilosofo;

    public Filosofo(int idFilosofo, Mesa miMesa, int ciclosPorFilosofo) {
        this.idFilosofo = idFilosofo;
        this.miMesa = miMesa;
        this.ciclosPorFilosofo = ciclosPorFilosofo;
    }

    @Override
    public void run() {
        try {
            System.out.println("Filosofo " + idFilosofo + ": \tPensando...");
            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1001));
            while (ciclosCompletados < ciclosPorFilosofo) {

                miMesa.comerFilosofo(idFilosofo);
                miMesa.terminarComerFilosofo(idFilosofo);
                ciclosCompletados++;

            }
            System.out.println("El filosofo " + idFilosofo + " ha terminado su ejecucion");

        }catch (InterruptedException ex) {
                System.getLogger(Filosofo.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        
    }

    
}
