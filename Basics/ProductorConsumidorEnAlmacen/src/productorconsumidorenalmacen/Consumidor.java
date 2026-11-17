package productorconsumidorenalmacen;

import java.util.concurrent.ThreadLocalRandom;

public class Consumidor extends Thread{
    int idConsumidor;
    Almacen miAlmacen;
    int numProductosAConsumir;
    int numProductosConsumidos;
    
    public Consumidor(int idConsumidor, Almacen miAlmacen, int numProductosAConsumir) {
        this.idConsumidor = idConsumidor;
        this.miAlmacen = miAlmacen;
        this.numProductosAConsumir = numProductosAConsumir;
    }

    @Override
    public void run() {
        while (numProductosConsumidos < numProductosAConsumir){
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(5000, 8501));
                
                miAlmacen.consumidorPideProducto(idConsumidor);
                numProductosConsumidos++;
                
                System.out.println("Consumidor "+ idConsumidor + " ha consumido " + numProductosConsumidos);
            } catch (InterruptedException ex) {
                System.getLogger(Consumidor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        
        System.out.println("Consumidor "+ idConsumidor + " ha terminado.");
    }
    
    
    
}
