/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package konzol_nezet;

import java.util.ArrayList;
import modell.Konyv;
import modell.Konyvtar;

/**
 *
 * @author PauluszKristófCsanád
 */
public class KonyvtarKonzol {
    public static void main(String[] args) {
        Konyvtar konyvtar1 = new Konyvtar();
        Konyv k3 = new Konyv("A McDonald's Story", "Ray Croc", 1977);
        konyvtar1.addKonyv(k3);
        konyvtar1.addKonyv(k3);
        konyvtar1.mentes();
        
        // Állítsuk vissza a könyvtár állapotát egy új objektumba
        Konyvtar konyvtar2 = new Konyvtar(konyvtar1.beolvasas());
        megjelenit(konyvtar2);
    }

    private static void megjelenit(Konyvtar konyvtar) {
        System.out.println("Cím\tSzerző\tÉv");
        for (Konyv konyv : konyvtar.getKonyvek()) {
            if (konyv.getSzerzo().size() > 1) {
                System.out.println("");
            }
            else {}
        }
    }
}
