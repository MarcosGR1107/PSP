/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package scannersinespera;

/**
Un centro dispone de un único escáner y de una bandeja con capacidad para tres documentos pendientes. 
* Cada usuario llega con un único documento. El escáner digitaliza un documento cada vez.   
* Implementa en Java una simulación con 1 hilo Escaner, 12 hilos Usuario y un monitor compartido CentroDigitalizacion. 
* La clase Main se encargará de crear e iniciar los hilos y de esperar a que termine la simulación.   
* FuncionamientoLlegada. Cada usuario espera entre 0 y 300 ms, elegidos al azar, antes de presentar su documento. 
* Todos los documentos entran al sistema por la bandeja.   Bandeja llena. Si la bandeja contiene tres documentos, el usuario espera hasta que pueda depositar el suyo. 
* Los usuarios que esperan una plaza pueden competir por ella al despertar. 
* El orden FIFO se aplica desde el momento en que cada documento se deposita.   
* Recogida. Si hay documentos en la bandeja, el escáner retira el primero que se depositó y libera una plaza en ese momento. 
* Si está vacía y aún faltan documentos por depositar, espera.   Digitalización. El escáner tarda entre 100 y 400 ms, elegidos al azar, en digitalizar un documento. 
* Durante ese tiempo, los usuarios pueden seguir depositando documentos si hay espacio.   Entrega. Después de depositar su documento, 
* cada usuario espera hasta que su propio documento esté digitalizado. En ese momento puede marcharse.   Cierre. Cuando el escáner va a recoger otro documento, 
* termina si la bandeja está vacía y ya se han depositado los 12 documentos. Main espera a que terminen los 12 usuarios y el escáner antes de mostrar SIMULACIÓN FINALIZADA
 */
public class Main {

    public static void main(String[] args) {
        CentroDigitalizacion centro = new CentroDigitalizacion();
        int numUsuarios = centro.getTotalUsuarios();

        Escaner escaner = new Escaner(centro);
        Usuario[] usuarios = new Usuario[numUsuarios];

        for (int i = 0; i < numUsuarios; i++) {
            int id = i + 1;
            usuarios[i] = new Usuario(id, id, centro);
        }

        escaner.start();
        for (Usuario usuario : usuarios) {
            usuario.start();
        }

        try {
            for (Usuario usuario : usuarios) {
                usuario.join();
            }
            escaner.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Hilo principal interrumpido.");
        }

        System.out.println("SIMULACIÓN FINALIZADA");
    }
}
