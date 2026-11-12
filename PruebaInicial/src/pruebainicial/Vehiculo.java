/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebainicial;

/**
 *
 * @author 2DAM
 */
public abstract class Vehiculo {
    private String matricula;
    private String marca;
    private int anioFabricacion;

    public Vehiculo(String matricula, String marca, int anioFabricacion) {
        this.matricula = matricula;
        this.marca = marca;
        this.anioFabricacion = anioFabricacion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    
    public abstract double calcularCostoViaje(double kilometros);
    
    public StringBuilder mostrarInformacion(){
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: ").append(this.getMarca());
        sb.append("Matrícula: ").append(this.getMatricula());
        sb.append("Año de fabricación: ").append(this.getAnioFabricacion());
        
        return sb;
    }
    
}
