/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RadiadoAtomico;

/**
 *
 * @author marco
 */
class BufferRadiado {

    final int C = 3;
    final int N = 3;
    int[] buffer = new int[C];
    int[] lecturas = new int[C];
    int[] siguienteDeConsumidor = new int[N];
    int producidos = 0;

    public BufferRadiado() {
        for (int i = 0; i < C; i++) {
            lecturas[i] = N;
        }
    }

    public synchronized void depositar(int valor) throws InterruptedException {
        int pos = producidos % C;
        while (lecturas[pos] < N) {
            System.out.println("Productor esperando hueco en buffer...");
            wait();
        }
        buffer[pos] = valor;
        lecturas[pos] = 0;
        producidos++;
        System.out.println("Productor deposita elemento " + valor + " en posicion " + pos);
        notifyAll();
    }

    public synchronized int extraer(int idConsumidor) throws InterruptedException {
        int indice = siguienteDeConsumidor[idConsumidor];
        while (indice >= producidos) {
            wait();
        }
        int pos = indice % C;
        int valor = buffer[pos];
        lecturas[pos]++;
        siguienteDeConsumidor[idConsumidor]++;
        System.out.println("Consumidor " + idConsumidor + " lee elemento " + valor + " (Lecturas: " + lecturas[pos] + "/" + N + ")");
        notifyAll();
        return valor;
    }
}
