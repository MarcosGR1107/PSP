package productorconsumidorenalmacen;

import java.util.concurrent.ThreadLocalRandom;

public class Productor extends Thread{
    int idProductor;
    Almacen miAlmacen;
    int numProductosAFabricar;
    int numProductosFabricados = 0;

    public Productor(int idProductor, Almacen miAlmacen, int numProductosAFabricar) {
        this.idProductor = idProductor;
        this.miAlmacen = miAlmacen;
        this.numProductosAFabricar = numProductosAFabricar;
    }

    @Override
    public void run() {
        while (numProductosFabricados < numProductosAFabricar){
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(200, 2001));
                
                miAlmacen.fabricarProducto(idProductor);
                numProductosFabricados++;
                System.out.println("Productor "+ idProductor + ": Fabricados \t" + numProductosFabricados + "/" + numProductosAFabricar );
                
            } catch (InterruptedException ex) {
                System.getLogger(Productor.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
        }
        System.out.println("Productor "+ idProductor + " ha terminado.");
    }
    
    
    
}
