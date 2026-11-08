/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package propiedadeshilos;

import java.util.Scanner;

/**
 *
 * @author 2DAM
 */
public class Contador implements Runnable{
    private int contador;
    private int finalContador;

    public Contador(int contador, int finalContador) {
        this.contador = contador;
        this.finalContador = finalContador;
    }

    public Contador(){
        this.contador = 1;
        this.finalContador = 5;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getFinalContador() {
        return finalContador;
    }

    public void setFinalContador(int finalContador) {
        this.finalContador = finalContador;
    }
    
    
    @Override
    public void run() {
        try{
        while(contador <= finalContador){
            System.out.println("Cuenta actual: "+contador);
            contador++;
            Thread.sleep(1000);
        }}catch(Exception e){
            System.out.println("Error\n"+e.toString());
        }
    }
    
}
