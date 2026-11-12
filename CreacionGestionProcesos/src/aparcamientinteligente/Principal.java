/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aparcamientinteligente;

import java.util.ArrayList;

/**
 *
 * @author 2DAM
 */
public class Principal {

    public static void main(String[] args) {
        try {
            Aparcamiento aparcamientoPrincipal = new Aparcamiento();

            ArrayList<Coche> coches = new ArrayList<>();

            for (int i = 1; i <= 8; i++) {
                Coche coche = new Coche("Coche " + i, aparcamientoPrincipal);
                coches.add(coche);
            }

            Thread[] h = new Thread[coches.size()];
            for (int i = 0; i < coches.size(); i++) {
                h[i] = new Thread(coches.get(i));
                h[i].start();
            }

        } catch (Exception e) {
            System.out.println("Error en la ejecución");
        }
    }
}
