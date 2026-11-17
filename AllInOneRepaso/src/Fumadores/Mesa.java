/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fumadores;

/**
 *
 * @author marco
 */
class Mesa {

    int ingredienteFaltante = -1;
    boolean mesaOcupada = false;
    boolean fin = false;

    public synchronized void ponerIngredientes(int faltante) throws InterruptedException {
        while (mesaOcupada) {
            wait();
        }
        ingredienteFaltante = faltante;
        mesaOcupada = true;
        if (faltante == 0) {
            System.out.println("Proveedor pone tabaco y fosforos (falta papel)");
        } else if (faltante == 1) {
            System.out.println("Proveedor pone papel y fosforos (falta tabaco)");
        } else {
            System.out.println("Proveedor pone papel y tabaco (faltan fosforos)");
        }
        notifyAll();
    }

    public synchronized boolean cogerIngredientes(int miIngrediente) throws InterruptedException {
        while ((!mesaOcupada || ingredienteFaltante != miIngrediente) && !fin) {
            wait();
        }
        if (fin && !mesaOcupada) {
            return false;
        }
        mesaOcupada = false;
        ingredienteFaltante = -1;
        System.out.println("Fumador " + miIngrediente + " recoge los ingredientes de la mesa");
        notifyAll();
        return true;
    }

    public synchronized void terminarJornada() throws InterruptedException {
        while (mesaOcupada) {
            wait();
        }
        fin = true;
        notifyAll();
    }
}
