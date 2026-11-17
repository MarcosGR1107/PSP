/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaDelBannoMixto;

/**
 *
 * @author marco
 */
class BanoMixto {

    final int CAPACIDAD = 3;
    int dentro = 0;
    int sexoActual = -1;
    int[] esperando = new int[2];
    int seguidos = 0;

    public synchronized void entrarBano(int id, int sexo) throws InterruptedException {
        int otroSexo = 1 - sexo;
        esperando[sexo]++;
        while (dentro == CAPACIDAD || (dentro > 0 && sexoActual != sexo) || (esperando[otroSexo] > 0 && seguidos >= CAPACIDAD)){
            wait();
        }
        esperando[sexo]--;
        if (dentro == 0) {
            sexoActual = sexo;
            seguidos = 0;
        }
        dentro++;
        seguidos++;
        String tipo = (sexo == 0) ? "Hombre" : "Mujer";
        System.out.println(tipo + " " + id + " entra al bano (Ocupacion: " + dentro + ")");
    }

    public synchronized void salirBano(int id, int sexo) {
        dentro--;
        String tipo = (sexo == 0) ? "Hombre" : "Mujer";
        System.out.println(tipo + " " + id + " sale del bano (Ocupacion: " + dentro + ")");
        if (dentro == 0) {
            int otroSexo = 1 - sexo;
            if (esperando[otroSexo] > 0) {
                sexoActual = otroSexo;
            } else {
                sexoActual = -1;
            }
            seguidos = 0;
        }
        notifyAll();
    }
}
