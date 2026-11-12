/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aparcamientinteligente;

/**
 *
 * @author 2DAM
 */
public class Aparcamiento {

    private int numMaxPlazas = 3;
    private int numPlazasDisponibles = 3;

    public int getNumMaxPlazas() {
        return numMaxPlazas;
    }

    public void setNumMaxPlazas(int numMaxPlazas) {
        this.numMaxPlazas = numMaxPlazas;
    }

    public int getNumPlazasDisponibles() {
        return numPlazasDisponibles;
    }

    public void setNumPlazasDisponibles(int numPlazasDisponibles) {
        this.numPlazasDisponibles = numPlazasDisponibles;
    }

    public synchronized void entrar(String coche) {
        try {
            while( this.numPlazasDisponibles == 0){
                System.out.println(coche + " espera. Apartamiento completo.");
                wait();
            }
            
            if (this.getNumPlazasDisponibles() > 0) {
                System.out.println("Ocupando una plaza con el coche " + coche);
                this.setNumPlazasDisponibles(this.getNumPlazasDisponibles() - 1);
                System.out.println("Plaza ocupada, quedan " + this.getNumPlazasDisponibles() + " plazas libres.");
            }

        } catch (Exception e) {
            System.out.println("Error ocupando plaza:\n" + e.getMessage());
        }
    }

    public synchronized void salir(String coche) {
        try {
            
            if (this.getNumPlazasDisponibles() <= this.getNumMaxPlazas()) {
                System.out.println("Liberando plaza del coche " + coche);
                this.setNumPlazasDisponibles(this.getNumPlazasDisponibles() + 1);
                System.out.println("Plaza liberada, quedan " + this.getNumPlazasDisponibles() + " plazas libres.");
            } else {
                System.out.println("No hay coches en el parking");
            }
            this.notify();
        } catch (Exception e) {
            System.out.println("Error liberando plaza:\n" + e.getMessage());
        }

    }

}
