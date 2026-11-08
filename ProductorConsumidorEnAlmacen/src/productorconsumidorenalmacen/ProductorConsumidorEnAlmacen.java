package productorconsumidorenalmacen;

public class ProductorConsumidorEnAlmacen {

    public static void main(String[] args) throws InterruptedException {
        int capacidadAlmacen = 5;
        int numProductosAProducirEntreTodos = 8;
        int numProductosPorProductor = 4;
        int numProductosPorConsumidor = 4;

        Productor[] productores = new Productor[2];
        Consumidor[] consumidores = new Consumidor[2];

        Almacen nuevoAlmacen = new Almacen(capacidadAlmacen, numProductosAProducirEntreTodos);

        for (int i = 1; i <= productores.length; i++) {
            Productor productor = new Productor(i, nuevoAlmacen, numProductosPorProductor);
            productor.start();
        }

        for (int i = 1; i <= consumidores.length; i++) {
            Consumidor consumidor = new Consumidor(i, nuevoAlmacen, numProductosPorConsumidor);
            consumidor.start();
        }

        
        /*
        Si se hace sin JOINS funciona bien pero después no
        
        A la que se ponen los join, mete excepcion de primeras pero funcionar funciona y termina, aun con excepciones al inicio y fin
        
        for (int i = 0; i < consumidores.length; i++) {
            consumidores[i].join();
        }

        for (int i = 0; i < productores.length; i++) {
            productores[i].join();
        }

*/
        
        System.out.println("El programa ha terminado");


    }

}
