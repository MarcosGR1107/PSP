/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainicial;

/**
 *
 * @author 2DAM
 */
public class Camion extends Vehiculo {
    private double toneladasCapacidad;

    public double getToneladasCapacidad() {
        return toneladasCapacidad;
    }

    public void setToneladasCapacidad(double toneladasCapacidad) {
        this.toneladasCapacidad = toneladasCapacidad;
    }

    public Camion(double toneladasCapacidad, String matricula, String marca, int anioFabricacion) {
        super(matricula, marca, anioFabricacion);
        this.toneladasCapacidad = toneladasCapacidad;
    }
    
    @Override
    public double calcularCostoViaje(double kilometros) {
        double costeKilometraje = kilometros * 0.35; 
        double costeToneladas = this.getToneladasCapacidad() * 10;
        return costeKilometraje + costeToneladas;
    }

    @Override
    public StringBuilder mostrarInformacion() {
    StringBuilder sb = super.mostrarInformacion();
        sb.append("Toneladas de capacidad: ").append(toneladasCapacidad);
    return sb; 
    }
    
    
    
}
