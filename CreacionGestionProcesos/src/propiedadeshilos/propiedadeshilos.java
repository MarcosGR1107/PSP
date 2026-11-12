/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package propiedadeshilos;

/**
 *
 * @author 2DAM
 */
public class propiedadeshilos {

    public static void main(String[] args) {

//        hiloConPausa();
//        hilosSimultaneosYLambda();
//        comprobarHiloActivo();
        prioridadesHilo();
    }

    public static void hiloConPausa() {
        Contador miContador1 = new Contador();
        Thread hilo1 = new Thread(miContador1);
        hilo1.start();
        System.out.println(hilo1.getName());

    }

    public static void hilosSimultaneosYLambda() {
        Runnable runnable1 = () -> {
            try {
                int contador = 0;
                int finalContador = 10;

                while (contador <= finalContador) {
                    System.out.println("Cuenta actual del primer runable: " + contador);
                    contador++;
                    Thread.sleep(500);
                }
            } catch (Exception e) {
                System.out.println("Error\n" + e.toString());
            }

        };

        Runnable runnable2 = () -> {
            try {
                int contador = 0;
                int finalContador = 10;

                while (contador <= finalContador) {
                    System.out.println("Cuenta actual del segundo runable: " + contador);
                    contador++;
                    Thread.sleep(700);

                }
            } catch (Exception e) {
                System.out.println("Error\n" + e.toString());
            }
        };

        Thread hilo1 = new Thread(runnable1);
        Thread hilo2 = new Thread(runnable2);

        hilo1.start();
        hilo2.start();

    }

    public static void comprobarHiloActivo() {
        try {
            Contador miContador1 = new Contador(1, 5);
            Thread hilo1 = new Thread(miContador1);
            System.out.println("Estado 1: " + (hilo1.isAlive() ? "Corriendo" : "Ahora no"));

            hilo1.start();
            Thread.sleep(500);
            System.out.println("Estado 2: " + (hilo1.isAlive() ? "Corriendo" : "Ahora no"));

            Thread.sleep(6000);
            System.out.println("Estado 3: " + (hilo1.isAlive() ? "Corriendo" : "Ahora no"));
        } catch (Exception e) {
            System.out.println("Error\n" + e.toString());
        }
    }

    public static void prioridadesHilo() {
        try {
            ContadorDos miContador = new ContadorDos();

            Thread hilo1 = new Thread(miContador);
            Thread hilo2 = new Thread(miContador);
            Thread hilo3 = new Thread(miContador);

            hilo1.start();
            System.out.println("Prioridad hilo 1 : " + hilo1.getPriority());
            hilo1.setPriority(Thread.MIN_PRIORITY);
            System.out.println("Prioridad: "+ hilo1.getPriority() + "Activo? "+ (hilo1.isAlive() ? "Si":"No"));

            hilo2.start();
            System.out.println("Prioridad hilo 2 : " + hilo2.getPriority());
            hilo2.setPriority(Thread.NORM_PRIORITY);
            System.out.println("Prioridad: "+ hilo2.getPriority() + "Activo? "+ (hilo2.isAlive() ? "Si":"No"));
            
            
            hilo3.start();
            System.out.println("Prioridad hilo 3 : " + hilo3.getPriority());
            hilo3.setPriority(Thread.MAX_PRIORITY);
            System.out.println("Prioridad: "+ hilo3.getPriority() + "Activo? "+ (hilo3.isAlive() ? "Si":"No"));

            Thread.sleep(12000);
            System.out.println("Prioridad hilo 1 : " + hilo1.getPriority());
            System.out.println("Prioridad hilo 2 : " + hilo2.getPriority());
            System.out.println("Prioridad hilo 3 : " + hilo3.getPriority());

        } catch (Exception e) {
            System.out.println("Error \n" + e.toString());
        }
    }

}
