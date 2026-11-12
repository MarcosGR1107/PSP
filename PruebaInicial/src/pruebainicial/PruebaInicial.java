/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebainicial;

import gestionarinstituto.Entrada;

/**
 *
 * @author 2DAM
 */
public class PruebaInicial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int opcion = menu();
        switch (opcion){
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4: 
                
                break;
            
        }
    }
    
    public static int menu(){
        int op;
        System.out.println("1 - Crear Coche ");
        System.out.println("2 - Crear Moto ");
        System.out.println("3 - Crear Camion ");
        System.out.println("Mostrar información de todos los vehículos");
        op = Entrada.leerEntero("\nElija opción:");
        return op;
    }
    
    
    public static void verDatos(Vehiculo[] vehiculos){
        
    }
    
    
    
}
