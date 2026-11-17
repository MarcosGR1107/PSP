/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BarberoDormilon;

/**
 *
 * @author 2DAM
 */
public class Barberia {

    int capacidad;
    int numeroClientesDelDia;

    int clientesDentro = 0;
    int clientesEsperandoBarbero = 0;
    boolean barberoDormido = false;

    int cantidadClientesPelados = 0;
    boolean hayClientesPendientes = true;
    
    int siguienteTurno;
    int ultimoTurnoTerminado;
    

    public Barberia(int capacidad, int numeroClientesDelDia) {
        this.capacidad = capacidad;
        this.numeroClientesDelDia = numeroClientesDelDia;
    }

    public synchronized void esperarClientes() {
        try {
            while (clientesEsperandoBarbero == 0) {
                System.out.println("Barbero durmiendo...");
                barberoDormido = true;
                wait();
            }

            barberoDormido = false;

            clientesEsperandoBarbero--; // Empieza un corte

        } catch (Exception e) {
            System.out.println("Error esperando clientes");
        }
    }

    public synchronized void llegaCliente(String nombre) {
        try {
            System.out.println("\nLlega " + nombre);
            while (clientesDentro == capacidad) {
                System.out.println(nombre + " espera fuera");
                wait();
            }

            clientesDentro++;
            clientesEsperandoBarbero++;
            System.out.println("Sentando " + nombre + ".\t" + clientesDentro + "/" + capacidad);

            if (barberoDormido) {
                barberoDormido = false;
                System.out.println("Despertando barbero para el cliente " + nombre);
                notifyAll();
            }
        } catch (Exception e) {
            System.out.println("Error en la llegada de un cliente");
        }
    }

    public synchronized void terminarCorte() {
        try {
            System.out.println("\nTerminando corte");
            clientesDentro--;
            System.out.println("Clientes dentro \t" + clientesDentro + "/" + capacidad);
            notifyAll();
            cantidadClientesPelados++;
            System.out.println("Clientes pelados:\t"+ cantidadClientesPelados);
            
        } catch (Exception e) {
            System.out.println("Error pelando cliente");
        }
    }

    public synchronized boolean clientesPendientes() {
        hayClientesPendientes = false;
        if (cantidadClientesPelados < numeroClientesDelDia) {
            hayClientesPendientes = true;
        }

        return hayClientesPendientes;
    }
}
