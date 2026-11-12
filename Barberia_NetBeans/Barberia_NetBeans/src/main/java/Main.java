public class Main {
    public static void main(String[] args) {
        Barberia barberia = new Barberia();
        new Barbero(barberia).start();
        for (int i = 1; i <= 10; i++) {
            new Cliente(i, barberia).start();
        }
    }
}
