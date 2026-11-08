/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerMecánico;

/**
 *
 * @author 2DAM
 */
public class Taller {

    boolean mecanicoDormido = true;
    int reparandoActual;
    int esperando = 0;
    int[] cochesEsperando = new int[5];

    boolean[] rechazados = new boolean[11];
    boolean[] reparados = new boolean[11];

    int cochesPasadosPorTaller;

    public synchronized boolean entraCoche(int idCoche) {
        if (mecanicoDormido) {
            mecanicoDormido = false;
            notifyAll(); // Despertar al mecánico si está dormido (disponible)
            reparandoActual = idCoche;
            System.out.println("Entra coche " + idCoche + " directamente");
            System.out.println("Reparando coche " + reparandoActual);
            return true;
        }

        if (esperando < cochesEsperando.length) {
            cochesEsperando[esperando] = idCoche;
            esperando++;
            System.out.println("Coche "+idCoche+ " aparca");
            return false;
        }
        
        rechazados[idCoche] = true;
        System.out.println("Taller lleno, abandonando " + idCoche + " por insuficiencia de plazas");

        cochesPasadosPorTaller++;
        System.out.println("Coches terminados: " + cochesPasadosPorTaller);
        return false;
    }

    public synchronized boolean esperarReparacion(int idCoche) throws InterruptedException {
        
            if (rechazados[idCoche]){
                return false;
            }
            
            while (reparandoActual != idCoche) {
                wait();
            }
            return true;
            

    }

    public synchronized boolean esperar(int numero) throws InterruptedException {
        if (rechazados[numero]) {
            return false;
        }
        while (!reparados[numero]) {
            wait();
        }

        return true;
    }

    public synchronized int cogerCoche() throws InterruptedException{
        while(mecanicoDormido && cochesPasadosPorTaller < 10){
            System.out.println("Mecanico durmiendo");
            wait();
        }
        
        return reparandoActual;
        
    }
    
    public synchronized void terminarCoche() {
        reparados[reparandoActual] = true;
        cochesPasadosPorTaller++;
        
        if(esperando > 0){
            actualizarCola();
            esperando--;
            cochesEsperando[esperando] = 0;
        }else{
            reparandoActual = 0;
            mecanicoDormido = true;
        }
        
        notifyAll();
    }
    
    public void actualizarCola() {
        for (int i = 0; i < cochesEsperando.length - 1; i++) {
            cochesEsperando[i] = cochesEsperando[i + 1];

        }
        cochesEsperando[cochesEsperando.length - 1] = 0;

    }

    public boolean todosLosCochesTerminados() {
        return true;
    }
}
