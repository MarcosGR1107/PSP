/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorprocesosavanzado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
/**
 *
 * @author marco
 */
public class EcoDatos {

    public String fraseMayus(String frase) {
        return frase.toUpperCase();
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in, "UTF-8")
            );
            
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea.toUpperCase());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
