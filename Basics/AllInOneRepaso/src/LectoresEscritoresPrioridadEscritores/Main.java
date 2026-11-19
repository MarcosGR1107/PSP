/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LectoresEscritoresPrioridadEscritores;

/**
 *
 * @author marco
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        BaseDeDatos bd = new BaseDeDatos();
        Lector[] lectores = new Lector[6];
        Escritor[] escritores = new Escritor[3];
        for (int i = 0; i < 6; i++) {
            lectores[i] = new Lector(i + 1, bd);
            lectores[i].start();
        }
        for (int i = 0; i < 3; i++) {
            escritores[i] = new Escritor(i + 1, bd);
            escritores[i].start();
        }
        for (int i = 0; i < 6; i++) {
            lectores[i].join();
        }for (int i = 0; i < 3; i++) {
            escritores[i].join();
        }
        System.out.println("SIMULACION FINALIZADA");
    }
}
