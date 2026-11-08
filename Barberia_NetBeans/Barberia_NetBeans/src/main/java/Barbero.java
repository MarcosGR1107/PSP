public class Barbero extends Thread {
    private final Barberia barberia;

    public Barbero(Barberia barberia) {
        this.barberia = barberia;
    }

    @Override
    public void run() {
        try {
            while (true) {
                barberia.esperarCliente();
                System.out.println("Barbero empieza un corte");
                Thread.sleep(2000);
                barberia.terminarCorte();
            }
        } catch (InterruptedException e) {
            interrupt();
        }
    }
}
