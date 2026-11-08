/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practicasyncronyze;

import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author 2DAM
 */
public class Impresora {

    String documento;
    int paginas;

    public Impresora(String documento, int paginas) {
        this.documento = documento;
        this.paginas = paginas;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public void imprimir(String documento, int paginas) {
        synchronized (this) {
            System.out.println("EMPEZANDO IMPRESIÓN DE "+ documento.toUpperCase());
            try {
                for (int i = 1; i <= paginas; i++) {
                    System.out.println("Documento " + documento + " Página: " + i);
//            Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1001));
                    Thread.sleep(500);
                }
                System.out.println("Impresión Finalizada para " + documento + "\n");
            } catch (Exception e) {
                System.out.println("Error imprimiendo: " + e.getMessage());
            }
        }
    }

}
