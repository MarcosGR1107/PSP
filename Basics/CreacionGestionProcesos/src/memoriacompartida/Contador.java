/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memoriacompartida;

/**
 *
 * @author 2DAM
 */
public class Contador {

    private int c;

    public Contador(int c) {
        this.c = c;
    }

//    public synchronized void incrementa() {
//        this.c++;
//    }
//
//    public synchronized void decrementa() {
//        this.c--;
//    }
//
//    public synchronized int valor() {
//        return c;
//    }

    public  void incrementa() {
        this.c++;
    }

    public  void decrementa() {
        this.c--;
    }

    public  int valor() {
        return c;
    }
}
