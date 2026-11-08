/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaciongestionprocesos;

/**
 *
 * @author 2DAM
 */
public class Corredor implements Runnable{
    private String nombre;
    private int countUp = 0;

    public Corredor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public static void main(String[] args){
    Corredor pepe = new Corredor("Pepe");
    Corredor ana = new Corredor("Ana");
    
    Thread hilo = new Thread(pepe);
    Thread hilo2 = new Thread(ana);
        hilo.start();
        hilo2.start();
    }
    
    @Override
    public void run() {
        System.out.println("Lanzamiento (" + nombre + ")");
        while (countUp < 5) {
            System.out.println("#" + nombre + " (" + (countUp+1) + ")");
            countUp++;
        }
    }
    
    
}
