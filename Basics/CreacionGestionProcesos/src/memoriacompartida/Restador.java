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
public class Restador implements Runnable {

    Contador c;
    String name;

    public Restador(String name, Contador c) {
        this.c = c;
        this.name = name;
    }

//    public void Restador(String name, Contador c){
//        c.decrementa();
//    }
    @Override
    public void run() {
        try {
            for (int cont = 0; cont < 300; cont++) {
                System.out.println("Restador - Contador:"+cont + " Valor: "+c.valor());
                c.decrementa();
                Thread.sleep(ThreadLocalRandom.current().nextInt(10, 31));
            }
        } catch (Exception e) {
            System.out.println("Error decrementando:\n" + e.getMessage());
        }
    }

}
