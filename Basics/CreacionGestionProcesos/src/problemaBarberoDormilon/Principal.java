/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemaBarberoDormilon;

/**
 *
 * @author 2DAM
 */
public class Principal {
    public static void main(String[] args) {
        int capacidadBarberia = 6;
        int cantidadClientes = 10;
        
        
        
        Barberia nuevaBarberia = new Barberia(capacidadBarberia, cantidadClientes);
        Barbero miBarber = new Barbero(nuevaBarberia);
        miBarber.start();
        for (int i = 1; i <= cantidadClientes; i++){
            String nombreCliente = "Cliente "+ i;
            Cliente cliente = new Cliente(nombreCliente, nuevaBarberia);
            cliente.start();
        }
        
        
    }
}
