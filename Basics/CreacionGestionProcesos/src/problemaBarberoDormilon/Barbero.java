/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package problemaBarberoDormilon;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Barbero extends Thread {

    Barberia miBarberia;
    int clientesPelados = 0;

    public Barbero(Barberia miBarberia) {
        this.miBarberia = miBarberia;
    }

    @Override
    public void run() {
        try {
//            while (clientesPelados < 10) {
//                miBarberia.esperarClientes();
//                System.out.println("Empezando corte");
//                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1501));
//                miBarberia.terminarCorte();
//                clientesPelados++;
//                System.out.println("Clientes pelados: " + clientesPelados);
//            }

//            for (int cli = 0 ; cli < 10; cli++) {
//                miBarberia.esperarClientes();
//                System.out.println("Empezando corte");
//                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1501));
//                miBarberia.terminarCorte();
//                clientesPelados++;
//                System.out.println("Clientes pelados: " + clientesPelados);
//            }
            
            while(miBarberia.clientesPendientes()){
                miBarberia.esperarClientes();
                System.out.println("Empezando corte");
                Thread.sleep(ThreadLocalRandom.current().nextInt(100, 1501));
                miBarberia.terminarCorte();
            }
            
            
            
        } catch (InterruptedException ex) {
            System.getLogger(Barbero.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

}
