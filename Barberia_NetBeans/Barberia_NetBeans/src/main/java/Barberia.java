public class Barberia {
    private final int capacidad = 4; // 1 en corte + 3 esperando
    private int clientesDentro = 0;
    private int clientesPendientes = 0;
    private boolean barberoDormido = false;

    public synchronized void llegaCliente(int id) throws InterruptedException {
        System.out.println("Cliente " + id + " llega");

        while (clientesDentro == capacidad) {
            System.out.println("Cliente " + id + " espera fuera");
            wait();
        }

        clientesDentro++;
        clientesPendientes++;
        System.out.println("Cliente " + id + " entra (" + clientesDentro + "/4)");

        if (barberoDormido) {
            System.out.println("Cliente " + id + " despierta al barbero");
            notifyAll();
        }
 
    }

    public synchronized void esperarCliente() throws InterruptedException {
        while (clientesPendientes == 0) {
            barberoDormido = true;
            System.out.println("Barbero durmiendo...");
            wait();
        }
        barberoDormido = false;
        clientesPendientes--; // Comienza un corte.
    }

    public synchronized void terminarCorte() {
        clientesDentro--; // Se libera una plaza.
        System.out.println("Barbero termina un corte (dentro: " + clientesDentro + ")");
        notifyAll();
    }
}
