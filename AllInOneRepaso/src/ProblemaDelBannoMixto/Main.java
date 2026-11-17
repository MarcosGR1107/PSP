/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaDelBannoMixto;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        BanoMixto bano = new BanoMixto();
        Persona[] personas = new Persona[10];
        for (int i = 0; i < 10; i++) {
            int sexo = i % 2;
            personas[i] = new Persona(i + 1, sexo, bano);
            personas[i].start();
        }
        for (int i = 0; i < 10; i++) {
            personas[i].join();
        }
        System.out.println("SIMULACION FINALIZADA");
    }
}
