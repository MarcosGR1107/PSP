/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainicial;

/**
 *
 * @author 2DAM
 */
public class Motocicleta extends Vehiculo {
    private int cilindrada;
    
    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
    public Motocicleta(int cilindrada, String matricula, String marca, int anioFabricacion) {
        super(matricula, marca, anioFabricacion);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularCostoViaje(double kilometros) {
        return kilometros * 0.1;
    }

    @Override
    public StringBuilder mostrarInformacion() {
        StringBuilder sb = super.mostrarInformacion();
        sb.append("Cilindrada: ").append(cilindrada);
        return sb;
    }


    
    
    
}
