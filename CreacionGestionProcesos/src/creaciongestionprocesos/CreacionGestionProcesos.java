/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package creaciongestionprocesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author 2DAM
 */
public class CreacionGestionProcesos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            // Abre el bloc de notas
            Process proceso = Runtime.getRuntime().exec("notepad.exe");

            // Espera que el usuario cierre el bloc de notas
            proceso.waitFor();
            System.out.println("El proceso Notepad ha terminado");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Ejecutar 'ping' a Google.com 3 veces

            ProcessBuilder pb = new ProcessBuilder("ping","-n","3","www.google.com");
            Process proceso = pb.start();

            //Leer salida del comando
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            
            int exitCode = proceso.waitFor();
            System.out.println("El proceso terminó con código: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
//        try {
//            String comando = "ping -n 2 www.google.com";
//            Process[] procesos = new Process[3];
//
//            for (int i = 0; i < procesos.length; i++) {
//                procesos[i] = Runtime.getRuntime().exec(comando);
//                
//                int exitVal = procesos[i].waitFor();
//                System.out.println("Proceso " + (i + 1) + " terminó con estado: " + exitVal);
//            }
//        } catch (Exception e) {
//             e.printStackTrace();
//
//
//        }
    }

}
