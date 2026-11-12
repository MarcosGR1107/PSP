/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package creaciongestionprocesos;

/**
 *
 * @author 2DAM
 */
public class Carrera {
    public static void main(String[] args){
        Coche coche1 = new Coche("Ferrari",7,20);
        Coche coche2 = new Coche("Mercedes",3,20);
        Coche coche3 = new Coche("Red Bull",1,20);
        Coche coche4 = new Coche("McLaren",4,20);
    
        System.out.println("===== COMIENZA LA CARRERA =====");
        coche1.start();
        coche2.start();
        coche3.start();
        coche4.start();
        System.out.println("===== TODOS LOS COCHES HAN SALIDO =====");
    }

    

}
