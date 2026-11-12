package filosofoscomensales;

public class FilosofosComensales {

    public static void main(String[] args) {
        int numFilosofos = 5;
        int numRondas = 3;
        
        Filosofo[] filosofos = new Filosofo[numFilosofos];
        Mesa miMesa = new Mesa(numFilosofos);
        
        for (int i = 0; i < filosofos.length; i++ ){
            Filosofo filosofo = new Filosofo(i+1, miMesa, numRondas);
            filosofo.start();
        }
        
    }
    
}
