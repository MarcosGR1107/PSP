/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaciongestionprocesos;

/**
 *
 * @author 2DAM
 */
public class Coche extends Thread {

    private String nombre;
    private int dorsal;
    private int distancia;

    public Coche(String nombre, int dorsal, int distancia) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.distancia = distancia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public void run() {
        int contador = 0;
        
        while (contador < this.distancia){
            System.out.println("["+this.dorsal+"] "+ nombre + " - posicion "+(contador+1));
            contador++;
        }
        System.out.println("META: [" + dorsal + "]"+nombre);
    }

    
}
