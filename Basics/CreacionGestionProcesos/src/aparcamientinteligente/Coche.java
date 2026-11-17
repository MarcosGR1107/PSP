/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aparcamientinteligente;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Coche extends Thread {
    String nombre;
    Aparcamiento aparcamiento;
    public Coche(String nombre, Aparcamiento aparcamiento) {
        this.nombre = nombre;
        this.aparcamiento = aparcamiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try{
            aparcamiento.entrar(this.nombre);
            Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5001));
            aparcamiento.salir(this.nombre);
        }catch(Exception e){
            System.out.println("Error:\n"+e.getMessage());
        }
    }
    
    
}
