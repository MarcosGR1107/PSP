public class Cliente extends Thread {
    private final int id;
    private final Barberia barberia;

    public Cliente(int id, Barberia barberia) {
        this.id = id;
        this.barberia = barberia;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 3000));
            barberia.llegaCliente(id);
        } catch (InterruptedException e) {
            interrupt();
        }
    }
}
