/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TallerMecánico;

/**
 *
 * @author 2DAM
 */
public class Mecanico extends Thread {
    Taller miTaller;

    public Mecanico(Taller miTaller) {
        this.miTaller = miTaller;
    }
    
    
    @Override
    public void run() {
        while(true){
            try {
                int numero = miTaller.cogerCoche();
                
                if(numero == 0){
                    break;
                }
                
                System.out.println("Mecanico reparando coche " + numero);
            } catch (InterruptedException ex) {
                System.getLogger(Mecanico.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            
        }
    }
    
    
}
