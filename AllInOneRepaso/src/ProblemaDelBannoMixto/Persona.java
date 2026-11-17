/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProblemaDelBannoMixto;

/**
 *
 * @author marco
 */
class Persona extends Thread {

    int id;
    int sexo;
    BanoMixto bano;

    public Persona(int id, int sexo, BanoMixto bano) {
        this.id = id;
        this.sexo = sexo;
        this.bano = bano;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 2000));
            bano.entrarBano(id, sexo);
            Thread.sleep(500 + (int) (Math.random() * 1000));
            bano.salirBano(id, sexo);
        } catch (InterruptedException e) {
            System.out.println("Error en persona " + id);
        }
    }
}
