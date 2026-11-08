package productorconsumidorenalmacen;

public class Almacen {
    
    int numProductosProducidos = 0;
    int numProductosAProducir;
    int numProductosEnAlmacen = 0;
    
    int[] colaProductos;

    public Almacen(int colaProductos, int numProductosAProducir) {
        this.colaProductos = new int[colaProductos];
        this.numProductosAProducir = numProductosAProducir;
    }
    
    public synchronized void consumidorPideProducto(int idConsumidor) throws InterruptedException{
        while (numProductosEnAlmacen == 0){
            System.out.println("\nConsumidor "+idConsumidor+ ": Almacen vacio, esperando.");
            wait();
        }
        
        numProductosEnAlmacen--;
        
        System.out.println("\nConsumidor "+ idConsumidor + " retira producto "+colaProductos[0]);
        System.out.println("Productos restantes: "+numProductosEnAlmacen);
        
        actualizarOrdenCola();
        
        notifyAll();
    }
    
    public synchronized void fabricarProducto(int idProductor) throws InterruptedException{
        while (numProductosEnAlmacen == colaProductos.length){
            System.out.println("\nProductor "+ idProductor+": Almacen lleno, esperando");
            wait();
        }
        
        numProductosProducidos++;
        colaProductos[numProductosEnAlmacen] = numProductosProducidos;
        numProductosEnAlmacen++;
        System.out.println("\nEl productor " + idProductor + " fabrica producto ");
        System.out.println("Productos almacenados: \t"+ numProductosEnAlmacen);
        
        System.out.println("Total de productos producidos: \t"+ numProductosProducidos +"/"+numProductosAProducir);
        notifyAll();
    }
    
    public void actualizarOrdenCola(){
        for (int i = 0; i < colaProductos.length - 1; i++){
            colaProductos[i] = colaProductos[i+1];
        }
    }
}
