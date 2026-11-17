/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package memoriacompartida;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Sumador extends Thread {

    Contador c;
    String name;

    public Sumador(String name, Contador c) {
        this.c = c;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            for (int cont = 0; cont < 300; cont++) {
                System.out.println("Sumador - Contador:" + cont + " Valor: " + c.valor());
                c.incrementa();
                // El ThreadLocalRandom.current() es el aleatorio
                // El nextInt(50, 151) es el rango, desde 50 hasta 150 (uno menos que el final)
                Thread.sleep(ThreadLocalRandom.current().nextInt(10,31));
            }

        } catch (Exception e) {
            System.out.println("Error incrementando:\n" + e.getMessage());
        }
    }

}
