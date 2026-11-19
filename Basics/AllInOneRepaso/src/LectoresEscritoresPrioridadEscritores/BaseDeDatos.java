/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LectoresEscritoresPrioridadEscritores;

/**
 *
 * @author marco
 */
class BaseDeDatos {

    int lectores = 0;
    int escritoresEsperando = 0;
    boolean escribiendo = false;

    public synchronized void entrarLeer(int numero) throws InterruptedException {
        while (escribiendo || escritoresEsperando > 0) {
            wait();
        }
        lectores++;
        System.out.println("Lector " + numero + " entra a leer. Lectores dentro: " + lectores);
    }

    public synchronized void salirLeer(int numero) {
        lectores--;
        System.out.println("Lector " + numero + " termina de leer. Lectores dentro: " + lectores);
        if (lectores == 0) {
            notifyAll();
        }
    }

    public synchronized void entrarEscribir(int numero) throws InterruptedException {
        escritoresEsperando++;
        while (escribiendo || lectores > 0) {
            wait();
        }
        escritoresEsperando--;
        escribiendo = true;
        System.out.println("Escritor " + numero + " entra a escribir");
    }

    public synchronized void salirEscribir(int numero) {
        escribiendo = false;
        System.out.println("Escritor " + numero + " termina de escribir");
        notifyAll();
    }
}
