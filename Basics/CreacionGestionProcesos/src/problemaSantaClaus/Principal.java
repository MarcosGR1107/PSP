/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemaSantaClaus;


/**
 *
 * @author 2DAM
 */
public class Principal {
    public static void main(String[] args) {
        Taller tallerPrueba = new Taller();
        SantaClaus santa = new SantaClaus(tallerPrueba);
        
        santa.start();
        
        for(int i = 1; i <=9; i++){
            Reno reno = new Reno(i, tallerPrueba);
            reno.start();
        }
        for(int i = 1; i <= 20; i++){
            
        }
        
    
    }
    
}
