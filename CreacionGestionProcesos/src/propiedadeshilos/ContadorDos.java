/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package propiedadeshilos;

/**
 *
 * @author 2DAM
 */
public class ContadorDos implements Runnable {

    private int contador;
    private int finalContador;

    public ContadorDos(int contador, int finalContador) {
        this.contador = contador;
        this.finalContador = finalContador;
    }

    public ContadorDos() {
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
        try {
            for (int i = 1; i <= 3; i++) {
                System.out.println("Cuenta: " + i);
                Thread.sleep(1000);

            }
            Thread hilo1 = new Thread(new ContadorDos());
            System.out.println("Hilo: "+hilo1.getName() + " Prioridad: "+ hilo1.getPriority());

        } catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }
    }

}
