/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestorprocesosavanzado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author 2DAM
 */
public class GestorProcesosAvanzado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int opcion = menu();
        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    lanzarUtilidades();
                    break;
                case 2:
                    lanzarPings();
                    break;
                case 3:
                    lanzarEcoDatos();
                    break;
                default:
            }
            System.out.println("\n");
            opcion = menu();
        }
        System.out.println("Fin de la ejecucion de la aplicacion.");
    }

    public static int menu() {
        int opcion;
        System.out.println("Gestion de Procesos");
        System.out.println("-----------------------------");
        System.out.println("1. Lanzar tres utilidades de Windows.");
        System.out.println("2. Lanzar Pings a Microsoft y Apple y ver respuesta.");
        System.out.println("3. EcoDatos");
        System.out.println("0. Salir");
        opcion = Entrada.leerEntero("\nOpcion?: ");
        return opcion;
    }

    public static void lanzarUtilidades() {

        try {
            System.out.println("Lanzando procesos ...");

            Process[] procesos = new Process[3];

            /**
             * Muestra el nombre de usuario y el identificador de seguridad del
             * usuario que ejecuta el proceso
             *
             * El parámetro /user indica al sistema que se quiere ver la
             * información del usuario.
             */
            procesos[0] = Runtime.getRuntime().exec("whoami /user");

            /**
             * Abre el servicio cmd de windows
             *
             * El parámetro /c start, abre una página en el navegador por
             * defecto y cierra la ventana de comandos.
             *
             */
            procesos[1] = Runtime.getRuntime().exec("cmd /c start https://google.com");

            /**
             * Control.exe abre en una ventana el panel de control de Windows.
             *
             * El parámetro /name Microsoft.WindowsUpdate abre la ventana de
             * actualizaciones de Windows.
             */
            procesos[2] = Runtime.getRuntime().exec("control /name Microsoft.WindowsUpdate");

            for (int i = 0; i <= procesos.length - 1; i++) {
                // Si no existe el proceso (en pruebas esta pasando) lo salta y no da el error
                if (procesos[i] == null) {
                    continue;
                }
                int exitVal = procesos[i].waitFor();
                System.out.println("Proceso " + (i + 1) + " terminado con estado: " + exitVal);
            }

        } catch (Exception e) {
            System.out.println("Error con el proceso\n" + e.getMessage());
        }

    }

    public static void lanzarPings() {
        try {
            String comandoMicrosoft = "ping -n 4 www.microsoft.com";
            String comandoApple = "ping -n 4 www.apple.com";

            Process[] procesos = new Process[2];
            procesos[0] = Runtime.getRuntime().exec(comandoMicrosoft);
            procesos[1] = Runtime.getRuntime().exec(comandoApple);

            for (int i = 0; i <= procesos.length - 1; i++) {

                System.out.println("\nPing " + (i + 1));

                BufferedReader reader = new BufferedReader(new InputStreamReader(procesos[i].getInputStream()));

                String linea;

                int contador = 0;
                while (contador < 4 && (linea = reader.readLine()) != null) {
                    System.out.println(linea);
                    contador++;
                }
                while ((linea = reader.readLine()) != null) {
//                    Para comprobaciones
//                    System.out.println(linea);
                }

                int exitVal = procesos[i].waitFor();
                System.out.println("Terminado con estado: " + exitVal);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void lanzarEcoDatos() {

        try {
            System.out.println("Lanzando proceso EcoDatos...");
            String comando = "java -cp build/classes gestorprocesosavanzado.EcoDatos";
            Process proceso = Runtime.getRuntime().exec(comando);

            /**
             * Entrada / Salida (Lo que enviamos, lo que devuelve) a la clase EcoDatos.
             * 
             * Codificación UTF-8 
             */
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(
                            proceso.getOutputStream(), "UTF-8")
            );

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            proceso.getInputStream(), "UTF-8")
            );

            /**
             * Gestión de los mensajes
             * 
             * Importante el .close para que no se quede abierto el proceso y EcoDatos no quede a la espera de nuevos mensajes.
             */
            char continuar;
            do {
                String mensaje = Entrada.leerCadena("\nIntroduce un mensaje");
                writer.write(mensaje);
                writer.newLine();

                continuar = Entrada.leerCaracter("\nDesea introducir otra frase?\n-- Escriba 's' para continuar\n-- Cualquier otro caracter para salir al menu principal");
            } while (continuar == 's');

            writer.close();
            
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("\nEcoDatos: " + linea);
            }

            int exitVal = proceso.waitFor();
            System.out.println("\nProceso terminado con estado: " + exitVal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
