/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicasyncronyze;

/**
 *
 * @author 2DAM
 */
public class Empleado extends Thread {
    Impresora impresora;
    String nombreDoc;

    public Empleado(Impresora impresora, String nombreDoc) {
        this.impresora = impresora;
        this.nombreDoc = nombreDoc;
    }


    public String getNombreDoc() {
        return nombreDoc;
    }

    public void setNombreDoc(String nombreDoc) {
        this.nombreDoc = nombreDoc;
    }

    public Impresora getImpresora() {
        return impresora;
    }

    public void setImpresora(Impresora impresora) {
        this.impresora = impresora;
    }

    @Override
    public void run() {
            this.impresora.imprimir(nombreDoc, 5);
    }

}
