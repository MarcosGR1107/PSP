/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tallercostura;

/**
 *
 * @author 2DAM
 */
public class TallerCostura {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    int NumMangas = 40;
    int NumCuerpos = 20; //Siempre será la mitad, por cada cuerpo dos mangas
    
    int capacidadCestaMangas = 5;
    int capacidadCestaCuerpos = 5; 
        
    Taller miTaller = new Taller(capacidadCestaMangas, capacidadCestaCuerpos);
    
    Mangas construyeMangas = new Mangas(miTaller, NumMangas);
    construyeMangas.start();

    Cuerpos construyeCuerpos = new Cuerpos(miTaller, NumCuerpos);
    construyeCuerpos.start();

    Ensamblador miEnsamblador = new Ensamblador(miTaller, NumCuerpos);
    miEnsamblador.start();
    
    
    
    
    }
    
}
