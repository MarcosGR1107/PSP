/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncocina;

/**
 *
 * @author 2DAM
 */
public class Principal {

    public static void main(String[] args) {
        Horno miHorno = new Horno("HORNO");

        Cocinero c1 = new Cocinero("Cocinero 1", miHorno);
        Cocinero c2 = new Cocinero("Cocinero 2", miHorno);
        Cocinero c3 = new Cocinero("Cocinero 3", miHorno);

        Thread h1 = new Thread(c1);
        Thread h2 = new Thread(c2);
        Thread h3 = new Thread(c3);

        h1.start();
        h2.start();
        h3.start();
    }
}
