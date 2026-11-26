/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

/**
 *
 * @author 2DAM
 */
public class Taller {

    int clienteProcesandoActual = 0;
    int movilesEnEspera = 0;

    int numClientesEsperados;

    int numClientesReparados = 0;

    int capacidadEstanteria;
    int[] estanteria;
    boolean[] procesados;

    boolean[] retirados;

    public Taller(int numClientesEsperados, int capacidadEstanteria) {
        this.numClientesEsperados = numClientesEsperados;
        this.capacidadEstanteria = capacidadEstanteria;

        procesados = new boolean[numClientesEsperados + 1];
        estanteria = new int[capacidadEstanteria];
        retirados = new boolean[numClientesEsperados + 1];
    }

    public synchronized void llegaCliente(int idCliente) throws InterruptedException {
        while (movilesEnEspera == capacidadEstanteria) {
            System.out.println("Cliente " + idCliente + " espera: estanteria llena");
            wait();
        }

        estanteria[movilesEnEspera] = idCliente;
        movilesEnEspera++;
        System.out.println("\nCliente " + idCliente + " deposita su movil \t" + movilesEnEspera + "/" + capacidadEstanteria);
        notifyAll();
    }

    public synchronized void tecnicoEmpiezaTrabajar() throws InterruptedException {
        while (movilesEnEspera < capacidadEstanteria) {
            System.out.println("Tecnico esperando: No hay tres moviles: " + movilesEnEspera + " en espera.");
            wait();
        }
        
        notifyAll();
    }

    public synchronized void recogerMovil() throws InterruptedException {
        while (movilesEnEspera == 0 && numClientesReparados < numClientesEsperados) {
            System.out.println("\nTecnico esperando, no hay moviles en la estanteria");
            wait();
        }
        
        clienteProcesandoActual = estanteria[0];
        actualizarCola();
        movilesEnEspera--;
        notifyAll();
        System.out.println("\nTecnico reparando movil " + clienteProcesandoActual);
    }
    
    public synchronized void repararMovil(){
        System.out.println("\nTecnico ha terminado el movil "+ clienteProcesandoActual);
        numClientesReparados++;
        procesados[clienteProcesandoActual] = true;
        
        System.out.println("Usuarios procesados: "+ numClientesReparados+"/" +numClientesEsperados);
        notifyAll();
    }

    public synchronized void esperarRetiradaTecnico() throws InterruptedException {
        
        while (!retirados[clienteProcesandoActual]) {
            System.out.println("\nTecnico esperando a que se retire el movil " + clienteProcesandoActual);
            wait();
        }
        
    }

    public synchronized void esperarReparacion(int idCliente) {
        try {
            while (!procesados[idCliente]) {
                System.out.println("Movil "+ idCliente + " esperando reparacion");
                wait();
            }
            System.out.println("Movil "+ idCliente + " reparado.");
            notifyAll();
        } catch (InterruptedException e) {
            System.out.println("Error eseprando reparacion " + e.getMessage());
        }
    }

    public synchronized boolean movilReparado(int idCliente) {
        return procesados[idCliente];
    }

    public synchronized void retirarMovilCliente(int idCliente) throws InterruptedException {
        
        while (!movilReparado(idCliente)) {
            wait();
        }

        retirados[idCliente] = true;
        System.out.println("Cliente " + idCliente + " retira el movil.");
        System.out.println("Moviles retirados "+ numClientesReparados+"/"+numClientesEsperados+"\n");
        notifyAll(); // avisa a tecnico que siga
    }

    public synchronized boolean todosClientesProcesados() {
        return numClientesReparados == numClientesEsperados && estanteria[0] == 0;
    }

    public void actualizarCola() {

        for (int i = 0; i < movilesEnEspera - 1; i++) {
            estanteria[i] = estanteria[i + 1];
        }

        estanteria[movilesEnEspera - 1] = 0;
    }
}
