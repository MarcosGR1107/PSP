/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Main;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Tecnico extends Thread {

    Taller miTaller;

    public Tecnico(Taller miTaller) {
        this.miTaller = miTaller;
    }

    @Override
    public void run() {
        try {
            miTaller.tecnicoEmpiezaTrabajar();
            System.out.println("\nTECNICO EMPIEZA A TRABAJAR\n");
            
            while(!miTaller.todosClientesProcesados()){
                System.out.println("DENTRO");
                    miTaller.recogerMovil();
                    Thread.sleep(ThreadLocalRandom.current().nextInt(100, 400));
                    
                    miTaller.repararMovil();
                    miTaller.esperarRetiradaTecnico();
                    
            }
            System.out.println("\nTecnico ha terminado de reparar");
            
        } catch (Exception e) {
            System.out.println("Error tecnico: \n" + e.getMessage());
        }
    }
}
