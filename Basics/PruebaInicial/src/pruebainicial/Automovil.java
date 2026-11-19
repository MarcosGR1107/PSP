/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainicial;

/**
 *
 * @author 2DAM
 */
public class Automovil extends Vehiculo {
    private int numeroPasajeros;

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public Automovil(int numeroPasajeros, String matricula, String marca, int anioFabricacion) {
        super(matricula, marca, anioFabricacion);
        this.numeroPasajeros = numeroPasajeros;
    }

    @Override
    public double calcularCostoViaje(double kilometros) {
        return kilometros * 0.2;
    }

    @Override
    public StringBuilder mostrarInformacion() {
        StringBuilder sb = super.mostrarInformacion();
        sb.append("Número de pasajeros: ").append(numeroPasajeros);
        return sb;
    }
}